package com.example.myapplication.network;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TheCocktailDBApi
{
    //Will we need to use this URL?:
    //Search cocktail by name
    //www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita

    //Going to where the api is located via URL
    private static final String baseApiUrl = "www.thecocktaildb.com/api/json/v1/1/filter.php";
    //Test apiKey is listed as 1 on the website
    private static final String apiKey = "1";


    /**
     * Searches the TheCockTail recipe database.
     * @param input the ingredient to search in recipes
     * @return string: json response containing matches
     */


    public static String searchRecipesByIngredient(String input)
    {

        // piece together a valid url, starting with the base URL
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseApiUrl).newBuilder();

        // and adding on a few more parts
        urlBuilder.addQueryParameter("apiKey", apiKey);
        //For TheCockTail database, they use i to denote a search by ingredients
        urlBuilder.addQueryParameter("i", input);

        // until it's ready to assemble
        String url = urlBuilder.build().toString();

        return getResponse(url);
    }

    public static String searchRecipesByName(String input) {

        // piece together a valid url, starting with the base
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseApiUrl).newBuilder();

        // and adding on a few more parts
        urlBuilder.addQueryParameter("apiKey", apiKey);
        urlBuilder.addQueryParameter("s", input); //

        // until it's ready to assemble
        String url = urlBuilder.build().toString();

        return getResponse(url);
    }

    private static String getResponse(String url)
    {
        // form the Request with the url
        Request request = new Request.Builder().url(url).build();

        OkHttpClient client = new OkHttpClient();
        try
        {
            // ask the server for a response
            Response response = client.newCall(request).execute();
            // `response` also contains metadata: success/fail, travel time, etc.
            // only need the body of the result (as a string)
            return response.body().string();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
