package com.shubhamkumarwinner.notificationtut.util

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.shubhamkumarwinner.notificationtut.DomainActivity
import com.shubhamkumarwinner.notificationtut.R


const val CHANNEL_ID = "myChannel"
private const val NOTIFICATION_ID = 0
val GROUP_KEY_WORK_EMAIL = "com.shubhamkumarwinner.NotificationApp.WORK_EMAIL"
val packageName = "com.shubhamkumarwinner.notificationtut"

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

    val notificationLayout = RemoteViews(packageName, R.layout.notification_small)
    val notificationLayoutExpanded = RemoteViews(packageName, R.layout.notification_large)


    val builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_electric_bike)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setStyle(NotificationCompat.DecoratedCustomViewStyle())
        .setCustomContentView(notificationLayout)
        .setCustomBigContentView(notificationLayoutExpanded)

    notify(NOTIFICATION_ID, builder.build())

}

fun NotificationManager.cancelNotifications() {
    cancelAll()
}