package com.zhujingjie.notification;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;

public class NotificationView extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        //--Look up the notification manager service--
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


        //--Cancel the notification that we started--
        nm.cancel(getIntent().getExtras().getInt("notificationID"));
    }
}
