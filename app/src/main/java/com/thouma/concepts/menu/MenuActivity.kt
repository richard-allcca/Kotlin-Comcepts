package com.thouma.concepts.menu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.thouma.concepts.R
import com.thouma.concepts.menu.firstApp.FirstScreenActivity
import com.thouma.concepts.menu.bodycalculator.BodyCalculatorActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstBtn = findViewById<Button>(R.id.firstBtn)
        val secondBtn = findViewById<Button>(R.id.calculator)

        fun navigateToFirstScreen() {
            val intent = Intent(this, FirstScreenActivity::class.java)
            startActivity(intent)
        }

        fun navigateToBodyCalculator() {
            val intent = Intent(this, BodyCalculatorActivity::class.java)
            startActivity(intent)
        }

        firstBtn.setOnClickListener { navigateToFirstScreen() }
        secondBtn.setOnClickListener { navigateToBodyCalculator() }

    }
}