package com.example.cse4086_hw1_bmi_calculator
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightInputLayout: TextInputLayout = findViewById(R.id.weightInputLayout)
        val heightInputLayout: TextInputLayout = findViewById(R.id.heightInputLayout)
        val weightEditText: EditText = findViewById(R.id.weight)
        val heightEditText: EditText = findViewById(R.id.height)
        val calculateButton: Button = findViewById(R.id.btnSubmit)

        calculateButton.setOnClickListener {
            val weightStr = weightEditText.text.toString()
            val heightStr = heightEditText.text.toString()

            if (weightStr.isNotEmpty() && heightStr.isNotEmpty()) {
                val weight = weightStr.toFloat()
                val height = heightStr.toFloat() / 100 // CM olarak gelen boyu metre cinsine çeviriyoruz

                val bmi = calculateBMI(weight, height)
                val result = String.format("%.1f", bmi)
                val interpret = interpretBMI(bmi)

                val intent = Intent(this@MainActivity, ResultActivity::class.java)
                intent.putExtra("BMI_RESULT", result)
                intent.putExtra("BMI", interpret)

                startActivity(intent)
            } else {
                // Kullanıcı boş alan bıraktıysa hata mesajını göster
                weightInputLayout.error = "please enter weight."
                heightInputLayout.error = "please enter height"
            }
        }
    }

    private fun calculateBMI(weight: Float, height: Float): Float {
        return weight / (height * height)
    }
    private fun interpretBMI(bmi: Float): String {
        return when {
            bmi < 18.5 -> "Zayıf"
            bmi < 24.9 -> "Normal"
            bmi < 29.9 -> "Fazla Kilolu"
            else -> "Obez"
        }
    }
}