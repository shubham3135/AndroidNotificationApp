package com.shubhamkumarwinner.notificationtut

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.RemoteInput
import com.shubhamkumarwinner.notificationtut.databinding.ActivityDomainBinding
import com.shubhamkumarwinner.notificationtut.util.CHANNEL_ID
import com.shubhamkumarwinner.notificationtut.util.KEY_TEXT_REPLY
import com.shubhamkumarwinner.notificationtut.util.cancelNotifications
import com.shubhamkumarwinner.notificationtut.util.sendNotification

class DomainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDomainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}