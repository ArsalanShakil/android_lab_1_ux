package com.example.android_lab1

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.EXTRA_NOTIFICATION_ID
import androidx.core.app.NotificationManagerCompat
import com.google.android.material.snackbar.Snackbar
import java.util.*


class MainActivity : AppCompatActivity() {
    val CHANNEL_ID = "channel_id_01"
    val notificationId = 101

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        createNotificationChannel()



        val greetingText = findViewById<TextView>(R.id.greetingText)
        findViewById<Button>(R.id.clickBtn).setOnClickListener {
            val editTextPersonName = findViewById<EditText>(R.id.editTextPersonName)

            val username: String = editTextPersonName.text.toString()

            if (editTextPersonName.text.isNotEmpty()) {
                val visibleTxt = resources.getString(R.string.hello) + " " + username
                greetingText.text = visibleTxt
                editTextPersonName.text.clear()
            } else {

                when (greetingText.text) {
                    resources.getString(R.string.introText) -> greetingText.text =
                        resources.getString(R.string.summerTxt)
                    resources.getString(R.string.summerTxt) -> greetingText.text =
                        resources.getString(R.string.introText)
                    else -> greetingText.text = resources.getString(R.string.introText)
                }

            }

        }

        val fab: View = findViewById(R.id.floatingActionButton)
        fab.setOnClickListener { view ->
            Toast.makeText(this,"You have a notification :)",Toast.LENGTH_SHORT).show()
            buildNotification()
        }


        val snackbarBtn: View = findViewById(R.id.snackbarBtn)
        snackbarBtn.setOnClickListener { view ->
            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Close") {

                }
                .show()
        }


    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification Title"
            val descriptionText = "Some Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }


    }

    private fun buildNotification() {
        // Create an explicit intent for an Activity in your app
        val intent = Intent(this, AlertDetails::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setContentTitle("New notification")
            .setContentText("You have clicked button successfully")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .addAction(R.drawable.ic_baseline_favorite_24,"Open",pendingIntent)
            .build()
        NotificationManagerCompat.from(this).notify(101, builder)
    }

}