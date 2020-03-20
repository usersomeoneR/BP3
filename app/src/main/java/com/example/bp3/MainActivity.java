package com.example.bp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Moet het nog ergens inzetten.

        mQueue = Volley.newRequestQueue(this);
        jsonParse();

        Intent notifyIntent = new Intent(this,MyReceiver.class);
        //Stuur iedere 24 uur een notificatie over de stap.
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (this, 1, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(),
                86400000, pendingIntent);
    }

    private void jsonParse(){
        //De huidige gebruiker is een tester: dit is standaard 1234567
        String url = "";
    }
}
