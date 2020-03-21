package com.example.local.data;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.example.local.ExploreActivity;

public class ExploreLocationListener implements android.location.LocationListener {

    ExploreActivity mv;

    public ExploreLocationListener(ExploreActivity mv) {
        this.mv = mv;
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.i("locl", "location changed!");

        if (mv.lockMap) {
            mv.animateToCurrentPosition();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
