package com.example.local;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.DatabaseConfiguration;
import androidx.room.Entity;
import androidx.room.InvalidationTracker;
import androidx.room.PrimaryKey;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.google.android.gms.maps.model.LatLng;

import java.util.Date;

public class LocalDatabase extends RoomDatabase {

    public void addUser() {

    }

    public void getUser() {

    }

    public void addPost(int uid, String text, Date datetime, LatLng loc) {

    }

    public void getPost(int pid) {

    }

    @Entity
    public class User {
        @PrimaryKey
        public int uid;
        @ColumnInfo(name = "firstName")
        public String firstName;
        @ColumnInfo(name = "lastName")
        public String lastName;
        @ColumnInfo(name = "userName")
        public String userName;
        @ColumnInfo(name = "passWord")
        public String passWord;
    }

    @Entity
    public class Post {
        @PrimaryKey
        public int pid;
        @ColumnInfo(name = "postText")
        public String postText;
        @ColumnInfo(name = "dateTime")
        public Date dateTime;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
