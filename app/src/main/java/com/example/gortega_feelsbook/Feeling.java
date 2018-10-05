package com.example.gortega_feelsbook;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Feeling {
    @SerializedName("date")
    private String curdate;
    @SerializedName("text")
    private String message;
    @SerializedName("maxchars")
    private int MAX_CHARS = 100;
    @SerializedName("type")
    private String type;

    //Constructors for the feeling object
    public Feeling(String type){
        this.type = type;
        this.curdate = convertDate(new Date(System.currentTimeMillis()));
        this.message = "";

    }

    public Feeling(String type, String message){
        this.type = type;
        this.curdate = convertDate(new Date(System.currentTimeMillis()));
        this.message = message;
    }


    public void editMessage(String message){
        this.message = message;
    }

    public void editDate(String date){
        this.curdate = date;
    }

    //Accessors for the feeling object
    public String getMessage(){
        return this.message;
    }

    public String getDate(){
        return this.curdate;
    }

    public String getType(){
        return this.type;
    }

    //Used by array adapter
    public String toString(){
        return ("Emotion: " + getType() + " | " + getDate() + " | " + getMessage());
    }

    //Taken from https://mincong-h.github.io/2017/02/16/convert-date-to-string-in-java/
    //Converts the current date to the ISO 8601
    public String convertDate(Date date){
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("yyyy-MM-dd 'T1' HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
       return sdf.format(date);

    }
}
