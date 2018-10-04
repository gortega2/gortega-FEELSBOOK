package com.example.gortega_feelsbook;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Feeling {
    @SerializedName("date")
    private Date curdate;
    @SerializedName("text")
    private String message;
    @SerializedName("maxchars")
    private int MAX_CHARS = 100;
    @SerializedName("type")
    private String type;


    public Feeling(String type){
        this.type = type;
        this.curdate = new Date();
        this.message = "";

    }

    public void editMessage(String message){
        this.message = "message";
    }

    public Feeling(String type, String message){
        this.type = type;
        this.curdate = new Date();
        this.message = message;

    }
    public String getMessage(){
        return this.message;
    }

    public Date getDate(){
        return this.curdate;
    }

    public String getType(){
        return this.type;
    }
    //Prevents the user from entering a message that is too long
    public void setMessage (String message)throws MessageTooLong {
        if (message.length() > MAX_CHARS) {
            this.message = message;
        } else {
            throw new MessageTooLong();
        }
    }
}
