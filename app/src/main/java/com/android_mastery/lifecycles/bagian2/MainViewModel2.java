/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.lifecycles.bagian2;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.SystemClock;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainViewModel2 extends ViewModel {

    private static final int ONE_SECOND = 1000;

    private MutableLiveData<Long> mElapsedTime = new MutableLiveData<>();

    private long mInitialTime;

    public MainViewModel2() {
        mInitialTime = SystemClock.elapsedRealtime();
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                final long newValue = (SystemClock.elapsedRealtime() - mInitialTime)/1000;
                mElapsedTime.postValue(newValue);
            }
        },ONE_SECOND, ONE_SECOND);
    }

    public MutableLiveData<Long> getmElapsedTime() {
        return mElapsedTime;
    }
}
