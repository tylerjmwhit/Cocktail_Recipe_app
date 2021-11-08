package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{
    private EditText searchName;
    private Button nameButton;
    private EditText searchIngre;
    private Button ingreButton;
    private Button favorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchName = findViewById(R.id._name_search);
        nameButton = findViewById(R.id._name_button);
        searchIngre = findViewById(R.id._ingre_search);
        ingreButton = findViewById(R.id._ingre_button);
        favorites = findViewById(R.id._favorites);
        
    }
}