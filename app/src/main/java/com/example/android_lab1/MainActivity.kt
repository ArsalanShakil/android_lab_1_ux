package com.example.android_lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val greetingText = findViewById<TextView>(R.id.greetingText)

        greetingText.text = "hello worrrrld!"


    }
}