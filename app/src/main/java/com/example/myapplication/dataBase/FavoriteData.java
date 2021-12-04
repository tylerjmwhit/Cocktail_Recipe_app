package com.example.myapplication.dataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "table_name")
public class FavoriteData implements Serializable {
    //id column
    @PrimaryKey(autoGenerate = true)
    private int ID;

    //create JSON column ;
    private String JSON;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getJSON() {
        return JSON;
    }

    public void setJSON(String JSON) {
        this.JSON = JSON;
    }

}
