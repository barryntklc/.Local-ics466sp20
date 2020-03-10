package com.example.local.data;

import android.os.AsyncTask;
import android.util.Log;

import com.example.local.MapViewActivity;

import java.util.List;

public class RefreshMapAsyncClass extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... voids) {

        List<Post> i = MapViewActivity.db.postDao().getAll();
        for (Post p : i) {
            Log.i("dbitem", Integer.toString(p.pid) + " " + p.postText + " " + p.latLng.toString());
        }

        return null;
    }
}
