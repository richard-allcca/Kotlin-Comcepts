package com.thouma.concepts.menu.firstApp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.thouma.concepts.R

class FirstScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputText = findViewById<AppCompatEditText>(R.id.inputText)
        val clickMe = findViewById<AppCompatButton>(R.id.clickMe)

        // Configura un OnClickListener para el botón 'clickMe'
        clickMe.setOnClickListener {
            val textParsed = inputText.text.toString()
            // Verified that the text is not empty
            if (textParsed.isNotEmpty()) {
                // Build Intent to start 'ResultActivity'
                val intent = Intent(this, ResultActivity::class.java)
                // Agrega un extra al intent con la clave "EXTRA_NAME" y el valor 'textParsed'
                intent.putExtra("EXTRA_NAME", textParsed)
                // Inicia la actividad 'ResultActivity' con el intent creado
                startActivity(intent)
            }
        }
    }
}