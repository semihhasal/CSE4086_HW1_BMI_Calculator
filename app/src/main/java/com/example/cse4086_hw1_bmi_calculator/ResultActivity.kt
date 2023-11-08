package com.example.cse4086_hw1_bmi_calculator


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val bmiResult = intent.getStringExtra("BMI_RESULT")
        val interpret = intent.getStringExtra("BMI")

        val resultTextView: TextView = findViewById(R.id.result)
        resultTextView.text = " Body Mass Index: $bmiResult\n $interpret"


        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            // MainActivity'ye geri dönmek için Intent oluştur
            val intent = Intent(this@ResultActivity, MainActivity::class.java)
            startActivity(intent)
            finish() // ResultActivity'yi kapat
        }
    }
}