package com.example.bp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vind de button uit de XML file.
        Button createNotificationButton = findViewById(R.id.btnNotification);

        createNotificationButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addNotification();
            }
        });
    }

    private void addNotification(){
        //Zal niet werken van en boven Oreo, omdat je daar Notification channels nodig hebt. Dit vereist meer tijd.
        //Daarom is Builder(android.content.Context) deprecated.
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Test titel")
                .setContentText("woop");

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(0, builder.build());
    }
}
