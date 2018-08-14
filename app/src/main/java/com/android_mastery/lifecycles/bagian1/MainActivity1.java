/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.lifecycles.bagian1;

import android.arch.lifecycle.ViewModelProviders;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;

import com.android_mastery.lifecycles.R;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        MainViewModel1 mainViewModel1 = ViewModelProviders.of(this).get(MainViewModel1.class);
        Chronometer chronometer = findViewById(R.id.chronometer);

        if (mainViewModel1.getmStartTime() == null){
            long startTime = SystemClock.elapsedRealtime();
            mainViewModel1.setmStartTime(startTime);
            chronometer.setBase(startTime);
        }else{
            chronometer.setBase(mainViewModel1.getmStartTime());
        }

        chronometer.start();
    }
}
