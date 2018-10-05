package com.example.gortega_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class history_activity extends AppCompatActivity {
    private static String FILENAME = "file.sav";
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(history_activity.this, "Edit/Delete comment" , Toast.LENGTH_SHORT).show();
                editActivity(view, position);
            }
        });


    }

    //Updates the array list to be persistent
    protected void onResume(){
        super.onResume();
        loadFromFile();
        ArrayAdapter<Feeling> itemsAdapter = new ArrayAdapter<Feeling>(this, android.R.layout.simple_list_item_1, feelingList);
        listView.setAdapter(itemsAdapter);
        //itemsAdapter.notifyDataSetChanged();
    }


    //Taken from https://stackoverflow.com/questions/31613053/pass-array-of-custom-objects-to-another-activity-in-android/31613852#31613852
    //Retrives the array string from Mainactivity and converts it back to the Arraylist using gson
    private void parseBack() {
        String arrayAsString = getIntent().getExtras().getString("array");
        Gson gson = new Gson();
        Type typeListFeelings = new TypeToken<ArrayList<Feeling>>() {
        }.getType();
        feelingList = gson.fromJson(arrayAsString, typeListFeelings);
    }

    //See explanation in MainActivity
    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            Gson gson = new Gson();
            Type typeListFeelings = new TypeToken<ArrayList<Feeling>>() {
            }.getType();
            feelingList = gson.fromJson(reader, typeListFeelings);



        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //See explanation in MainActivity
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, 0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter writer = new BufferedWriter(osw);
            Gson gson = new Gson();
            String json = gson.toJson(feelingList);
            writer.write(json);
            writer.flush();
            writer.close();
            osw.close();
            fos.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Launches the edit activity and sends the array list and position
    public void editActivity(View view, int position){
        Intent intent = new Intent(this, editFeelingActivity.class);
        String arrayAsString = new Gson().toJson(feelingList);
        intent.putExtra("array", arrayAsString);
        intent.putExtra("position", position);
        startActivity(intent);

    }


}


