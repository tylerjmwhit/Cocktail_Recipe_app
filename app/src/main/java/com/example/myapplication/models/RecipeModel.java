package com.example.myapplication.models;

import android.os.Parcel;
import android.os.Parcelable;

public class RecipeModel implements Parcelable
{
    private String recipeName;
    private String ingredients;

    //Simple constructor
    public RecipeModel()
    {
        recipeName = "";
        ingredients ="";
    }
    //Parameterized Constructor that takes a Parcel object
    public RecipeModel(Parcel in)
    {
        recipeName = in.readString();
        ingredients = in.readString();
    }

    public static final Creator<RecipeModel> CREATOR = new Creator<RecipeModel>()
    {
        @Override
        public RecipeModel createFromParcel(Parcel in)
        {
            return new RecipeModel(in);
        }

        @Override
        public RecipeModel[] newArray(int size)
        {
            return new RecipeModel[size];
        }
    };

    public String getRecipeName() {
        return recipeName;
    }
    public String getIngredients() { return ingredients; }

    public void setRecipeName(String value) {
        this.recipeName = value;
    }
    public void setIngredients(String value) { this.ingredients = value; }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(recipeName);
        parcel.writeString(ingredients);
    }
}
