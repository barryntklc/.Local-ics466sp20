package com.example.local.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.android.gms.maps.model.LatLng;

import java.util.Date;

@Entity
public class Post {
    @PrimaryKey (autoGenerate = true)
    public int pid;
    @ColumnInfo (name = "uid")
    public int uid;
    @ColumnInfo(name = "postText")
    public String postText;
    @ColumnInfo(name = "dateTime")
    public Date dateTime;
    @ColumnInfo(name = "latLng")
    public LatLng latLng;
}