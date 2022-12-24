package com.driver;
import java.util.*;
public class Mail {
    //Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    public Date date;
    public String sender;
    public String message;

    public Mail(Date date, String sender, String message) {
        this.date = date;
        this.sender = sender;
        this.message = message;
    }
}
