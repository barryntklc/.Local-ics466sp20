package com.example.local.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.example.local.MapViewActivity;
import com.example.local.R;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class RefreshMapRunnable implements Runnable {

    ArrayList<Post> posts;
    MapViewActivity mv;

    public RefreshMapRunnable(ArrayList<Post> posts, MapViewActivity mv) {
        this.posts = posts;
        this.mv = mv;
    }

    @Override
    public void run() {
        for (Post p : posts) {
            Log.i("runnable-refresh", "adding Marker for Post at " + p.latLng.toString() + ", message \"" + p.postText+ "\"");
            mv.mMap.addMarker(new MarkerOptions().position(p.latLng).title(p.postText).icon(bitmapDescriptorFromVector(mv.getApplicationContext(), R.drawable.ic_post_button)));
//            MapViewActivity.mMap.
        }

        posts.clear();
    }

    //literally copypasta'd from
    //https://stackoverflow.com/questions/42365658/custom-marker-in-google-maps-in-android-with-vector-asset-icon/45564994#45564994
    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
//        DrawableCompat.
        DrawableCompat.setTint(vectorDrawable, mv.getResources().getColor(R.color.colorPrimary));
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}
