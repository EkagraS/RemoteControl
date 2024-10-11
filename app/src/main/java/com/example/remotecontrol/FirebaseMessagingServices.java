package com.example.remotecontrol;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessagingServices extends com.google.firebase.messaging.FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        // Check if the notification contains data
        if (remoteMessage.getData().size() > 0) {
            String clickAction = remoteMessage.getData().get("click_action");

            if ("OPEN_ANNOUNCEMENT_ACTIVITY".equals(clickAction)) {
                // Launch AnnouncementActivity when the notification is clicked
                Intent intent = new Intent(this, AnnouncementActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                // Create notification and set the PendingIntent
                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, "default_channel_id")
                        .setSmallIcon(R.drawable.leaderboard)
                        .setContentTitle(remoteMessage.getNotification().getTitle())
                        .setContentText(remoteMessage.getNotification().getBody())
                        .setAutoCancel(true)
                        .setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                // Create the notification channel if needed
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel("default_channel_id",
                            "Default Channel",
                            NotificationManager.IMPORTANCE_DEFAULT);
                    notificationManager.createNotificationChannel(channel);
                }

                // Show the notification
                notificationManager.notify(0, notificationBuilder.build());
            }
        }
    }
}
