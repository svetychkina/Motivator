package com.conscience.motivator;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Chronometer;


public class ContentActivity extends AppCompatActivity {

    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_layout);

        chronometer = (Chronometer)findViewById(R.id.goalTime);
        chronometer.setFormat("H:MM:SS");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            chronometer.setCountDown(true);
        }
    }
}
