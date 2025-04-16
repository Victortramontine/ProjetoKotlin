package com.example.dojunioraosenior

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dojunioraosenior.databinding.ActivityUpdateJogadorBinding

class UpdateJogadorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateJogadorBinding
    private lateinit var db: JogadorDatabaseHelper
    private var jogadorId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateJogadorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = JogadorDatabaseHelper(this)

        jogadorId = intent.getIntExtra("jogador_id", -1)
        if(jogadorId == -1){
            finish()
            return
        }

        val jogador = db.getJogadorById(jogadorId)
        binding.updateNomeJogador.setText(jogador.nome)
        binding.updateDinheiroJogador.setText(jogador.dinheiro.toString())

        binding.updateSaveButton.setOnClickListener {
            val newNome = binding.updateNomeJogador.text.toString()
            val newDinheiro = binding.updateDinheiroJogador.text.toString().toDoubleOrNull() ?: 0.0
            val updateJogador = Jogador(jogadorId, newNome, newDinheiro)
            db.updateJogador(updateJogador)
            finish()
            Toast.makeText(this, "Alterações salvas", Toast.LENGTH_SHORT).show()
        }
    }
}