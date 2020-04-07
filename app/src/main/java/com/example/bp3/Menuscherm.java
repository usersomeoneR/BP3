package com.example.bp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Menuscherm extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

        private VolleyHelper volleyhelper;
//        private String studentnummer = "1234567";
        //private Integer stapnu = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuscherm);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String studentnummer = preferences.getString("studentnummer", "");
        volleyhelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t1/");
        volleyhelper.get("Studentstap.php?studentnummer=" + studentnummer, null, this, this);

    }

    public void gaStudentgegevens(View view) {
        Intent intentGaNaarStudentgegevens = new Intent(this, Studentgegevens.class);
        startActivity(intentGaNaarStudentgegevens);
    }

    public void gaFilmpje(View view) {
        Intent intentFilmpje = new Intent(this, filmpje.class);
        startActivity(intentFilmpje);
    }

    public void gaEvaluatie(View view) {
        Intent intentEvaluatie = new Intent(this, Evaluatie.class);
        startActivity(intentEvaluatie);
    }

    public void naarContact(View view) {
        Intent intentContact = new Intent(this, contact.class);
        startActivity(intentContact);
    }

    public void ganaarIntrodagen(View view) {
        Intent intentIntrodagen = new Intent(this, Introdagen.class);
        startActivity(intentIntrodagen);
    }

    public void startQuiz(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }

    public void gaNaarFAQ(View view) {
        Intent intentFAQ = new Intent(this, FAQ.class);
        startActivity(intentFAQ);
    }

    public void gaNaarbereikbaarActivity(View view) {
        Intent intentBereikbaar = new Intent(this, bereikbaarActivity.class);
        startActivity(intentBereikbaar);
    }


    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        ImageView ivCheck = findViewById(R.id.ivCheck);
        ImageView ivCheck2 = findViewById(R.id.ivCheck2);
        ImageView ivCheck3 = findViewById(R.id.ivCheck3);
        ImageView ivCheck4 = findViewById(R.id.ivCheck4);
        ImageView ivCheck5 = findViewById(R.id.ivCheck5);
        ImageView ivCheck6 = findViewById(R.id.ivCheck6);
        ImageView ivCheck7 = findViewById(R.id.ivCheck7);
        ImageView ivCheck8 = findViewById(R.id.ivCheck8);
        Button btnNaarFilmpje = findViewById(R.id.btnNaarFilmpje);
        Button btnNaarIntrodagen = findViewById(R.id.btnNaarIntrodagen);
        Button btnNaarAanspreek = findViewById(R.id.btnNaarAanspreek);
        Button btnNaarBereikbaarheid = findViewById(R.id.btnNaarBereikbaarheid);
        Button btnNaarFAQ = findViewById(R.id.btnNaarFAQ);
        Button btnNaarQuiz = findViewById(R.id.btnNaarQuiz);
        Button btnNaarEvaluatie = findViewById(R.id.btnNaarEvaluatie);
        Button btnNaarGegevens = findViewById(R.id.btnNaarGegevens);
        try{
            JSONArray array = response.getJSONArray("rij");

            //Als de student nog geen stapdata heeft, dan geeft dit een lege of geen array terug.
            //Zorg ervoor dat er dan stapdata wordt ingevoerd.
            if(array.equals(null) || array.length() == 0){
                String stapis = "0";
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
                String studentnummer = preferences.getString("studentnummer", "");
                volleyhelper.get("insertStudentstap.php?studentnummer=" + studentnummer + "&stapnu="+ stapis, null, this, this);
            }
            for (int i = 0; i < array.length(); i++) {
                JSONObject rij = array.getJSONObject(i);
                Integer stap = rij.getInt("stapnu");


                if(stap == 0){

                    btnNaarFilmpje.setEnabled(false);
                    btnNaarQuiz.setEnabled(false);
                }
                if(stap == 1){
                    ivCheck.setVisibility(View.VISIBLE);
                    btnNaarFilmpje.setEnabled(false);
                    btnNaarIntrodagen.setEnabled(true);
//                    btnNaarFilmpje.setEnabled(false);
                }
                if(stap == 2){
                    ivCheck.setVisibility(View.VISIBLE);
                    ivCheck2.setVisibility(View.VISIBLE);
                    btnNaarGegevens.setEnabled(true);
//                    btnNaarIntrodagen.setEnabled(false);
//                    btnNaarFilmpje.setEnabled(false);
                }

                if(stap == 3){
                    ivCheck.setVisibility(View.VISIBLE);
                    ivCheck2.setVisibility(View.VISIBLE);
                    ivCheck3.setVisibility(View.VISIBLE);
                    btnNaarAanspreek.setEnabled(true);
//                    btnNaarGegevens.setEnabled(false);
//                    btnNaarIntrodagen.setEnabled(false);
//                    btnNaarFilmpje.setEnabled(false);
                }
                if(stap == 4){
                    ivCheck.setVisibility(View.VISIBLE);
                    ivCheck2.setVisibility(View.VISIBLE);
                    ivCheck3.setVisibility(View.VISIBLE);
                    ivCheck4.setVisibility(View.VISIBLE);
                    btnNaarBereikbaarheid.setEnabled(true);
//                    btnNaarAanspreek.setEnabled(false);
//                    btnNaarGegevens.setEnabled(false);
//                    btnNaarIntrodagen.setEnabled(false);
//                    btnNaarFilmpje.setEnabled(false);
                }
                if(stap == 5){
                    ivCheck.setVisibility(View.VISIBLE);
                    ivCheck2.setVisibility(View.VISIBLE);
                    ivCheck3.setVisibility(View.VISIBLE);
                    ivCheck4.setVisibility(View.VISIBLE);
                    ivCheck5.setVisibility(View.VISIBLE);
                    btnNaarFAQ.setEnabled(true);
//                    btnNaarBereikbaarheid.setEnabled(false);
//                    btnNaarAanspreek.setEnabled(false);
//                    btnNaarGegevens.setEnabled(false);
//                    btnNaarIntrodagen.setEnabled(false);
//                    btnNaarFilmpje.setEnabled(false);
                }
                if(stap == 6){
                    ivCheck.setVisibility(View.VISIBLE);
                    ivCheck2.setVisibility(View.VISIBLE);
                    ivCheck3.setVisibility(View.VISIBLE);
                    ivCheck4.setVisibility(View.VISIBLE);
                    ivCheck5.setVisibility(View.VISIBLE);
                    ivCheck6.setVisibility(View.VISIBLE);
                    btnNaarQuiz.setEnabled(true);
//                    btnNaarFAQ.setEnabled(false);
//                    btnNaarBereikbaarheid.setEnabled(false);
//                    btnNaarAanspreek.setEnabled(false);
//                    btnNaarGegevens.setEnabled(false);
//                    btnNaarIntrodagen.setEnabled(false);
//                    btnNaarFilmpje.setEnabled(false);
                }
                if(stap == 7){
                    ivCheck.setVisibility(View.VISIBLE);
                    ivCheck2.setVisibility(View.VISIBLE);
                    ivCheck3.setVisibility(View.VISIBLE);
                    ivCheck4.setVisibility(View.VISIBLE);
                    ivCheck5.setVisibility(View.VISIBLE);
                    ivCheck6.setVisibility(View.VISIBLE);
                    ivCheck7.setVisibility(View.VISIBLE);
                    btnNaarEvaluatie.setEnabled(true);
//                    btnNaarQuiz.setEnabled(false);
//                    btnNaarFAQ.setEnabled(false);
//                    btnNaarBereikbaarheid.setEnabled(false);
//                    btnNaarAanspreek.setEnabled(false);
//                    btnNaarGegevens.setEnabled(false);
//                    btnNaarIntrodagen.setEnabled(false);
//                    btnNaarFilmpje.setEnabled(false);
                }
                if(stap == 8){
                    ivCheck.setVisibility(View.VISIBLE);
                    ivCheck2.setVisibility(View.VISIBLE);
                    ivCheck3.setVisibility(View.VISIBLE);
                    ivCheck4.setVisibility(View.VISIBLE);
                    ivCheck5.setVisibility(View.VISIBLE);
                    ivCheck6.setVisibility(View.VISIBLE);
                    ivCheck7.setVisibility(View.VISIBLE);
                    ivCheck8.setVisibility(View.VISIBLE);

//                    btnNaarEvaluatie.setEnabled(false);
//                    btnNaarQuiz.setEnabled(false);
//                    btnNaarFAQ.setEnabled(false);
//                    btnNaarBereikbaarheid.setEnabled(false);
//                    btnNaarAanspreek.setEnabled(false);
//                    btnNaarGegevens.setEnabled(false);
//                    btnNaarIntrodagen.setEnabled(false);
//                    btnNaarFilmpje.setEnabled(false);

                    Log.i("stap8","zit erin");
                }
            }


        }
        catch(JSONException e){

            e.printStackTrace();
        }
    }
}
