package org.haqnawaz.notification_lecture;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api=Build.VERSION_CODES.O)
    public void createNotification(View view) {

        int notificatonId = 1;
        String channelId="channel_1";
        CharSequence name = getString(R.string.channel_name);
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel notificationChannel=new NotificationChannel(channelId,name,importance);
        Notification notification= new Notification.Builder(MainActivity.this)
                .setContentText("New Message")
                .setContentText("You have new messages")
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setChannelId(channelId)
                .build();
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(notificationChannel);

        notificationManager.notify(notificatonId,notification);

    }
}