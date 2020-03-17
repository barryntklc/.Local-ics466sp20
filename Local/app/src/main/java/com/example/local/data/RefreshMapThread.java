package com.example.local.data;

import android.util.Log;

import com.example.local.ExploreActivity;
import com.example.local.ExploreActivity;

import java.util.ArrayList;
import java.util.List;

public class RefreshMapThread extends Thread {
    private ArrayList<Post> mapItems = new ArrayList<Post>();
    private ArrayList<Post> retrievedPostsToBeAdded = new ArrayList<Post>();

    ExploreActivity mv;

    public RefreshMapThread(ExploreActivity mv) {
        this.mv = mv;
    }

    @Override
    public void run() {
        Log.i("run", "starting");

        while(true) {
            try {
                List<Post> retrievedPosts = ExploreActivity.db.postDao().getAll();
                for (Post retrievedPost : retrievedPosts) {
                    if (!inCoords(retrievedPost)) {
                        mapItems.add(retrievedPost);

//                        MapViewActivity.mMap.addMarker(new MarkerOptions().position(new LatLng(loc.getLatitude(), loc.getLongitude())).title("It's Me!"));
//                        MapViewActivity.mMap.addMarker(new MarkerOptions().position(p.latLng).title(p.postText));
//                        MapViewActivity.addMarker(p);

//                        mv.runOnUiThread(new Runnable() {
//
//
//                            @Override
//                            public void run() {
//                                MapViewActivity.addMarker(new MarkerOptions().position(p.latLng).title(p.postText));
//                            }
//                        }, p);

                        retrievedPostsToBeAdded.add(retrievedPost);


                        Log.i("dbitem-add", "Added " + Integer.toString(retrievedPost.pid) + " " + retrievedPost.postText + " " + retrievedPost.latLng.toString());
                    }
                }
                mv.runOnUiThread(new RefreshMapRunnable(retrievedPostsToBeAdded, mv));
//                retrievedPostsToBeAdded.clear();

                Thread.sleep(4000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    boolean inCoords(Post p) {
        boolean contains = false;
        for (Post pp : mapItems) {
            if (p.pid == pp.pid) {
                contains = true;
                break;
            }
        }
        return contains;
    }
}
