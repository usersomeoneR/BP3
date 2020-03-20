package com.example.bp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private RequestQueue mQueue;
    private Button btnNotificationn;
    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNotificationn = findViewById(R.id.btnNotification);
        mTextView = findViewById(R.id.textView);
        mQueue = Volley.newRequestQueue(this);

        btnNotificationn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                jsonParse();

            }
        });




        Intent notifyIntent = new Intent(this,MyReceiver.class);
        //Stuur iedere 24 uur een notificatie over de stap.
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (this, 1, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(),
                86400000, pendingIntent);
    }


    private void jsonParse(){
        //De huidige gebruiker is een tester: dit is standaard 1234567
        String url = "https://adaonboarding.ml/t1/Studentstap.php?studentnummer=1234567";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response){
                        try {
                            JSONArray jsonArray = response.getJSONArray("rij");
                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject rij = jsonArray.getJSONObject(i);

                                int id = rij.getInt("id");
                                int studentnummer = rij.getInt("studentnummer");
                                int stapnu = rij.getInt("stapnu");

                                mTextView.append("ID: " + String.valueOf(id) + ", Studentnummer: " + String.valueOf(studentnummer) + ", Stapnu: " + String.valueOf(stapnu) + "\n\n");

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
}
