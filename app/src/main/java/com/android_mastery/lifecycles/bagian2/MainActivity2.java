/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.lifecycles.bagian2;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android_mastery.lifecycles.R;

public class MainActivity2 extends AppCompatActivity {

    private MainViewModel2 mainViewModel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel2 = ViewModelProviders.of(this).get(MainViewModel2.class);

        subscribe();
    }

    private void subscribe() {
        final Observer<Long> elapsedTimeObbserver = new Observer<Long>() {
            @Override
            public void onChanged(@Nullable Long aLong) {
                String newText = String.format("%d detik", aLong);
                ((TextView) findViewById(R.id.txtChronometer)).setText(newText);
                Log.d("MainActivity1" , "UpdateTime");
            }
        };
        mainViewModel2.getmElapsedTime().observe(this, elapsedTimeObbserver);
    }
}
