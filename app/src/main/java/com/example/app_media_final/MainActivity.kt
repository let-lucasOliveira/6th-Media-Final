package com.example.app_media_final

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etNota1        :   EditText
    private lateinit var etNota2        :   EditText
    private lateinit var etFaltas       :   EditText
    private lateinit var btCalcular     :   Button
    private lateinit var btLimpar       :   Button
    private lateinit var btSair         : Button
    private lateinit var tvNotaFinal    :    TextView
    private lateinit var tvSituacao     :   TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        etNota1 =   findViewById(R.id.etNota1)
        etNota2 =   findViewById(R.id.etNota2)
        etFaltas = findViewById(R.id.etFaltas)

        tvNotaFinal = findViewById(R.id.tvNotaFinal)
        tvSituacao = findViewById(R.id.tvSituacao)

        btCalcular = findViewById(R.id.btCalcular)
        btLimpar = findViewById(R.id.btLimpar)
        btSair = findViewById(R.id.btSair)

        btCalcular.setOnClickListener {
            calcular()
        }

        btLimpar.setOnClickListener {
            etNota1.text.clear()
            etNota2.text.clear()
            etFaltas.text.clear()
            tvNotaFinal.text = ""
            tvSituacao.text = ""
            etNota1.requestFocus()
        }

        btSair.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun calcular () {
        var nota1 : Double
        var nota2 : Double
        var notaFinal : Double
        var situacao : String
        nota1 = etNota1.text.toString().toDouble()
        nota2 = etNota2.text.toString().toDouble()
        notaFinal = (nota1 + nota2) /2

        situacao = if (notaFinal >= 6) "Aprovado" else "Reprovado"

        tvNotaFinal.text = notaFinal.toString()
        tvSituacao.text = situacao
    }
}