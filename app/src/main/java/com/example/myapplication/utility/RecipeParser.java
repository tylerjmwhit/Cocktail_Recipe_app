package com.example.myapplication.utility;

import android.util.Log;

import com.example.myapplication.models.RecipeModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class RecipeParser
{
    // TAG is used in logging, to help trace where output comes from
    private static final String TAG = "RecipeParser";

    /**
     * Returns a list of recipes that match a search term
     * @param json String json representing the server's response
     * @return list of recipes (as RecipeModels)
     */

    //Doing number 4 on Lab 4 assignment HERE instead of "getMatches"
    public static List<RecipeModel> getResults(String json)
    {

        //Getting ready to make an array of recipe models
        List<RecipeModel> modelList = new ArrayList<>();


        try {
            // a JSONArray representing the whole response
            JSONArray response = new JSONArray(json);

            for(int i=0; i < response.length(); i++)
            {
                // todo: loop through the array and deserialize! json -> Java
                //Our java object that captures the the JSON values we want to capture/are parsing for
                RecipeModel model = new RecipeModel();
                JSONObject recipe = response.getJSONObject(i);
                String title = recipe.getString("title");
                int likes = recipe.getInt("likes");

                //We now want to set our RecipeModel object's attributes using our setters
                //model.setTitle(title);
                //model.setLikes(likes);

                //Now we need to add this RecipeModel object into our list/array of RecipeModel objects that we made earlier
                modelList.add(model);


            }



        } catch (JSONException e) {
            Log.e(TAG, "getMatches: error parsing JSON", e);
        }


        return modelList;
    }

    /**
     * Gets total number of matched recipes in a search result.
     * @param json string json representing the server's response
     * @return integer number of total matches
     */
    public static int getTotalMatches(String json)
    {
        JSONArray results;
        int totalMatches = 0;

        try {
            // convert the raw string into a Java JSONObject
            JSONArray response = new JSONArray(json);

            if(response != null && response.length() > 0)
            {
                totalMatches = response.length();
            }

        } catch (JSONException e) {
            Log.e(TAG, "getTotalMatches: error parsing JSON", e);
        }

        return totalMatches;
    }
}

// https://api.spoonacular.com/recipes/findByIngredients?apiKey=d4897ac2dd8e494a8815edc1c5f29538&ingredients=beef

//language=JSON
/*
// beginning of JSON object (response from server). note the square opening bracket is a token signifying
   the start of an array. Each attribute is bounded by quotes (e.g. "id") with a colon separating the
   attribute name from the value.
[
  {
    "id": 633338,
    "title": "Bacon Wrapped Filet Mignon",
    "image": "https://spoonacular.com/recipeImages/633338-312x231.jpg",
    "imageType": "jpg",
    "usedIngredientCount": 1,
    "missedIngredientCount": 2,
    "missedIngredients": [
      {
        "id": 10123,
        "amount": 4.0,
        "unit": "slices",
        "unitLong": "slices",
        "unitShort": "slice",
        "aisle": "Meat",
        "name": "bacon",
        "original": "4 slices of smoked bacon",
        "originalString": "4 slices of smoked bacon",
        "originalName": "smoked bacon",
        "metaInformation": [
          "smoked"
        ],
        "meta": [
          "smoked"
        ],
        "extendedName": "smoked bacon",
        "image": "https://spoonacular.com/cdn/ingredients_100x100/raw-bacon.png"
      },
      {
        "id": 11215,
        "amount": 2.0,
        "unit": "large cloves",
        "unitLong": "large cloves",
        "unitShort": "large cloves",
        "aisle": "Produce",
        "name": "garlic",
        "original": "2 large cloves garlic",
        "originalString": "2 large cloves garlic",
        "originalName": "garlic",
        "metaInformation": [],
        "meta": [],
        "image": "https://spoonacular.com/cdn/ingredients_100x100/garlic.png"
      }
    ],
    "usedIngredients": [
      {
        "id": 10023583,
        "amount": 4.0,
        "unit": "inches",
        "unitLong": "inches",
        "unitShort": "inches",
        "aisle": "Meat",
        "name": "beef tenderloin steaks",
        "original": "4 inches beef tenderloin steaks, about 2 thick",
        "originalString": "4 inches beef tenderloin steaks, about 2 thick",
        "originalName": "beef tenderloin steaks, about 2 thick",
        "metaInformation": [
          "thick"
        ],
        "meta": [
          "thick"
        ],
        "image": "https://spoonacular.com/cdn/ingredients_100x100/beef-tenderloin.jpg"
      }
    ],
    "unusedIngredients": [],
    "likes": 61
  }
]

// end of response object
 */

