package com.example.dojunioraosenior

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class JogadorAdaptor(
    private var jogadores: List<Jogador>,
    private val context: Context
) : RecyclerView.Adapter<JogadorAdaptor.JogadorViewHolder>() {

    private val db: JogadorDatabaseHelper = JogadorDatabaseHelper(context)

    class JogadorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeTextView: TextView = itemView.findViewById(R.id.jogadorNomeView)
        val dinheiroTextView: TextView = itemView.findViewById(R.id.jogadorDinheiroView)
        val updateButton: ImageView = itemView.findViewById(R.id.updateButton)
        val deleteButton: ImageView = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogadorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jogador_item, parent, false)
        return JogadorViewHolder(view)
    }

    override fun getItemCount(): Int = jogadores.size

    override fun onBindViewHolder(holder: JogadorViewHolder, position: Int) {
        val jogador = jogadores[position]
        holder.nomeTextView.text = jogador.nome
        holder.dinheiroTextView.text = "R$ %.2f".format(jogador.dinheiro)

        holder.updateButton.setOnClickListener {
            val intent = Intent(holder.itemView.context, UpdateJogadorActivity::class.java).apply {
                putExtra("jogador_id", jogador.id)
            }
            holder.itemView.context.startActivity(intent)
        }

        holder.deleteButton.setOnClickListener{
            db.deleteJogador(jogador.id)
            refreshData(db.getAllJogadores())
            Toast.makeText(holder.itemView.context, "Jogador excluido", Toast.LENGTH_SHORT).show()
        }
    }

    fun refreshData(newJogadores: List<Jogador>) {
        jogadores = newJogadores
        notifyDataSetChanged()
    }
}
