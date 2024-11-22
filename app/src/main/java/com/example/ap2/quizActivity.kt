package com.example.ap2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class quizActivity : AppCompatActivity() {

    private var currentQuestionIndex = 0 // Índice da pergunta atual
    private var totalResultado = 0 // Variável para armazenar a soma total dos resultados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referências aos elementos da interface
        val op1 = findViewById<TextView>(R.id.op1)
        val op2 = findViewById<TextView>(R.id.op2)
        val op3 = findViewById<TextView>(R.id.op3)
        val textViewPergunta = findViewById<TextView>(R.id.textView2)
        val progressBar = findViewById<ProgressBar>(R.id.barraProgresso)
        val contagemProgresso = findViewById<TextView>(R.id.contagemProgresso)
        val btVerificar = findViewById<Button>(R.id.bt_verificar)

        // Lista das opções
        val options = listOf(op1, op2, op3)

        // Configuração inicial
        updateQuestion(textViewPergunta, op1, op2, op3, progressBar, contagemProgresso)

        // Variável para armazenar a seleção do usuário
        var selectedOptionIndex: Int? = null

        // Listener para opções
        options.forEachIndexed { index, option ->
            option.setOnClickListener {
                // Resetar todas as opções para o estado padrão
                options.forEach {
                    it.setBackgroundColor(Color.DKGRAY)
                    it.setTextColor(Color.WHITE)
                }
                // Destacar a opção selecionada
                option.setBackgroundColor(Color.GREEN)
                option.setTextColor(Color.BLACK)

                // Guardar o índice da opção selecionada
                selectedOptionIndex = index
            }
        }

        // Listener para o botão "Próximo"
        btVerificar.setOnClickListener {
            if (selectedOptionIndex != null) {
                // Atualizar o resultado somando o valor da opção selecionada
                totalResultado += listaPerguntas.perguntas[currentQuestionIndex].resultado[selectedOptionIndex!!]

                if (currentQuestionIndex < listaPerguntas.perguntas.size - 1) {
                    currentQuestionIndex++ // Avançar para a próxima pergunta
                    updateQuestion(textViewPergunta, op1, op2, op3, progressBar, contagemProgresso)
                    resetOptions(options) // Resetar a escolha do usuário
                    selectedOptionIndex = null // Resetar o índice da seleção
                } else {
                    // Última pergunta respondida, passar para a tela final com o total
                    val intent = Intent(this, finalActivity::class.java)
                    intent.putExtra("resultadoFinal", totalResultado) // Passar a soma final para a próxima Activity
                    startActivity(intent)
                    finish()
                }
            } else {
                // Se nenhuma opção foi selecionada, exibir mensagem pedindo para selecionar uma
                Toast.makeText(this, "Por favor, selecione uma opção.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Atualiza a pergunta e as opções
    private fun updateQuestion(
        textViewPergunta: TextView,
        op1: TextView,
        op2: TextView,
        op3: TextView,
        progressBar: ProgressBar,
        contagemProgresso: TextView
    ) {
        val perguntaAtual = listaPerguntas.perguntas[currentQuestionIndex]
        textViewPergunta.text = perguntaAtual.texto
        op1.text = perguntaAtual.opcoes[0]
        op2.text = perguntaAtual.opcoes[1]
        op3.text = perguntaAtual.opcoes[2]

        // Atualizar barra de progresso e contagem
        val progresso = currentQuestionIndex + 1
        progressBar.progress = progresso
        contagemProgresso.text = "$progresso/${listaPerguntas.perguntas.size}"
    }

    // Reseta as cores e o estado das opções
    private fun resetOptions(options: List<TextView>) {
        options.forEach {
            it.setBackgroundColor(Color.DKGRAY)
            it.setTextColor(Color.WHITE)
        }
    }
}
