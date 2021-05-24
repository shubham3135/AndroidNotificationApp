package com.shubhamkumarwinner.notificationtut.util

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import com.shubhamkumarwinner.notificationtut.DomainActivity
import com.shubhamkumarwinner.notificationtut.MainActivity
import com.shubhamkumarwinner.notificationtut.R


const val CHANNEL_ID = "myChannel"
private const val NOTIFICATION_ID = 0
const val KEY_TEXT_REPLY = "key_text_reply"

fun NotificationManager.sendNotification(title: String, messageBody: String, applicationContext: Context){
    //for tap option
    // Create an explicit intent for an Activity in your app
    val intent = Intent(applicationContext, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    val pendingIntent: PendingIntent = PendingIntent.getActivity(
        applicationContext, 0, intent, 0)

    // for direct reply
    val domainIntent = Intent(applicationContext, DomainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }

    val remoteInput: RemoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run {
        setLabel("Reply")
        build()
    }
    val replyPendingIntent: PendingIntent =
        PendingIntent.getActivity(applicationContext,
            0,
            domainIntent,
            PendingIntent.FLAG_ONE_SHOT)

    val action: NotificationCompat.Action =
        NotificationCompat.Action.Builder(R.drawable.ic_reply_icon,
            "Reply", replyPendingIntent)
            .addRemoteInput(remoteInput)
            .build()

    val builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_electric_bike)
        .setContentTitle(title)
        .setContentText(messageBody)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        //for tap option
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        //add action button for direct reply
        .addAction(action)


    notify(NOTIFICATION_ID, builder.build())

}

fun NotificationManager.cancelNotifications() {
    cancelAll()
}