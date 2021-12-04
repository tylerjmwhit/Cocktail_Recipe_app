package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecipeViewActivity extends AppCompatActivity {

    private Button homeButton;
    private Button favoriteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);
        homeButton = findViewById(R.id._homeButton);
        favoriteButton = findViewById(R.id._favorites_recipePage);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainView = new Intent(RecipeViewActivity.this, MainActivity.class);
                startActivity(mainView);
            }
        });

        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent favoriteView = new Intent(RecipeViewActivity.this, FavoritesActivity.class);
                startActivity(favoriteView);
            }
        });
    }
}