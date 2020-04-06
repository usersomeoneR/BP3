package com.example.bp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.bp3.Menuscherm;
import com.example.bp3.R;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    private VolleyHelper volleyhelper;
    private String studentnummer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String studentnummer = "1234567";

        volleyhelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t1/");
        volleyhelper.get("Studentgegevens.php?studentnummer=" + studentnummer, null, this, this);

        //Maak een intent naar MyReceiver
        //De MyReceiver vuurt af zodra er een broadcast gemaakt wordt.
        Intent notifyIntent = new Intent(this,MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (this, 1, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(),
                1000 * 60 * 60 * 24, pendingIntent);

    }

    //Ga naar het hoofdmenu zodra deze methode afgevuurd wordt.
    public void naarMenu(View v) {
        Intent intentMenu = new Intent(this, Menuscherm.class);
        startActivity(intentMenu);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        TextView tvWelkom = findViewById(R.id.tvWelkom);
        try {
            JSONArray array = response.getJSONArray("rij");
            for (int i = 0; i < array.length(); i++){
                JSONObject rij = array.getJSONObject(i);

                String gebruikersnaam = rij.getString("gebruikersnaam");
                String studentnummer = rij.getString("studentnummer");

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor prefSN = preferences.edit();
                prefSN.putString("studentnummer", studentnummer);
                prefSN.apply();

                SharedPreferences.Editor prefGN = preferences.edit();
                prefGN.putString("gebruikersnaam", gebruikersnaam);
                prefGN.apply();

                String naam = rij.getString("gebruikersnaam");
                tvWelkom.setText("Welkom, "+ naam );
             }
            }
        catch (JSONException e) {
            e.printStackTrace();
    }

    }
}
