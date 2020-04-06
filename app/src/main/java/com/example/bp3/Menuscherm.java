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

    public void gaEvaluatie(View view) {
        Intent intentEvaluatie = new Intent(this, Evaluatie.class);
        startActivity(intentEvaluatie);
    }

    public void naarContact(View view) {
        Intent intentContact = new Intent(this, contact.class);
        startActivity(intentContact);
    }

    public void ganaarIntrodagen(View view) {
        Intent intentIntrodagen = new Intent(this, Introdagen.class);
        startActivity(intentIntrodagen);
    }

    public void startQuiz(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
}
