package com.example.gortega_feelsbook;

public class MessageTooLong extends Exception {

    MessageTooLong() {super("The message is too long. Try again with fewer characters.");}
}
