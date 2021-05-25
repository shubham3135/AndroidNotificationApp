package com.shubhamkumarwinner.notificationtut.util

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import com.shubhamkumarwinner.notificationtut.DomainActivity
import com.shubhamkumarwinner.notificationtut.R


const val CHANNEL_ID = "myChannel"
private const val NOTIFICATION_ID = 0

fun NotificationManager.sendNotification(title: String, messageBody: String, applicationContext: Context){
    //for tap option
    val imageIntent = Intent(applicationContext, DomainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }.putExtra("text", applicationContext.getString(R.string.message_text))


    val myBitmap = BitmapFactory.decodeResource(
        applicationContext.resources,
        R.drawable.pic6
    )

    val imagePendingIntent: PendingIntent =
        PendingIntent.getActivity(applicationContext,
            0,
            imageIntent,
            PendingIntent.FLAG_UPDATE_CURRENT)


    val message1 = NotificationCompat.MessagingStyle.Message(applicationContext.getString(R.string.channel_name), 1, "Shubham")
    val message2 = NotificationCompat.MessagingStyle.Message(applicationContext.getString(R.string.channel_description), 2, "Rahul")


    val builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_electric_bike)
        .setContentTitle(title)
        .setContentText(applicationContext.getText(R.string.message_text))
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setLargeIcon(myBitmap)
        .setStyle(NotificationCompat.MessagingStyle(applicationContext.getString(R.string.app_name))
            .addMessage(message1)
            .addMessage(message2)
        )
        .setContentIntent(imagePendingIntent)

    notify(NOTIFICATION_ID, builder.build())

}

fun NotificationManager.cancelNotifications() {
    cancelAll()
}