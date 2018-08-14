/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.lifecycles.bagian1;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

public class MainViewModel1 extends ViewModel {

    @Nullable
    private Long mStartTime;

    @Nullable
    public Long getmStartTime() {
        return mStartTime;
    }

    public void setmStartTime(@Nullable Long mStartTime) {
        this.mStartTime = mStartTime;
    }
}
