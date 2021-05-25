package com.shubhamkumarwinner.notificationtut.util

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import androidx.core.app.TaskStackBuilder
import com.shubhamkumarwinner.notificationtut.DomainActivity
import com.shubhamkumarwinner.notificationtut.R


const val CHANNEL_ID = "myChannel"
private const val NOTIFICATION_ID = 0

fun NotificationManager.sendNotification(title: String, messageBody: String, applicationContext: Context){
    //for tap option
    val resultIntent = Intent(applicationContext, DomainActivity::class.java)
        .apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        .putExtra("text", applicationContext.getString(R.string.message_text))


    val myBitmap = BitmapFactory.decodeResource(
        applicationContext.resources,
        R.drawable.pic6
    )

    val notifyPendingIntent = PendingIntent.getActivity(
        applicationContext, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT
    )


    val builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_electric_bike)
        .setContentTitle(title)
        .setContentText(messageBody)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setLargeIcon(myBitmap)
        .setContentIntent(notifyPendingIntent)

    notify(NOTIFICATION_ID, builder.build())

}

fun NotificationManager.cancelNotifications() {
    cancelAll()
}