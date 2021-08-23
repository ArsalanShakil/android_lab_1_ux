package com.example.android_lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val greetingText = findViewById<TextView>(R.id.greetingText)
        var count = 0
        findViewById<Button>(R.id.clickBtn).setOnClickListener {
            greetingText.text = "Goodbye Summer"
            count++
            if (count % 2 == 0) {
                greetingText.text = "Hello World!"
            }

        }


    }
}