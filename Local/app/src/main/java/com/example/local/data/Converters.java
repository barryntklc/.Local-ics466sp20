package com.example.local.data;

import androidx.room.TypeConverter;

import com.google.android.gms.maps.model.LatLng;

import java.util.Date;

public class Converters {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static LatLng fromLatLng(String value) {
        String[] latLngString = value.split(",");
        return value == null ? null : new LatLng(Double.parseDouble(latLngString[0]), Double.parseDouble(latLngString[1]));
    }

    @TypeConverter
    public static String latLngToString(LatLng latLng) {
        String post_location = latLng.toString();
        return latLng == null ? null : (post_location.substring(post_location.toString().indexOf("(") + 1, post_location.toString().indexOf(")")));
    }
}
