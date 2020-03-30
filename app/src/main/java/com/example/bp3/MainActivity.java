package com.example.bp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.bp3.Menuscherm;
import com.example.bp3.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    private VolleyHelper volleyhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String studentnummer = "1234567";

        volleyhelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t1/");
        volleyhelper.get("Studentgegevens.php?studentnummer=" + studentnummer, null, this, this);
    }
    public void naarMenu(View v) {
        Intent intent = new Intent(this, Menuscherm.class);
        startActivity(intent);
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
                String naam = rij.getString("gebruikersnaam");
                tvWelkom.setText("Welkom, "+ naam );
             }
            }
        catch (JSONException e) {
            e.printStackTrace();
    }

    }
}
