package com.gta.administrator.infraredcontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AirConditionControlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_condition_control);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
