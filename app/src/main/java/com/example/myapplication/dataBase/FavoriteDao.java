package com.example.myapplication.dataBase;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavoriteDao {
    //insert query
    @Insert
    void insert (FavoriteData favoriteData);

    //delete query
    @Delete
    void delete(FavoriteData favoriteData);

    //delete all
    @Delete
    void reset(List<FavoriteData> favoriteData);

    //get all data
    @Query("SELECT * FROM table_name")
    List<FavoriteData> getAll();

}
