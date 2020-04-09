package com.example.bp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Studentgegevens extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    private VolleyHelper volleyhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentgegevens);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String studentnummer = preferences.getString("studentnummer", "");
        volleyhelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t1/");
        volleyhelper.get("Studentgegevens.php?studentnummer=" + studentnummer, null, this, this);


    }

    //Zodra er op de knop btnStudentgegevens gedrukt wordt, vuurt deze functie en wordt de gebruiker gestuurd naar het menuscherm.
    public void teruguitSG(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String studentnummer = preferences.getString("studentnummer", "");
        String stapnu = "3";
        volleyhelper.get("updateStudentstap.php?studentnummer=" + studentnummer + "&stapnu=" + stapnu, null, this, this);
        Intent intentTerugNaarMenuscherm = new Intent(this, Menuscherm.class);
        startActivity(intentTerugNaarMenuscherm);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        TextView tvGebruikersnaam = findViewById(R.id.tvNaam);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvStudentnummer = findViewById(R.id.tvSN);
        try {
            JSONArray array = response.getJSONArray("rij");
            for (int i = 0; i < array.length(); i++){
                JSONObject rij = array.getJSONObject(i);
                String gebruikersnaam = rij.getString("gebruikersnaam");
                String studentnummer = rij.getString("studentnummer");
                String email = rij.getString("email");

                tvGebruikersnaam.setText(gebruikersnaam);
                tvEmail.setText(email);
                tvStudentnummer.setText(studentnummer);

            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
