package com.example.gortega_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class editFeelingActivity extends AppCompatActivity implements View.OnClickListener{

    private static String FILENAME = "file.sav";
    private TextView editDate, editComment;
    private ArrayList<Feeling> feelingList = null;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Assigns the buttons and text
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_feeling);
        editDate = (EditText) findViewById(R.id.edit_date);
        editComment = (EditText) findViewById(R.id.edit_comment);
        Button savebutton = (Button) findViewById(R.id.save_button);
        Button deletebutton = (Button) findViewById(R.id.delete_button);

        savebutton.setOnClickListener(this);
        deletebutton.setOnClickListener(this);

        Intent intent = getIntent();
        parseBack();
        editDate.setText(feelingList.get(this.position).getDate());
        editComment.setText(feelingList.get(this.position).getMessage());
    }

    @Override
    //Either edits or deletes the Feeling object depending on what the user presses
    public void onClick(View v) {
            switch (v.getId()) {
                case R.id.delete_button:
                    Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
                    deleteFeeling();
                    saveInFile();
                    finish();
                    break;
                case R.id.save_button:
                    if (editComment.getText().toString().length() < 100) {
                        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                        feelingList.get(this.position).editMessage(editComment.getText().toString());
                        feelingList.get(this.position).editDate(editDate.getText().toString());
                        saveInFile();
                        finish();
                        break;
                    } else {
                        Toast.makeText(this, "Message length too long (100 chars)", Toast.LENGTH_SHORT).show();
                    }
            }
        }

    //Removes the feeling from the array list
    public void deleteFeeling(){
        feelingList.remove(this.position);
        this.finish();
    }

    //See explanation in MainActivity
    private void parseBack() {
        this.position = getIntent().getExtras().getInt("position");
        String arrayAsString = getIntent().getExtras().getString("array");
        Gson gson = new Gson();
        Type typeListFeelings = new TypeToken<ArrayList<Feeling>>() {
        }.getType();
        feelingList = gson.fromJson(arrayAsString, typeListFeelings);

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
}
