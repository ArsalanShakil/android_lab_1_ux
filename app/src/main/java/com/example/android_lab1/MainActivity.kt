package com.example.android_lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greetingText = findViewById<TextView>(R.id.greetingText)
        findViewById<Button>(R.id.clickBtn).setOnClickListener {
            val editTextPersonName = findViewById<EditText>(R.id.editTextPersonName)

            val username: String = editTextPersonName.text.toString()

            if (editTextPersonName.text.isNotEmpty()) {
                val visibleTxt = "Hello $username"
                greetingText.text = visibleTxt
                editTextPersonName.text.clear()
            } else {

                when (greetingText.text) {
                    "Hello World!" -> greetingText.text = "Goodbye Summer"
                    "Goodbye Summer" -> greetingText.text = "Hello World!"
                    else -> greetingText.text = "Hello World!"
                }

            }

        }


/*
        clickBtn.setOnClickListener {
            val username: String? = editTextPersonName.text.toString()

            if (editTextPersonName.text.isEmpty()) {

                when (greetingText.text) {
                    "Hello World" -> greetingText.text = "Goodbye Summer"
                    "Goodbye Summer" -> greetingText.text = "Hello World"
                    else -> greetingText.text = "Hello World"
                }

            } else{
                greetingText.text = "Hello $username "
                editTextPersonName.text.clear()
            }




        }*/




    }
}