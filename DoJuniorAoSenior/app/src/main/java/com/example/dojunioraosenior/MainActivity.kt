package com.example.dojunioraosenior

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dojunioraosenior.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: JogadorDatabaseHelper
    private lateinit var jogadorAdaptor: JogadorAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = JogadorDatabaseHelper(this)
        jogadorAdaptor = JogadorAdaptor(db.getAllJogadores(), this)

        binding.jogadoresRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.jogadoresRecyclerView.adapter = jogadorAdaptor

        binding.addButton.setOnClickListener {
            val intent = Intent(this, AddJogador::class.java)
            startActivity(intent)
        }

        binding.rulesButton.setOnClickListener {
            val intent = Intent(this, RegrasActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onResume(){
        super.onResume()
        jogadorAdaptor.refreshData(db.getAllJogadores())
    }
}