package com.example.bp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FAQ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_a_q);
    }

    public void gaTerugNaarMenuD(View view) {
        Intent intentMenuNu = new Intent(this, Menuscherm.class);
        startActivity(intentMenuNu);
    }
}
