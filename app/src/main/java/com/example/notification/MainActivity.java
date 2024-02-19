package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "NOTIFICATION_CHANNEL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void PushUp(View view) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        createNotificationChannel("NOTIFICATION_CHANNEL", "Notification channel", notificationManager);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Заголовок")
                .setContentText("Текст");

        notificationManager.notify(101, builder.build());
    }

    private void createNotificationChannel(String chanelName, String channelDescription, NotificationManagerCompat nm) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, chanelName, importance);
            channel.setDescription(channelDescription);

            nm.createNotificationChannel(channel);
        }
    }
}