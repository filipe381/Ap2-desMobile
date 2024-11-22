package com.example.ap2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class finalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        // Recuperando o resultado enviado pela quizActivity (a soma final)
        val resultadoFinal = intent.getIntExtra("resultadoFinal", 0) // Recupera o resultado como um inteiro
        // Recuperando o nome do usuário (exemplo)
        val nomeUsuario = intent.getStringExtra("nomeUsuario") ?: "Usuário" // Usa "Usuário" como padrão, caso não tenha sido enviado

        // Determinando a classificação do resultado de forma mais pessoal
        val resultadoTexto = when {
            resultadoFinal < -2 -> "$nomeUsuario, seus hábitos de proteção de dados estão abaixo do ideal. Você pode melhorar muito!"
            resultadoFinal in -1..8 -> "$nomeUsuario, seus hábitos de proteção de dados são decentes, mas sempre há espaço para aprimorar!"
            else -> "$nomeUsuario, parabéns! Seus hábitos de proteção de dados são excelentes. Continue assim!"
        }

        // Exibindo o resultado na tela
        val tvTexto = findViewById<TextView>(R.id.tv_texto)
        tvTexto.text = "$resultadoTexto"

        val btnAbrirPagina = findViewById<Button>(R.id.bt_intent)
        btnAbrirPagina.setOnClickListener {
            // Criando a Intent implícita para abrir uma página web
            val uri = Uri.parse("https://www.kaspersky.com.br/resource-center/preemptive-safety/how-to-protect-personal-online-privacy")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

    }
}
