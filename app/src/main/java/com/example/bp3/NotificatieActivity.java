package com.example.bp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.bp3.Model.Notificatie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificatieActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    private VolleyHelper volleyhelper;
    private Notificatie notificatiemodel = new Notificatie();
    NotificatieController NC = new NotificatieController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificatie);

        String studentnummer = "1234567";
        volleyhelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t1/");
        volleyhelper.get("Studentstap.php?studentnummer=" + studentnummer, null, this, this);
        //NC.NotificatieSturen();
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
                int stapnu = rij.getInt("stapnu");
                String stapnu1 = String.valueOf(stapnu);
                Log.i("stapnu", stapnu1);
                notificatiemodel.setStapnu(stapnu);
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            JSONArray array = response.getJSONArray("rij");
            for (int i = 0; i < array.length(); i++){
                JSONObject rij = array.getJSONObject(i);
                String naam = rij.getString("gebruikersnaam");

                notificatiemodel.setGebruikersnaam(naam);
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
