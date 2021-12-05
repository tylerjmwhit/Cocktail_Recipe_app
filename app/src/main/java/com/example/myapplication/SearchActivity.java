package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.models.RecipeModel;

import java.util.List;


//todo recyler view for this page
public class SearchActivity extends AppCompatActivity {
    public static final String INGRE_KEY = "INGRE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent newIent = getIntent();
        List<RecipeModel> myModels  = newIent.getParcelableArrayListExtra(SearchActivity.INGRE_KEY);

    }
}