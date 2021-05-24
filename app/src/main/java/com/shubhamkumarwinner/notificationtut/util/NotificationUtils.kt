package com.shubhamkumarwinner.notificationtut.util

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.shubhamkumarwinner.notificationtut.DomainActivity
import com.shubhamkumarwinner.notificationtut.MainActivity
import com.shubhamkumarwinner.notificationtut.R


const val CHANNEL_ID = "myChannel"
private const val NOTIFICATION_ID = 0

fun NotificationManager.sendNotification(title: String, messageBody: String, applicationContext: Context){
    //for tap option
    // Create an explicit intent for an Activity in your app
    val intent = Intent(applicationContext, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    val pendingIntent: PendingIntent = PendingIntent.getActivity(
        applicationContext, 0, intent, 0)

    // for adding action
    val domainIntent = Intent(applicationContext, DomainActivity::class.java)
    val domainPendingIntent: PendingIntent = PendingIntent.getActivity(
        applicationContext,
        0,
        domainIntent,
        PendingIntent.FLAG_ONE_SHOT
    )

    val builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_electric_bike)
        .setContentTitle(title)
        .setContentText(messageBody)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        //for tap option
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        //add action button
        .addAction(R.drawable.ic_electric_bike, "Domain", domainPendingIntent)


    notify(NOTIFICATION_ID, builder.build())

}