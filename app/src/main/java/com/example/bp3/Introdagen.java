package com.example.bp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Introdagen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introdagen);
    }

    public void GaTerugnaarMenu(View view) {
        Intent intentTerug = new Intent(this, Menuscherm.class);
        startActivity(intentTerug);
    }
}
