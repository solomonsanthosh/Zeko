package com.example.zeko.utils.notification

import android.app.Application
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.zeko.R
import com.example.zeko.view.MainActivity

class NotificationService(private val context:Application) {

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val intent = Intent(context,MainActivity::class.java)
    val pendingIntent = PendingIntent.getActivity(context,1,intent, PendingIntent.FLAG_IMMUTABLE)
    companion object {
        val CHANNEL_ID = "zekoChennel"
    }
    fun showNotification(text:String){
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.baseline_notifications_none_24)
            .setContentTitle("Your post is live now")
            .setContentText("${ if(text.length >10) text.substring(0,10) else text}....")
            .setContentIntent(pendingIntent)
            .build()

        notificationManager.notify(1,notification)
    }
}