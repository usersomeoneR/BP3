package com.example.bp3;


import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONTokener;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;


public class QuizActivity extends Activity {
    private RadioGroup radioQuestion2Group,radioQuestion3Group,radioQuestion4Group,radioQuestion5Group,radioQuestion6Group;
    private RadioButton radioQuestion2Buttom,radioQuestion3Buttom,radioQuestion4Buttom,radioQuestion5Buttom,radioQuestion6Buttom;
    private Button confirmBT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        addListenerOnButton();
    }

    public void addListenerOnButton() {

        radioQuestion2Group = (RadioGroup) findViewById(R.id.radioQuestion2);
        radioQuestion3Group = (RadioGroup) findViewById(R.id.radioQuestion3);
        radioQuestion4Group = (RadioGroup) findViewById(R.id.radioQuestion4);
        radioQuestion5Group = (RadioGroup) findViewById(R.id.radioQuestion5);
        radioQuestion6Group = (RadioGroup) findViewById(R.id.radioQuestion6);
        confirmBT = (Button) findViewById(R.id.confirmBT);

        confirmBT.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

               int selectedId2 = radioQuestion2Group.getCheckedRadioButtonId();
               int selectedId3 = radioQuestion3Group.getCheckedRadioButtonId();
               int selectedId4 = radioQuestion4Group.getCheckedRadioButtonId();
               int selectedId5 = radioQuestion5Group.getCheckedRadioButtonId();
               int selectedId6 = radioQuestion6Group.getCheckedRadioButtonId();


                radioQuestion2Buttom = (RadioButton) findViewById(selectedId2);
                radioQuestion3Buttom = (RadioButton) findViewById(selectedId3);
                radioQuestion4Buttom = (RadioButton) findViewById(selectedId4);
                radioQuestion5Buttom = (RadioButton) findViewById(selectedId5);
                radioQuestion6Buttom = (RadioButton) findViewById(selectedId6);

//
                Toast.makeText(QuizActivity.this,
                        radioQuestion2Buttom.getText(), Toast.LENGTH_SHORT).show();
                String radio2 = String.valueOf(radioQuestion2Buttom.getText());
                String url2 = "https://adaonboarding.ml/t1/insertQuizAntwoord.php?studentnummer=1234567&antwoord=";
                url2 += radio2;
                Log.i("TAG",url2);


                Toast.makeText(QuizActivity.this,
                        radioQuestion3Buttom.getText(), Toast.LENGTH_SHORT).show();

                String radio3 = String.valueOf(radioQuestion3Buttom.getText());
                String url3 = "https://adaonboarding.ml/t1/insertQuizAntwoord.php?studentnummer=1234567&antwoord=" + radio3;
                Log.i("TAG",url3);

                Toast.makeText(QuizActivity.this,
                        radioQuestion4Buttom.getText(), Toast.LENGTH_SHORT).show();
                String radio4 = String.valueOf(radioQuestion4Buttom.getText());
                String url4 = "https://adaonboarding.ml/t1/insertQuizAntwoord.php?studentnummer=1234567&antwoord=" + radio4;
                Log.i("TAG",url4);

                Toast.makeText(QuizActivity.this,
                        radioQuestion5Buttom.getText(), Toast.LENGTH_SHORT).show();
                String radio5 = String.valueOf(radioQuestion5Buttom.getText());
                String url5 = "https://adaonboarding.ml/t1/insertQuizAntwoord.php?studentnummer=1234567&antwoord=" + radio5;
                Log.i("TAG",url5);

                Toast.makeText(QuizActivity.this,
                        radioQuestion6Buttom.getText(), Toast.LENGTH_SHORT).show();
                String radio6 = String.valueOf(radioQuestion6Buttom.getText());
                String url6 = "https://adaonboarding.ml/t1/insertQuizAntwoord.php?studentnummer=1234567&antwoord=" + radio6;
                Log.i("TAG",url6);

                try {
                    URL url_g = new URL(url2);
                    
                    Log.i("TAG", String.valueOf(url_g));
                } catch(MalformedURLException e) {
                    //Do something with the exception.
                }

            }
        });

        }











    }
