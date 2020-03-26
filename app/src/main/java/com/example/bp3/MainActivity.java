package com.example.bp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void naarEvaulutatie(View v){
        Intent inent = new Intent(this, Evaluatie.class);
        startActivity(intent);
    }
}
