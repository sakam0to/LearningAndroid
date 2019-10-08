package com.zhujingjie.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int notificationID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        //--PendingIntent to launch activity if the user selects this notification
        Intent i = new Intent(this, NotificationView.class);
        i.putExtra("notificationID",notificationID);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification.Builder notifBuilder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setTicker("Reminder: Meeting starts in 5 minutes")
                .setWhen(System.currentTimeMillis())
                .setContentTitle("System alarm")
                .setContentText("Meeting with customer at 3pm ...")
                .setContentIntent(pendingIntent)
                //100ms delay, vibrate for 250ms, pause for 100ms then vibrate for 500ms
                .setVibrate(new long[]{100, 250, 100, 500});

        Notification notification = notifBuilder.getNotification();

        nm.notify(notificationID, notification);
    }


}
