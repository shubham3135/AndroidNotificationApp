package com.shubhamkumarwinner.notificationtut

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.shubhamkumarwinner.notificationtut.databinding.ActivityMainBinding
import com.shubhamkumarwinner.notificationtut.util.CHANNEL_ID
import com.shubhamkumarwinner.notificationtut.util.sendNotification

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val notificationManager =  ContextCompat.getSystemService(
            this, NotificationManager::class.java) as NotificationManager

        createNotificationChannel(
            getString(R.string.channel_name),
            CHANNEL_ID,
            getString(R.string.channel_description),
            NotificationManager.IMPORTANCE_HIGH
        )
        binding.showNotification.setOnClickListener {
            notificationManager.sendNotification(
                "Title",
                "This is Description",
                this
            )
        }
    }

    private fun createNotificationChannel(channelName: String,
                                          channelId: String,
                                          descriptionText: String,
                                          importance: Int) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}