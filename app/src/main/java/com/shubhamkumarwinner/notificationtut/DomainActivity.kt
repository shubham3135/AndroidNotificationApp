package com.shubhamkumarwinner.notificationtut

import android.app.NotificationManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.shubhamkumarwinner.notificationtut.databinding.ActivityDomainBinding
import com.shubhamkumarwinner.notificationtut.util.cancelNotifications

class DomainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDomainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getText()?.let {
            binding.textView.text = it
        }

        val notificationManager = ContextCompat.getSystemService(
            this, NotificationManager::class.java) as NotificationManager

        notificationManager.cancelNotifications()
    }

    private fun getText(): String? {
        return intent.getStringExtra("text")
    }

}