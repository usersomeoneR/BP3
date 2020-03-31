package com.example.bp3;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.example.bp3.Model.Notificatie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class NotificatieController extends AppCompatActivity {
    private VolleyHelper volleyhelper;


    public void NotificatieSturen(){
        Intent notifyIntent = new Intent(this,MyReceiver.class);
        //Stuur iedere 24 uur een notificatie over de stap.
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(), 1, pendingIntent);
    }
}
