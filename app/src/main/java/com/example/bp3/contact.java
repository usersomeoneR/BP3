package com.example.bp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

public class contact extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    private VolleyHelper volleyhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    public void gaTerug(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String studentnummer = preferences.getString("studentnummer", "");
        String stapnu = "4";
        volleyhelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t1/");
        volleyhelper.get("updateStudentstap.php?studentnummer=" + studentnummer + "&stapnu=" + stapnu, null, this, this);
        Intent intentMenuTerug = new Intent(this, Menuscherm.class);
        startActivity(intentMenuTerug);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}
