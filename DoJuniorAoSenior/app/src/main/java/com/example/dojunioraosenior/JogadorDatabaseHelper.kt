package com.example.dojunioraosenior

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class JogadorDatabaseHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    companion object{
        private const val DATABASE_NAME = "DoJuniorAoSenior.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "jogadores"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NOME = "nome"
        private const val COLUMN_DINHEIRO = "dinheiro"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_NOME TEXT, $COLUMN_DINHEIRO DECIMAL)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVerion: Int, newVersion: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableQuery)
        onCreate(db)
    }

    fun insertJogador(jogador: Jogador){
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NOME, jogador.nome)
            put(COLUMN_DINHEIRO, jogador.dinheiro)
        }
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getAllJogadores(): List<Jogador>{

        val jogadorList = mutableListOf<Jogador>()
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME ORDER BY $COLUMN_DINHEIRO DESC"
        val cursor = db.rawQuery(query, null)

        while (cursor.moveToNext()){
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
            val nome = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOME))
            val dinheiro = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_DINHEIRO))

            val jogador = Jogador(id, nome, dinheiro)
            jogadorList.add(jogador)
        }
        cursor.close()
        db.close()
        return jogadorList
    }

    fun updateJogador(jogador: Jogador){
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NOME, jogador.nome)
            put(COLUMN_DINHEIRO, jogador.dinheiro)
        }
        val whereClause = "$COLUMN_ID = ?"
        val whereArgs = arrayOf(jogador.id.toString())
        db.update(TABLE_NAME, values, whereClause, whereArgs)
        db.close()
    }

    fun getJogadorById(jogadorId: Int): Jogador{
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_ID = $jogadorId"
        val cursor = db.rawQuery(query, null)
        cursor.moveToFirst()

        val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
        val nome = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOME))
        val dinheiro = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_DINHEIRO))

        cursor.close()
        db.close()
        return Jogador(id, nome, dinheiro)
    }

    fun deleteJogador(jogadorId: Int){
        val db = writableDatabase
        var whereClause = ("$COLUMN_ID = ?")
        val whereArgs = arrayOf(jogadorId.toString())
        db.delete(TABLE_NAME, whereClause, whereArgs)
        db.close()
    }
}