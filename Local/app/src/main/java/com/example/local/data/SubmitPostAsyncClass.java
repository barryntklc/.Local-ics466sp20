package com.example.local.data;

import android.os.AsyncTask;

import com.example.local.ExploreActivity;
import com.google.android.gms.maps.model.LatLng;

import java.util.Date;

public class SubmitPostAsyncClass extends AsyncTask <Void, Void, String> {
    private int uid;
    private LatLng post_location;
    private String post_text;
    private Date post_time;

    public SubmitPostAsyncClass(int uid, String post_text, LatLng post_location, Date post_time) {
        this.uid = uid;
        this.post_location = post_location;
        this.post_text = post_text;
        this.post_time = post_time;
    }

    @Override
    protected String doInBackground(Void... voids) {
        Post p = new Post();
        p.pid = 0;
        p.uid = 1024;
        p.latLng = this.post_location;
        p.postText = this.post_text;
        p.dateTime = this.post_time;

        ExploreActivity.db.postDao().insert(p);

        return null;
    }
}
