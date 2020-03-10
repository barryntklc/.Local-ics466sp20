package com.example.local.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

//import com.example.local.LocalDatabase;

import java.util.List;

@Dao
public interface PostDao {
    @Query("SELECT * FROM post")
    List<Post> getAll();

    @Insert
    void insertAll(Post... posts);

    @Insert
    void insert(Post post);

    @Delete
    void delete(Post post);
}
