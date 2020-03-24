package com.example.bp3;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String sUrl = "http://192.168.0.101:8080/WebApplication1/webresources/model.smaken";
        RequestQueue rq = Volley.newRequestQueue(this);
        StringRequest sr = new StringRequest(Request.Method.GET, sUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                builtItems(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });
        rq.add(sr);
    }

    public void builtItems(String response)
    {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response)));
            NodeList data = doc.getElementsByTagName("smakens");
            NodeList alData = data.item(0).getChildNodes();
            ArrayList<String> lijst = new ArrayList<>();
            System.out.println(alData.toString());
            for(int i = 0; i<alData.getLength(); i++){
                NodeList n = alData.item(i).getChildNodes();
                for (int j = 0; j < n.getLength(); j++ ){
                    Node naam = n.item(j);
                    lijst.add(naam.getTextContent());
                }

            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lijst);
            ListView lv = findViewById(R.id.lv);
            lv.setAdapter(adapter);
        }catch(Exception ex){

        }
    }
}

