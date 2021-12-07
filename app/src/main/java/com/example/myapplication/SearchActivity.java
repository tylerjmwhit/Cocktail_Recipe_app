package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myapplication.models.RecipeModel;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


//todo recyler view for this page
public class SearchActivity extends AppCompatActivity {
    public static final String INGRE_KEY = "INGRE_KEY";

    private ImageButton rButton1;
    private ImageButton rButton2;
    private ImageButton rButton3;

    private TextView rtext1;
    private TextView rtext2;
    private TextView rtext3;
    private TextView searchBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent newIent = getIntent();
        List<RecipeModel> myModels  = newIent.getParcelableArrayListExtra(SearchActivity.INGRE_KEY);

        searchBar = findViewById(R.id._ingre_search_searchPage);
        searchBar.setText(newIent.getStringExtra("SEARCH PARA"));

        rButton1 = findViewById(R.id._recipe_button_1);
        rButton1.setImageBitmap(getBitmapFromURL(myModels.get(0).getThumbNail()));
        rtext1 = findViewById(R.id._recipe_button_text_1);
        rtext1.setText(myModels.get(0).getRecipeName());

        rButton2 = findViewById(R.id._recipe_button_2);
        rButton2.setImageBitmap(getBitmapFromURL(myModels.get(1).getThumbNail()));
        rtext2 = findViewById(R.id._recipe_button_text_2);
        rtext2.setText(myModels.get(1).getRecipeName());


        rButton3 = findViewById(R.id._recipe_button_3);
        rButton3.setImageBitmap(getBitmapFromURL(myModels.get(2).getThumbNail()));
        rtext3 = findViewById(R.id._recipe_button_text_3);
        rtext3.setText(myModels.get(2).getRecipeName());


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