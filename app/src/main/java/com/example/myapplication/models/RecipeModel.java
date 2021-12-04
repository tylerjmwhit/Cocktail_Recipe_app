package com.example.myapplication.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class RecipeModel implements Parcelable
{
    private String recipeName;
    private ArrayList<String> ingredients;
    private String recipe;
    private String thumbNail;

    //Simple constructor
    public RecipeModel()
    {
        thumbNail = "";
        recipeName = "";
        ingredients = new ArrayList<>();
        recipe = "";
    }
    //Parameterized Constructor that takes a Parcel object
    public RecipeModel(Parcel in)
    {
        thumbNail = in.readString();
        recipeName = in.readString();
        ingredients = in.createStringArrayList();
        recipe = in.readString();
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

    public String getRecipeName() { return recipeName; }
    public ArrayList<String> getIngredients() { return ingredients; }
    public String getRecipe(){return recipe;}
    public String getThumbNail() { return thumbNail;}

    public void setRecipeName(String value) { this.recipeName = value; }
    public void setIngredients(String value) { this.ingredients.add(value); }
    public void setIngredients(ArrayList<String> value){this.ingredients.addAll(value);}
    public void setRecipe(String value){this.recipe = value;}
    public void setThumbNail(String value){this.thumbNail = value;}

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(thumbNail);
        parcel.writeString(recipeName);
        parcel.writeStringList(ingredients);
        parcel.writeString(recipe);
    }
}
