package com.example.samrudhi.notification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.app.PendingIntent;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.app.Notification;

public class MainActivity extends AppCompatActivity {


    private int notification_id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notifyNow();
    }

    private void notifyNow() {

        Intent acceptIntent = new Intent(this, ExpandClass.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        acceptIntent.setAction(AppConstant.ACCEPT_ACTION);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, acceptIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        Intent rejectIntent = new Intent(this, RejectClass.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        rejectIntent.setAction(AppConstant.REJECT_ACTION);
        PendingIntent contentIntentForReject = PendingIntent.getActivity(this, 0, rejectIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        Notification notification = new NotificationCompat.Builder(this)
                .setCategory(Notification.CATEGORY_PROMO)
                .setContentTitle("New Matter Received")
                .setSmallIcon(android.R.color.transparent)
                .setAutoCancel(true)
                .setPriority(Notification.PRIORITY_HIGH)
                .addAction(android.R.drawable.ic_menu_view, "Accept", contentIntent)
                .addAction(android.R.drawable.ic_menu_view, "Reject", contentIntentForReject)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000}).build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notification_id, notification);

    }

}
