package com.example.bp3;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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


        // hier moet de nieuwe class verwezen worden.
//        Button buttomterug = findViewById(R.id.Terug_BT);
//        buttomterug.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startQuiz();
//            }
//        });



        String studentnummer = "1234567";

        volleyhelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t1/");
                volleyhelper.get("Bereikbaarheid.php", null, this, this);

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        TextView TV_view = findViewById(R.id.TV_view);
        TV_view.setText("Dit zijn de bustijden");
        try {
            JSONArray array = response.getJSONArray("rij");
            for (int i = 0; i < array.length(); i++) {
                JSONObject rij = array.getJSONObject(i);
                String busnummer = rij.getString("busnummer");
                String bustijd = rij.getString("bustijd");
                TV_view.append(busnummer + " heeft " + bustijd + "\n");
            }

            }
        catch (JSONException e) {
                e.printStackTrace();
        }

//        private void startQuiz() {
//            Intent intent = new Intent(bereikbaarActivity.this, *nieuweclass*.class);
//            startActivity(intent);

        }
}
