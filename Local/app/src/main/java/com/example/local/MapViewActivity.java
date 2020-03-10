package com.example.local;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.room.Room;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.local.data.AppDatabase;
import com.example.local.data.AppDatabaseAsyncClass;
import com.example.local.data.Post;
import com.example.local.data.PostDao;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import java.util.Calendar;
import java.util.Date;

public class MapViewActivity extends AppCompatActivity implements GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener, OnMapReadyCallback {

    //https://developer.android.com/training/data-storage/room
    public static AppDatabase db;

    private GoogleMap mMap;

    private MenuDrawerActivity dl;
    private ActionBarDrawerToggle t;

    private Toolbar this_toolbar;

    public static final int NEW_POST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);

        Toolbar new_toolbar = (Toolbar) findViewById(R.id.toolbar);

        this_toolbar = findViewById(R.id.toolbar);
//        ImageButton menubtn = (ImageButton) this_toolbar.getChildAt(0);
//        menubtn.setImageResource(R.drawable.ic_back_button);

        TextView textvw = (TextView) this_toolbar.getChildAt(1);
        textvw.setText("Explore");
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.setSupportActionBar(new_toolbar);
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "local-db").build();

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        t = new ActionBarDrawerToggle(this, R.layout.content_menu_drawer, );

//        dl = new DrawerLayout(this, R.layout.content_menu_drawer);
        MenuDrawerActivity dl = new MenuDrawerActivity();
//        dl.show
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener((GoogleMap.OnMyLocationButtonClickListener) this);
        mMap.setOnMyLocationClickListener((GoogleMap.OnMyLocationClickListener) this);

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        //sources
        //https://stackoverflow.com/questions/18425141/android-google-maps-api-v2-zoom-to-current-location



//        this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(l.getLatitude(), l.getLongitude()), 13));

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        Log.i("onMapReady", "width: " + width);
        Log.i("onMapReady", "height: " + height);

        moveToCurrentPosition();
    }

    private void moveToCurrentPosition() {
        Criteria cri = new Criteria();
        LocationManager locm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        Location loc = locm.getLastKnownLocation(locm.getBestProvider(cri, false));

        if (loc != null) {
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(new LatLng(loc.getLatitude(), loc.getLongitude()))      // Sets the center of the map to location user
                    .zoom(17)                   // Sets the zoom
                    .build();                   // Creates a CameraPosition from the builder
            mMap.setPadding(512, 0, 0, 0);
            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//          mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        }

//        mMap.addM
        //https://developers.google.com/maps/documentation/urls/guide
    }

    private void animateToCurrentPosition() {
        Criteria cri = new Criteria();
        LocationManager locm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        Location loc = locm.getLastKnownLocation(locm.getBestProvider(cri, false));

        if (loc != null) {
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(new LatLng(loc.getLatitude(), loc.getLongitude()))      // Sets the center of the map to location user
                    .zoom(17)                   // Sets the zoom
                    .build();                   // Creates a CameraPosition from the builder
            mMap.setPadding(512, 0, 0, 0);
//            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }

//        mMap.addM
        //https://developers.google.com/maps/documentation/urls/guide
    }

//    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }

//    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }

    public void optionsButtonClicked(View view) {
        Log.i("Map-Options", "Options button clicked!");
    }

    public void menuButtonClicked(View view) {
        Log.i("Map-Menu", "Menu button clicked!");

//        this.dl.show();
    }

    public void newPostButtonClicked(View view) {
        Intent i = new Intent(this, NewPostActivity.class);
        startActivityForResult(i, NEW_POST);
    }

    public LatLng getCurrentLatLng() {
        Criteria cri = new Criteria();
        LocationManager locm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
//            return;
        }
        Location loc = locm.getLastKnownLocation(locm.getBestProvider(cri, false));
        LatLng ll = new LatLng(loc.getLatitude(), loc.getLongitude());
        return ll;
    }

    public Date getCurrentTime() {
        Date currentTime = Calendar.getInstance().getTime();
        return currentTime;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_POST) {
            if (resultCode == RESULT_OK) {
                //get post text
                String post_text = data.getStringExtra(NewPostActivity.POST_REPLY);

                //get current location
                LatLng post_location = getCurrentLatLng();

                //get current time
                Date post_time = getCurrentTime();

                Log.i("New-Post", "Creating new post:\n"
                        + "\tLocation: "
//                        + post_location.toString()
                        + post_location.toString().substring(post_location.toString().indexOf("(") + 1, post_location.toString().indexOf(")"))
                        + "\n"
                        + "\tTime: "
                        + post_time.toString()
                        + "\n"
                        + "\tText:\n"
                        + post_text
                );
                Log.i("Time", post_time.toString());

                Toast.makeText(this, "Post Submitted!", Toast.LENGTH_SHORT).show();

                AppDatabaseAsyncClass n = new AppDatabaseAsyncClass(1024, post_text, post_location, post_time);
                n.execute();

//                db.postDao().
                //settings
                //  after making a new post
                //      1. do nothing
                //      2. animate to current position
                //      3. move to current position

                //if return to position set
//                animateToCurrentPosition();
            }
        }
    }
}
