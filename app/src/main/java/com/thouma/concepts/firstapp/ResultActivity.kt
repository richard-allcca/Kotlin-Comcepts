package com.thouma.concepts.firstapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.thouma.concepts.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textResult = findViewById<TextView>(R.id.textResult)

        // Obtiene el valor de la clave 'EXTRA_NAME' del bundle de extras del intent, o una cadena vacía si es nulo.
        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()

        textResult.text = "Hola $name"

    }
}