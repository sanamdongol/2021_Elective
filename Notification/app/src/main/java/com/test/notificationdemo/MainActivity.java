package com.test.notificationdemo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID_A = "1";
    private static final String CHANNEL_ID_B = "99";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnA = findViewById(R.id.btn_a);
        Button btnB = findViewById(R.id.btn_b);
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotificationChannelB();
            }
        });
    }

    private void showNotificationChannelB() {


        Bitmap bitmap =
                BitmapFactory.decodeResource(this.getResources(), R.drawable.honda);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, CHANNEL_ID_B);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("This is content titlefor B")
                .setContentText("Context Text for B")
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(bitmap));
        NotificationManager manager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence channelName = "Channel B";

            String description = "Channel B description";

            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel =
                    new NotificationChannel(CHANNEL_ID_B, channelName, importance);

            channel.setDescription(description);

            manager.createNotificationChannel(channel);
        }
        manager.notify(1, builder.build());


    }

    private void showNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, CHANNEL_ID_A);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("This is content title")
                .setContentText("Context Text");

        NotificationManager manager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence channelName = "Channel A";

            String description = "Channel A description";

            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel =
                    new NotificationChannel(CHANNEL_ID_A, channelName, importance);

            channel.setDescription(description);

            manager.createNotificationChannel(channel);
        }
        manager.notify(1, builder.build());

    }
}