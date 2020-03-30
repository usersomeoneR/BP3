package com.example.bp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        naarEvaluatie();

    }
    public void naarEvaluatie(){
        Intent intent = new Intent(this, Evaluatie.class);
        startActivity(intent);
    }
}
