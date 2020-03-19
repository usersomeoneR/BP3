package com.example.bp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bp3.Menuscherm;
import com.example.bp3.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void naarMenu(View v) {
        Intent intent = new Intent(this, Menuscherm.class);
        startActivity(intent);
    }
}
