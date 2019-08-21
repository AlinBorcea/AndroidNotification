package com.alin.androidnotification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public abstract class NotificationHelper {

    // Sends a simple notification with title, content and a drawable
    public static void sendNotification(Context context, String id, String name, int importance, String title, String descr, int drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            createChannel(context, id, name, importance);

        NotificationManagerCompat.from(context).notify(Integer.parseInt(id), getNotification(context, id, title, descr, drawable).build());
    }

    @RequiresApi(26) // Creates the channel if Build.VERSION.SDK_INT >= 26
    public static void createChannel(Context context, String id, String name, int importance) {
        context.getSystemService(NotificationManager.class).createNotificationChannel(new NotificationChannel(id, name, importance));
    }

    // Returns the NotificationCompat.Builder object (it defines how the notification will look and behave)
    public static NotificationCompat.Builder getNotification(Context context, String id, String title, String descr, int drawable) {
        NotificationCompat.Builder notification = new NotificationCompat.Builder(context, id);
        notification.setContentTitle(title)
                .setContentText(descr)
                .setSmallIcon(drawable);

        return notification;
    }

}
