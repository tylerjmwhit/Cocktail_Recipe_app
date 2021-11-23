package com.example.myapplication.dataBase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {FavoriteData.class}, version = 1)
public abstract class AppData extends RoomDatabase {
    //database instance
    private static AppData database;
    //database name
    private static String DATABASE_NAME = "Favorites";

    public synchronized static AppData getInstance(Context context){
        //check condition
        if( database == null){
            //when null initialize database
            database = Room.databaseBuilder(context.getApplicationContext()
                    ,AppData.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }
    // Create Data access object
    public abstract FavoriteDao favoriteDao();


}
