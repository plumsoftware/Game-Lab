package com.example.gamelab.activity

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gamelab.R

class PayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)

        val homeBtn = findViewById<ImageButton>(R.id.buttonHome)
        val payBtn = findViewById<Button>(R.id.payBtn)
        val radio1 = findViewById<RadioButton>(R.id.radioButton)
        val radio2 = findViewById<RadioButton>(R.id.radioButton2)

        radio1.setOnClickListener {
            radio2.isChecked = false
        }
        radio2.setOnClickListener {
            radio1.isChecked = false
        }

        homeBtn.setOnClickListener {
            finish()
        }

        payBtn.setOnClickListener {
            if (!radio1.isChecked && !radio2.isChecked) {
                Toast.makeText(this, "Выберите способ оплаты", Toast.LENGTH_LONG).show()
            }
        }
    }
}