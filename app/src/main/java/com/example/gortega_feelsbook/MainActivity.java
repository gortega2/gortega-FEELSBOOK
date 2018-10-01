package com.example.gortega_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String FILENAME = "file.sav";
    private EditText bodyText;
    private ListView oldFeelings;
    private String msgText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigns the buttons and text. Taken from https://www.youtube.com/watch?v=GtxVILjLcw8
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

    // Calls different methods depending on what button is pressed
    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.lovebutton:
                Toast.makeText(this, "Love button clicked", Toast.LENGTH_SHORT).show();
                msgText = bodyText.getText().toString();

                break;

            case R.id.joybutton:
                Toast.makeText(this, "Joy button clicked", Toast.LENGTH_SHORT).show();
                msgText = bodyText.getText().toString();
                break;

            case R.id.surprisebutton:
                Toast.makeText(this, "Surprise button clicked", Toast.LENGTH_SHORT).show();
                msgText = bodyText.getText().toString();
                break;

            case R.id.angerbutton:
                Toast.makeText(this, "Anger button clicked", Toast.LENGTH_SHORT).show();
                msgText = bodyText.getText().toString();
                break;

            case R.id.sadnessbutton:
                Toast.makeText(this, "Sadness button clicked", Toast.LENGTH_SHORT).show();
                msgText = bodyText.getText().toString();
                break;

            case R.id.fearbutton:
                Toast.makeText(this, "Fear button clicked", Toast.LENGTH_SHORT).show();
                msgText = bodyText.getText().toString();
                break;
            }
        }

    //Switches to the history activity
    public void viewHistory ( View view){
        //Do something when user taps history button
        Intent intent = new Intent(this, history_activity.class);
        startActivity(intent);
    }

    //Switches to the count activity
    public void viewCount( View view){
        //Do something when user taps count button
        Intent intent = new Intent(this, count_activity.class);
        startActivity(intent);
    }

    //TODO: SAVE EMOTIONS TO FILE ALONG WITH DATE AND COMMENT. WRITE TO FILE AND CHECK FOR ERRORS

}
