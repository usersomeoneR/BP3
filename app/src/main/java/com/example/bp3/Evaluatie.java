package com.example.bp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

public class Evaluatie extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    private VolleyHelper volleyhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluatie);

    }

    public void gaNaarMenu(View view) {
        Intent intentMenu = new Intent(this, Menuscherm.class);
        startActivity(intentMenu);
    }

    public void antwoordSturen(View view){
        EditText etAntwoord = findViewById(R.id.etAntwoord);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        String studentnummer = "1234567";
        String antwoord = String.valueOf(etAntwoord.getText());
        insertEvaluatie(antwoord, studentnummer);

        }
    public void insertEvaluatie(String antwoord, String studentnummer){
        volleyhelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t1/");
        volleyhelper.get("insertEvaluatie.php?studentnummer="+studentnummer+"&antwoord="+antwoord, null, this, this);
        }


    @Override
    public void onErrorResponse(VolleyError error) {

        }

    @Override
    public void onResponse(JSONObject response) {

        }


}
