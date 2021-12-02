package com.example.myapplication.network;

import android.os.AsyncTask;
import android.util.Log;

import com.example.myapplication.models.RecipeModel;
import com.example.myapplication.utility.RecipeParser;
import com.example.myapplication.network.TheCocktailDBApi;


import java.util.List;

public class RecipeSearchByIngredientAsyncTask extends AsyncTask<String, Void, List<RecipeModel>>
{
// AsyncTask is a templated (generic) class: AsyncTask<PARAMS, PROGRESS, RESULT>

// PARAMS is the datatype that we pass to execute()
//      a String representing an ingredient to search for recipes that use it
//      (from user input in MainActivity)
// PROGRESS is the datatype we use to report updates
//      not used in this lab -> Void (null)
// RESULT is the datatype that we send back on completion of this task
//      a List of RecipeModel (List<RecipeModel>) that represents all the results for the ingredient


    // instance of a RecipeListener (concrete implementation)
    private RecipeSearchByNameAsyncTask.RecipeListener listener;

    // setter
    public void setListener(RecipeSearchByNameAsyncTask.RecipeListener listener) {
        this.listener = listener;
    }



    @Override
    protected List<RecipeModel> doInBackground(String... params)
    {
        // runs on a background thread, not blocking main

        String searchTerm = params[0];  // what we're searching for
        Log.d("SearchAsyncTask", "doInBackground: " + searchTerm);

        // get the json response from RecipePuppy's Recipe API
        String responseJson = TheCocktailDBApi.searchRecipesByIngredient(searchTerm);
        // can't go further until the search comes back with results


        // success? :)
        if (responseJson != null)
        {
            return RecipeParser.getResults(responseJson);

        }
        // no success :(
        return null;
    }

    @Override
    protected void onPostExecute(List<RecipeModel> recipeModels)
    {
        // happens after doInBackground, and runs on main thread
        super.onPostExecute(recipeModels);
        Log.d("SearchAsyncTask", "onPostExecute: " + recipeModels);

        //Call interface below and pass recipeModels to it
        listener.onRecipeSearchCallback(recipeModels);
    }


    public interface RecipeListener
    {
        //Sending RecipeModel object back to the listener
        void onRecipeSearchCallback (List<RecipeModel> ArrayOfRecipeModel);

    }


}




