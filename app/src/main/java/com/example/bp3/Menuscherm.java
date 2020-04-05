package com.example.bp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bp3.R;

public class Menuscherm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuscherm);
    }

    public void gaStudentgegevens(View view) {
        Intent intentGaNaarStudentgegevens = new Intent(this, Studentgegevens.class);
        startActivity(intentGaNaarStudentgegevens);
    }

    public void gaFilmpje(View view) {
        Intent intentFilmpje = new Intent(this, filmpje.class);
        startActivity(intentFilmpje);
    }
}
