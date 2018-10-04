package com.example.gortega_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class history_activity extends AppCompatActivity {

    private ArrayList<Feeling> feelingList = null;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_activity);
        //Get the intent
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

        /*
        private void buildRecyclerView(){
            recyclerView = (RecyclerView) findViewById(R.id.recycler_View);
            recyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(this);
            adapter =
        }
        public void addFeeling(Feeling feels){
            feelingList.add(feels);
            Log.d("ADDFEELINGMETHOD:","New " + feels.getType() + " feeling added");
            //TODO: CALL THE SORT METHOD TO SORT THE ARRAY BY THE DATE
        }

        public void removeFeeling(Feeling feels){
            feelingList.remove(feels);
        }

        public List<Feeling> returnlist(){
            return feelingList;
        }

        public void changeList(ArrayList<Feeling> newList) {
            this.feelingList = newList;
        }
        */

