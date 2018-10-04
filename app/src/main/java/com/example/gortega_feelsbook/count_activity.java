package com.example.gortega_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class count_activity extends AppCompatActivity {

    int lovecount, joycount, surprisecount, angercount, sadnesscount, fearcount;
    private ArrayList<Feeling> feelingList = null;
    private TextView lovetext, joytext, surprisetext, angertext, sadnesstext, feartext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_activity);
        Intent intent = getIntent();
        parseBack();
        lovetext = (TextView) findViewById(R.id.lovecount);
        joytext = (TextView) findViewById(R.id.joycount);
        surprisetext = (TextView) findViewById(R.id.surprisecount);
        angertext = (TextView) findViewById(R.id.angercount);
        sadnesstext = (TextView) findViewById(R.id.sadnesscount);
        feartext = (TextView) findViewById(R.id.fearcount);
        updateCount(feelingList);
        displayCount();
        System.out.println(feelingList.size());


    }

    private void parseBack() {
        String arrayAsString = getIntent().getExtras().getString("array");
        Gson gson = new Gson();
        Type typeListFeelings = new TypeToken<ArrayList<Feeling>>() {
        }.getType();
        feelingList = gson.fromJson(arrayAsString, typeListFeelings);
    }


    private void updateCount(ArrayList<Feeling> array){
        lovecount = joycount = surprisecount = angercount = sadnesscount = fearcount = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getType().equals("love")) {
                this.lovecount++;
            } else if (array.get(i).getType().equals("joy")) {
                this.joycount++;
            } else if (array.get(i).getType().equals("surprise")) {
                this.surprisecount++;
            } else if (array.get(i).getType().equals("anger")){
                this.angercount++;
            } else if (array.get(i).getType().equals("sadness")){
                this.sadnesscount++;
            } else if (array.get(i).getType().equals( "fear")){
                this.fearcount++;
            }
        }
    }

    private void displayCount(){
        lovetext.setText("Love count: " + this.lovecount);
        joytext.setText("Joy count: " + this.joycount);
        surprisetext.setText("Suprise count: " + this.surprisecount);
        angertext.setText("Anger count: " + this.angercount);
        sadnesstext.setText("Sadness count: " + this.sadnesscount);
        feartext.setText("Fear count: " + this.fearcount);

    }

}
