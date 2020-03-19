package com.example.bp3;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class QuizActivity extends AppCompatActivity {
    RadioGroup radio;
    int count_correct_answer =0;
    int count_wrong_answer=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        radio = (RadioGroup) findViewById(R.id.radioGroup2);

    }


    public void confirmBT(View view) {
        RadioGroup radio = (RadioGroup) findViewById(R.id.radioGroup2);

//
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//
//        radioButtonID = radio.getCheckedRadioButtonId();
//        View radioButton = radio.findViewById(radioButtonID);
//        if(radioButton.getId() == R.id.radio_button12){
//            count_correct_answer++;
//        }
//        else{
//            count_wrong_answer++;
//        }
//
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.RBoptie1:
//                if (checked)
//                    break;
//
//            case R.id.RBoptie2:
//                if (checked)
//                    radio.clearCheck();
//                break;
//
//            case R.id.RBoptie3:
//                if (checked)
//                    break;
//        }
    }
}