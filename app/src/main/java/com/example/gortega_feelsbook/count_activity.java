package com.example.gortega_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class count_activity extends AppCompatActivity {

    int lovecount = 0;
    int joycount = 0;
    int surprisecount = 0;
    int angercount = 0;
    int sadnesscount = 0;
    int fearcount = 0;

    private ArrayList<Feeling> feelingList = null;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_activity);
        Intent intent = getIntent();
        parseBack();
        ArrayAdapter<Feeling> itemsAdapter = new ArrayAdapter<Feeling>(this, android.R.layout.simple_list_item_1, feelingList);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(itemsAdapter);
        System.out.println(feelingList.size());


    }

    private void parseBack() {
        String arrayAsString = getIntent().getExtras().getString("array");
        Gson gson = new Gson();
        Type typeListFeelings = new TypeToken<ArrayList<Feeling>>() {
        }.getType();
        feelingList = gson.fromJson(arrayAsString, typeListFeelings);
    }





}
