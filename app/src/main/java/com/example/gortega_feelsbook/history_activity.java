package com.example.gortega_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class history_activity extends AppCompatActivity{

    private List<Feeling> feelingList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_activity);
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
    //Get the intent
    Intent intent = getIntent();
}
