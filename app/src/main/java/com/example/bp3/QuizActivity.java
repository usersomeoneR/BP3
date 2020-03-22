package com.example.bp3;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


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
                Toast.makeText(QuizActivity.this,
                        radioQuestion3Buttom.getText(), Toast.LENGTH_SHORT).show();
                Toast.makeText(QuizActivity.this,
                        radioQuestion4Buttom.getText(), Toast.LENGTH_SHORT).show();
                Toast.makeText(QuizActivity.this,
                        radioQuestion5Buttom.getText(), Toast.LENGTH_SHORT).show();
                Toast.makeText(QuizActivity.this,
                        radioQuestion6Buttom.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        }











    }
