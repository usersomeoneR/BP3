package com.example.bp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class filmpje extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    private VolleyHelper volleyhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmpje);
        String studentnummer = "1234567";
        String url = "";
        String beschrijving = "";

        volleyhelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t1/");
        volleyhelper.get("Studentgegevens.php?studentnummer=" + studentnummer, null, this, this);
        volleyhelper.get("Filmpje.php?url=" + url, null, this, this);
        volleyhelper.get("Filmpje.php?beschrijving=" + beschrijving, null, this, this);


    }

    public void naarMenu(View view) {
        Intent intentMenu = new Intent(this, Menuscherm.class);
        startActivity(intentMenu);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

        try{
            JSONArray array = response.getJSONArray("rij");
            WebView mWebView = findViewById(R.id.wvFilmpje);
            for (int i = 0; i < array.length(); i++) {
                JSONObject rij = array.getJSONObject(i);
                String url = rij.getString("url");
                mWebView.getSettings().setJavaScriptEnabled(true);
                mWebView.setWebViewClient(new WebViewClient());
                mWebView.loadUrl(url);
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            JSONArray array = response.getJSONArray("rij");
            TextView tvWelkomswoord = findViewById(R.id.tvWelkomswoord);
            for (int i = 0; i < array.length(); i++) {
                JSONObject rij = array.getJSONObject(i);
                String naam = rij.getString("gebruikersnaam");
                tvWelkomswoord.setText("Beste "+ naam + " ");
            }

        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            JSONArray array = response.getJSONArray("rij");
            TextView tvWelkomswoord = findViewById(R.id.tvWelkomswoord);
            for (int i = 0; i < array.length(); i++) {
                JSONObject rij = array.getJSONObject(i);
                String beschrijving = rij.getString("beschrijving");
                tvWelkomswoord.append(beschrijving);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }    
    }


}
