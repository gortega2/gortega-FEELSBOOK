package com.example.gortega_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static String FILENAME = "file.sav";
    private EditText bodyText;
    private ListView oldFeelings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewHistory ( View view){
        //Do something when user taps history button
        Intent intent = new Intent(this, history_activity.class);
        startActivity(intent);
    }

    public void viewCount( View view){
        //Do something when user taps count button
        Intent intent = new Intent(this, count_activity.class);
        startActivity(intent);
    }
}
