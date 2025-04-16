package com.example.dojunioraosenior

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dojunioraosenior.databinding.ActivityAddJogadorBinding

class AddJogador : AppCompatActivity() {

    private lateinit var binding: ActivityAddJogadorBinding
    private lateinit var db: JogadorDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddJogadorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = JogadorDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val nome = binding.nomeJogador.text.toString()
            val dinheiro = binding.dinheiroJogador.text.toString().toDoubleOrNull() ?: 0.0
            val jogador = Jogador(0,nome, dinheiro)
            db.insertJogador(jogador)
            finish()
            Toast.makeText(this, "Jogador salvo", Toast.LENGTH_SHORT).show()
        }
    }
}