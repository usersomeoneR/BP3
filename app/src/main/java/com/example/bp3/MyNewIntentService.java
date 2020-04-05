package com.example.bp3;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.core.app.NotificationManagerCompat;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//Dit is de Intent Service class.
public class MyNewIntentService extends IntentService implements Response.Listener<JSONObject>, Response.ErrorListener{
    private static final int NOTIFICATION_ID = 3;
    private VolleyHelper volleyhelper;


    public MyNewIntentService() {
        super("MyNewIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String studentnummer = preferences.getString("studentnummer", "");
        String stapnu = preferences.getString("stapnu", "");
        String gebruikersnaam = preferences.getString("gebruikersnaam", "");

        volleyhelper = new VolleyHelper(getApplicationContext(), "https://adaonboarding.ml/t1/");
        volleyhelper.get("Studentstap.php?studentnummer=" + studentnummer, null, this, this);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Avans Onboarding");
        builder.setContentText("Hoi " + gebruikersnaam + ", je bent bij stap " + stapnu + ", nog even en dan ben je klaar met de onboarding!");
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        Intent notifyIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 2, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        //to be able to launch your activity from the notification
        builder.setContentIntent(pendingIntent);
        Notification notificationCompat = builder.build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(NOTIFICATION_ID, notificationCompat);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        try {
            JSONArray array = response.getJSONArray("rij");
                for (int i = 0; i < array.length(); i++) {
                    JSONObject rij = array.getJSONObject(i);
                    int stapnu = rij.getInt("stapnu");
                    String stringStapnu = String.valueOf(stapnu);

                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
                    SharedPreferences.Editor prefSN = preferences.edit();
                    prefSN.putString("stapnu", stringStapnu);
                    prefSN.apply();

                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
    }
}