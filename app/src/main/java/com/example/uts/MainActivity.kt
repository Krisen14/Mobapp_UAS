package com.example.uts

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.textInput)
        loginButton = findViewById(R.id.btn1)
        passwordEditText = findViewById(R.id.pwinput)



        nameEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No action needed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val isNameEmpty = s.isNullOrBlank()
                loginButton.isEnabled = !isNameEmpty
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })


        loginButton.setOnClickListener {
            val name = passwordEditText.text.toString()
            if (name.isNotBlank()) {

                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("NAME", name)
                startActivity(intent)
            } else {

                Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
            }

            passwordEditText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    // No action needed
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    val isNameEmpty = s.isNullOrBlank()
                    loginButton.isEnabled = !isNameEmpty
                }

                override fun afterTextChanged(s: Editable?) {

                }
            })


            loginButton.setOnClickListener {
                val pw = passwordEditText.text.toString()
                if (pw.isNotBlank()) {

                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("NAME", pw)
                    startActivity(intent)
                } else {

                    Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}