package com.example.gamelab.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gamelab.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val editTextTextLogin = findViewById<EditText>(R.id.editTextTextLogin)
        val editTextTextPassword = findViewById<EditText>(R.id.editTextTextPassword)
        val editTextTextEmail = findViewById<EditText>(R.id.editTextTextEmail)

        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val buttonRegistration = findViewById<Button>(R.id.buttonRegister)

        buttonLogin.setOnClickListener {
            val login = editTextTextLogin.text.toString()
            val password = editTextTextPassword.text.toString()
            val email = editTextTextEmail.text.toString()

            if (login.isNotEmpty() && password.isNotEmpty() && email.isNotEmpty()) {
                val sp = getSharedPreferences("user", Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = sp.edit()
                editor.putString("login", login)
                editor.putString("password", password)
                editor.putString("email", email)
                editor.apply()

                startActivity(Intent(this, CatalogActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Заполните все данные профиля!", Toast.LENGTH_LONG).show()
            }
        }
        buttonRegistration.setOnClickListener {
            startActivity(Intent(this, CatalogActivity::class.java))
            finish()
        }
    }
}