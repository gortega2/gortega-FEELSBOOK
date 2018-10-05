package com.example.gortega_feelsbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String FILENAME = "file.sav";
    private EditText bodyText;
    private String msgText;
    history_activity historyActivity = new history_activity();
    private ArrayList<Feeling> feelingList = new ArrayList<Feeling>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Assigns the buttons and text. Taken from https://www.youtube.com/watch?v=GtxVILjLcw8
        loadFromFile();
        bodyText = (EditText) findViewById(R.id.commentText);
        Button lovebutton = findViewById(R.id.lovebutton);
        Button joybutton = findViewById(R.id.joybutton);
        Button surprisebutton = findViewById(R.id.surprisebutton);
        Button angerbutton = findViewById(R.id.angerbutton);
        Button sadbutton = findViewById(R.id.sadnessbutton);
        Button fearbutton = findViewById(R.id.fearbutton);

        lovebutton.setOnClickListener(this);
        joybutton.setOnClickListener(this);
        surprisebutton.setOnClickListener(this);
        angerbutton.setOnClickListener(this);
        sadbutton.setOnClickListener(this);
        fearbutton.setOnClickListener(this);
    }

    //Updates the array list to be persistent
    @Override
    protected void onResume(){
        super.onResume();
        loadFromFile();
    }



    // Calls different methods depending on what button is pressed
    @Override
    public void onClick(View v) {
        msgText = bodyText.getText().toString();
        if (msgText.length() < 100) {
            switch (v.getId()) {
                case R.id.lovebutton:
                    Toast.makeText(this, "Love button clicked", Toast.LENGTH_SHORT).show();
                    feelingList.add(new Feeling("love", msgText));
                    saveInFile();
                    bodyText.setText("");
                    break;

                case R.id.joybutton:
                    Toast.makeText(this, "Joy button clicked", Toast.LENGTH_SHORT).show();
                    feelingList.add(new Feeling("joy", msgText));
                    saveInFile();
                    bodyText.setText("");
                    break;

                case R.id.surprisebutton:
                    Toast.makeText(this, "Surprise button clicked", Toast.LENGTH_SHORT).show();
                    feelingList.add(new Feeling("surprise", msgText));
                    saveInFile();
                    bodyText.setText("");
                    break;

                case R.id.angerbutton:
                    Toast.makeText(this, "Anger button clicked", Toast.LENGTH_SHORT).show();
                    feelingList.add(new Feeling("anger", msgText));
                    saveInFile();
                    bodyText.setText("");
                    break;

                case R.id.sadnessbutton:
                    Toast.makeText(this, "Sadness button clicked", Toast.LENGTH_SHORT).show();
                    feelingList.add(new Feeling("sadness", msgText));
                    saveInFile();
                    bodyText.setText("");
                    break;

                case R.id.fearbutton:
                    Toast.makeText(this, "Fear button clicked", Toast.LENGTH_SHORT).show();
                    feelingList.add(new Feeling("fear", msgText));
                    saveInFile();
                    bodyText.setText("");
                    break;
            }
        } else {
            Toast.makeText(this, "Message length too long (100 chars)", Toast.LENGTH_SHORT).show();
            bodyText.setText("");
        }
    }


    //Switches to the history activity and sends feelingList as string using gson
    public void viewHistory ( View view){
        //Do something when user taps history button
        Intent intent = new Intent(this, history_activity.class);
        String arrayAsString = new Gson().toJson(feelingList);
        intent.putExtra("array", arrayAsString);
        startActivity(intent);
    }

    //Reads from file using gson and sets feelingList
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

    //Saves to file using gson serialization
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


    //Switches to the count activity and sends feelingList as string using gson
    public void viewCount( View view){
        Intent intent = new Intent(this, count_activity.class);
        String arrayAsString = new Gson().toJson(feelingList);
        intent.putExtra("array", arrayAsString);
        startActivity(intent);
    }

    //TODO: SAVE EMOTIONS TO FILE ALONG WITH DATE AND COMMENT. WRITE TO FILE AND CHECK FOR ERRORS

}
