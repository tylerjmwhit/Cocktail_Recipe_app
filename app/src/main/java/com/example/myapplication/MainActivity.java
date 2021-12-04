package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

import com.example.myapplication.models.RecipeModel;
import com.example.myapplication.network.RecipeSearchByIngredientAsyncTask;
import com.example.myapplication.network.RecipeSearchByNameAsyncTask;
import com.example.myapplication.network.RecipeSearchByNameAsyncTask;
import com.example.myapplication.dataBase.AppData;
import com.example.myapplication.dataBase.FavoriteData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private EditText searchName;
    private Button nameButton;
    private EditText searchIngre;
    private Button ingreButton;
    private Button favorites;

    List<FavoriteData> dataList = new ArrayList<>();
    AppData database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Search bar where text will go to search by name
        searchName = findViewById(R.id._name_search);

        //Name button that when clicked will search for a recipe by name
        nameButton = findViewById(R.id._name_button);

        //Search bar where text will go to search by ingredient
        searchIngre = findViewById(R.id._ingre_search);

        //Button that when clicked will search for a recipe by ingredient
        ingreButton = findViewById(R.id._ingre_button);

        //Button that when clicked will take you to the favorites page
        favorites = findViewById(R.id._favorites);


        favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent favoriteView = new Intent(MainActivity.this, FavoritesActivity.class);
                startActivity(favoriteView);
            }
        });

        //Button that when pressed will search for a cocktail by name (given input from searchName search bar edittext field)
        nameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create a new task
                RecipeSearchByNameAsyncTask task = new RecipeSearchByNameAsyncTask();

                //add a RecipeListener to the task
                //This is based on the Listener contract you defined in AsyncTask
                task.setListener(new RecipeSearchByNameAsyncTask.RecipeListener() {
                    @Override
                    public void onRecipeSearchCallback(List<RecipeModel> ArrayOfRecipeModel) {
                        //Show the first response on the screen
                        RecipeModel first = ArrayOfRecipeModel.get(0);
                        //When searching a recipe by name we go directly to the recipe by that name
                        Intent recipeView = new Intent(MainActivity.this, RecipeViewActivity.class);
                        startActivity(recipeView);

                    }

                });
                task.execute(searchName.getText().toString());
            }
        });

        ingreButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Create a new task
                RecipeSearchByIngredientAsyncTask task = new RecipeSearchByIngredientAsyncTask();

                //add a RecipeListener to the task
                //This is based on the Listener contract you defined in AsyncTask
                task.setListener(new RecipeSearchByNameAsyncTask.RecipeListener() {
                    @Override
                    public void onRecipeSearchCallback(List<RecipeModel> ArrayOfRecipeModel) {
                        //Show the first response on the screen
                        RecipeModel first = ArrayOfRecipeModel.get(0);

                        Intent searchView = new Intent(MainActivity.this, SearchActivity.class);
                        //When we search by ingredient we go to the search view where we can choose between list of recipes that contain that ingredient
                        startActivity(searchView);
                    }



                });
                task.execute(searchIngre.getText().toString());
            }
        });
    }
}