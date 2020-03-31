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


public class NotificatieController extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    private VolleyHelper volleyhelper;
    //Notificatie notificatiemodel = new Notificatie();

    public void NotificatieSturen(){

        haalAPIGebruikersnaam();

        //Intent notifyIntent = new Intent(this,MyReceiver.class);
        //Stuur iedere 24 uur een notificatie over de stap.
        //PendingIntent pendingIntent = PendingIntent.getBroadcast
         //       (this, 1, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        //AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        //alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(),
         //       86400000, pendingIntent);
    }

    private void haalAPIGebruikersnaam(){
        //De huidige gebruiker is een tester: dit is standaard 1234567

        String studentnummer = "1234567";
        volleyhelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t1/");
        volleyhelper.get("Studentgegevens.php?studentnummer=" + studentnummer, null, this, this);
        //volleyhelper.get("Studentstap.php?studentnummer="+ studentnummer, null, this, this);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        try {
            JSONArray array = response.getJSONArray("rij");
            for (int i = 0; i < array.length(); i++){
                JSONObject rij = array.getJSONObject(i);
                String naam = rij.getString("gebruikersnaam");
                //int stapnu = rij.getInt("stapnu");
                //notificatiemodel.setStapnu(stapnu);
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
