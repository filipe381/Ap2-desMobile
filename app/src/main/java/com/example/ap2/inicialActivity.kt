package com.example.ap2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class inicialActivity : AppCompatActivity() {

    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicial)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editText = findViewById<EditText>(R.id.et_nome)
        val btnIniciar = findViewById<Button>(R.id.bt_intent)

        btnIniciar.setOnClickListener {
            val userInput = editText.text.toString().trim() // Remove espaços extras

            if (userInput.isEmpty()) {
                Toast.makeText(this, "insira seu nome", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Bem Vindo, $userInput!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,quizActivity::class.java)
                intent.putExtra(listaPerguntas.nomeUsuario, editText.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}