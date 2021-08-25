package com.example.android_lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


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

        val fab: View = findViewById(R.id.floatingActionButton)
        fab.setOnClickListener { view ->
            Toast.makeText(this,R.string.introText,Toast.LENGTH_SHORT).show()
        }


        val snackbarBtn: View = findViewById(R.id.snackbarBtn)
        snackbarBtn.setOnClickListener { view ->
            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }
    }
}