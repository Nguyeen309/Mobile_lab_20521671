package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listview;

    GridView gridview;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.ListView);
        listview.setNestedScrollingEnabled(false);
        ListAdapter list = new ListAdapter(getApplicationContext());
        listview.setAdapter(list);

        gridview = findViewById(R.id.GridView);
        gridview.setNestedScrollingEnabled(false);
        GridAdapter customGridAdapter = new GridAdapter(getApplicationContext());
        gridview.setAdapter(customGridAdapter);

    }
}