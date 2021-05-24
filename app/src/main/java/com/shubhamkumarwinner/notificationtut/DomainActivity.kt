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

        binding.textView.text = getMessageText(intent).toString()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.cancelNotifications()

            notificationManager.sendNotification("Replied", getMessageText(intent).toString(), this)
        }
    }

    private fun getMessageText(intent: Intent): CharSequence? {
        return RemoteInput.getResultsFromIntent(intent)?.getCharSequence(KEY_TEXT_REPLY)
    }
}