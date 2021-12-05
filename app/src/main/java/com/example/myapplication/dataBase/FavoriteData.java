package com.example.myapplication.dataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.myapplication.models.RecipeModel;

import java.io.Serializable;

@Entity(tableName = "table_name")
public class FavoriteData implements Serializable {
    //id column
    @PrimaryKey(autoGenerate = true)
    private int ID;

    //create JSON column ;
    private String myModel;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMyModel() {
        return myModel;
    }

    public void setMyModel( String myModel) {
        this.myModel = myModel;
    }

}
