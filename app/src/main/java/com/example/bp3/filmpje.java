package com.example.bp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class filmpje extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    private VolleyHelper volleyhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmpje);
        String studentnummer = "1234567";

        volleyhelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t1/");
        volleyhelper.get("Studentgegevens.php?studentnummer=" + studentnummer, null, this, this);

        WebView mWebView = findViewById(R.id.wvFilmpje);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("http://www.youtube.com/embed/OUtgotW5T_E");
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

        try {
            JSONArray array = response.getJSONArray("rij");
            TextView tvWelkomswoord = findViewById(R.id.tvWelkomswoord);
            for (int i = 0; i < array.length(); i++) {
                JSONObject rij = array.getJSONObject(i);
                String naam = rij.getString("gebruikersnaam");
                tvWelkomswoord.setText("Beste " + naam + ", Wat leuk dat jij je hebt aangemeld voor de Associate degrees Academie! Wij hopen dat jij net zo veel zin in het nieuwe schooljaar hebt als wij hebben. In deze app zul je een aantal stappen doorlopen om goed het nieuwe schooljaar te beginnen. Mocht je na het doorlopen van deze stappen nog vragen hebben, kun je deze vragen altijd nog stellen!                         ");
            }

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
