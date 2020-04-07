package com.example.bp3;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class bereikbaarActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener  {
    private VolleyHelper volleyhelper;
    private String studentnummer;
    private Button buttomterug;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bereikbaar);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String studentnummer = preferences.getString("studentnummer", "");
        volleyhelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t1/");
                volleyhelper.get("Bereikbaarheid.php", null, this, this);

    }

    public void gaNaarMenu(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String studentnummer = preferences.getString("studentnummer", "");
        String stapnu = "5";
        volleyhelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t1/");
        volleyhelper.get("updateStudentstap.php?studentnummer=" + studentnummer + "&stapnu=" + stapnu, null, this, this);
        Intent intentGaMenu = new Intent(this, Menuscherm.class);
        startActivity(intentGaMenu);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
            TextView TV_view = findViewById(R.id.TV_view);
            TV_view.setText("Dit zijn de bustijden:  \n");
            try {
                    JSONArray array = response.getJSONArray("rij");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject rij = array.getJSONObject(i);
                        String busnummer = rij.getString("busnummer");
                        String bustijd = rij.getString("bustijd");
                        TV_view.append(busnummer + " gaat om " + bustijd + "\n");
                    }

                }
            catch (JSONException e) {
                e.printStackTrace();
            }

        }
}
