/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.lifecycles.bagian3;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;

public class BoundLocationManager {
    public static void bindLocationListener(LifecycleOwner lifecycleOwner, LocationListener locationListener, Context context){
        new BoundLocationListener(lifecycleOwner, locationListener, context);
    }

    private static class BoundLocationListener implements LifecycleObserver {
        private final Context mContext;
        private LocationManager mLocationManager;
        private final LocationListener mListener;

        public BoundLocationListener(LifecycleOwner lifecycleOwner, LocationListener locationListener, Context context) {
            mContext = context;
            mListener = locationListener;
            lifecycleOwner.getLifecycle().addObserver(this);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        @SuppressLint("MissingPermission")
        void addLocationListener(){
            mLocationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mListener);

            Log.d("BoundedLocationMgr", "Listener added");

            Location lastLocation = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastLocation!=null){
                mListener.onLocationChanged(lastLocation);
            }
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        void removeLocationListener(){
            if (mListener == null){
                return;
            }
            mLocationManager.removeUpdates(mListener);
            mLocationManager = null;
            Log.d("BoundedLocationMgr", "Listener removed");
        }
    }
}
