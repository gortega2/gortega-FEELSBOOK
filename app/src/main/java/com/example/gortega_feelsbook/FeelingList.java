package com.example.gortega_feelsbook;

import android.util.Log;

import java.util.ArrayList;

public class FeelingList {

    private ArrayList<Feeling> feelingList = new ArrayList<Feeling>();

    public void addFeeling(Feeling feels){
        feelingList.add(feels);
        //TODO: CALL THE SORT METHOD TO SORT THE ARRAY BY THE DATE
    }

    public void removeFeeling(Feeling feels){
        feelingList.remove(feels);
    }

    public ArrayList<Feeling> returnlist(){
        return feelingList;
    }

    public void changeList(ArrayList<Feeling> newList) {
        this.feelingList = newList;
    }

}
