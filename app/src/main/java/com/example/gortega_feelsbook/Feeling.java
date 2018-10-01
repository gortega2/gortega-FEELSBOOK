package com.example.gortega_feelsbook;

import java.util.Date;

public class Feeling {

    private Date curdate;
    private String message;
    private int MAX_CHARS = 100;
    private int count = 0;


    public void Entry(){
        this.curdate = new Date();
        this.message = "";

    }

    public void Entry(String message){
        this.curdate = new Date();
        this.message = message;

    }
    public String getMesssage(){
        return this.message;
    }

    public Date getDate(){
        return this.curdate;
    }

    public void setMessage (String message)throws MessageTooLong {
        if (message.length() > MAX_CHARS) {
            this.message = message;
        } else {
            throw new MessageTooLong();
        }
    }
}
