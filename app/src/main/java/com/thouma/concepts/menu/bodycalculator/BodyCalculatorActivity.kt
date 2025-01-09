package com.thouma.concepts.menu.bodycalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.thouma.concepts.R

class BodyCalculatorActivity : AppCompatActivity() {

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnAddWeight: FloatingActionButton
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnAddAge: FloatingActionButton
    private lateinit var tvHeight: TextView
    private lateinit var tvWeight: TextView
    private lateinit var tvAge: TextView
    private lateinit var btnCalculate: Button

    private var currentWeight: Int = 60
    private var currentAge: Int = 26

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_body_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        initListeners()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnAddWeight = findViewById(R.id.btnAddWeight)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        tvHeight = findViewById(R.id.tv_height)
        btnAddAge = findViewById(R.id.btnAddAge)
        tvWeight = findViewById(R.id.tv_weight)
        tvAge = findViewById(R.id.tv_age)
        btnCalculate = findViewById(R.id.btnCalculate)


        tvWeight.text = currentWeight.toString()
        tvAge.text = currentAge.toString()
    }

    private fun initListeners(){
        viewMale.setOnClickListener {
            setBackgroundColor(maleSelected = true)
        }
        viewFemale.setOnClickListener {
            setBackgroundColor(maleSelected = false)
        }

        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            tvWeight.text = currentWeight.toString()
        }
        btnAddWeight.setOnClickListener {
            currentWeight += 1
            tvWeight.text = currentWeight.toString()
        }
        btnSubtractAge.setOnClickListener {
            currentAge -= 1
            tvAge.text = currentAge.toString()
        }
        btnAddAge.setOnClickListener {
            currentAge += 1
            tvAge.text = currentAge.toString()
        }
        btnCalculate.setOnClickListener {
            // Calcular el IMC (indice de masa corporal) usando la fórmula: peso / altura^2
            val height = tvHeight.text.slice(0..2).toString().toFloat() / 100
            println("Altura: $height")
            val weight = tvWeight.text.toString().toFloat()
            val imc = weight / (height * height)
            println("%.2f".format(imc))
            // Mostrar el resultado en una nueva vista
            val intent = Intent(this, ResultImcActivity::class.java)
            intent.putExtra("imc", "%.2f".format(imc))
            startActivity(intent)
        }

    }

    private fun setBackgroundColor(maleSelected: Boolean) {
        if (maleSelected) {
            viewMale.setCardBackgroundColor(getColor(R.color.background_component_selected))
            viewFemale.setCardBackgroundColor(getColor(R.color.background_component))
        }
        else {
            viewMale.setCardBackgroundColor(getColor(R.color.background_component))
            viewFemale.setCardBackgroundColor(getColor(R.color.background_component_selected))
        }
    }
}