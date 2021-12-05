package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.models.RecipeModel;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// todo make a button to save recipe to the favorites database
public class RecipeViewActivity extends AppCompatActivity {

    private Button homeButton;
    private Button favoriteButton;
    private TextView recipeBody;
    private TextView recipeName;
    private TextView ingredients;
    private ImageView recipeImage;
    public static final String RECIPE_KEY = "RECIPE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);

        //pulls in the RecipeModel from the intent
        Intent newIntent = getIntent();
        RecipeModel myRecipe = newIntent.getParcelableExtra(RecipeViewActivity.RECIPE_KEY);

        //the recipe instructions
        recipeBody = findViewById(R.id._recipeBody);
        recipeBody.setText(myRecipe.getRecipe());

        //sets the recipe name
        recipeName = findViewById(R.id._recipeName);
        recipeName.setText(myRecipe.getRecipeName());

        //sets the recipe ingredients
        ingredients = findViewById(R.id._ingredients);
        ingredients.setText(myRecipe.getIngredients().toString());

        //get the thumbnail form the URL and sets it
        recipeImage = findViewById(R.id._recipeImage);
        recipeImage.setImageBitmap(getBitmapFromURL(myRecipe.getThumbNail()));

        //the buttons
        homeButton = findViewById(R.id._homeButton);
        favoriteButton = findViewById(R.id._favorites_recipePage);

        //when home button is pressed go to main activity
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainView = new Intent(RecipeViewActivity.this, MainActivity.class);
                startActivity(mainView);
            }
        });

        //when favorites button is pressed go to favorites activity
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent favoriteView = new Intent(RecipeViewActivity.this, FavoritesActivity.class);
                startActivity(favoriteView);
            }
        });
    }

    public static Bitmap getBitmapFromURL(String src) {
        final Bitmap[] bmp = new Bitmap[1];
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(src);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.connect();
                    InputStream input = connection.getInputStream();
                    bmp[0] = BitmapFactory.decodeStream(input);
                } catch (IOException e) {
                    e.printStackTrace();
                    bmp[0] = null;
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bmp[0];
    }
}



//
//
//
//
//
//


