package com.example.cse4086_hw1_bmi_calculator


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bmiResult = intent.getStringExtra("BMI_RESULT")
        val bmi = intent.getStringExtra("BMI")

        val resultTextView: TextView = findViewById(R.id.result)
        resultTextView.text = " Body Mass Index: $bmiResult\n $bmi"
    }
}