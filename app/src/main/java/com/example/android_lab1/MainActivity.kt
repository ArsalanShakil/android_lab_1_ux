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
                val visibleTxt = resources.getString(R.string.hello) + " " +username
                greetingText.text = visibleTxt
                editTextPersonName.text.clear()
            } else {

                when (greetingText.text) {
                    resources.getString(R.string.introText) -> greetingText.text = resources.getString(R.string.summerTxt)
                    resources.getString(R.string.summerTxt) -> greetingText.text = resources.getString(R.string.introText)
                    else -> greetingText.text = resources.getString(R.string.introText)
                }

            }

        }
    }
}