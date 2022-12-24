package com.driver;
import java.util.*;
import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    public int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
     List<Mail>Inbox;
     List<Mail>Trash;
     Date latestDate;
     Date oldDate;
     boolean old;

    public Gmail(String emailId, int inboxCapacity) {
           super(emailId);
           this.inboxCapacity=inboxCapacity;
           Inbox=new ArrayList<>();
           Trash=new ArrayList<>();
           old=true;
    }
    public boolean checkDistinct(Mail mail) {
         for(Mail m:Inbox) {
             if (m.date.equals(mail.date) && m.sender.equals(mail.sender) && m.message.equals(mail.message))
                 return false;
         }
         return true;
    }
    public int getIndex(String message){
        for(int i=0;i<Inbox.size();i++){

                if(Inbox.get(i).message.equals(message)){
                    return i;
                }

        }
        return -1;
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        if(inboxCapacity==0) return;
        Mail newMail=new Mail(date,sender,message);
        if(Inbox.size()<inboxCapacity){
            if(checkDistinct(newMail)){
                Inbox.add(newMail);
//                System.out.println(Inbox.get(0).message+" "+Inbox.size());
            }
        }else if(Inbox.size()>=inboxCapacity){
            if(checkDistinct(newMail)){
                Trash.add(Inbox.get(0));
                Inbox.remove(0);
//                System.out.println(Inbox.get(0).message);
                Inbox.add(newMail);
            }

        }


    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        int index=getIndex(message);
       if(getIndex(message)>0){
           Trash.add(Inbox.get(index));
           Inbox.remove(index);
       }

    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(Inbox.size()>0){
            return Inbox.get(Inbox.size()-1).message;
        }
        return null;

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(!Inbox.isEmpty()){
            return Inbox.get(0).message;
        }
        return null;

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count=0;
        for(Mail mail:Inbox){
            if(mail.date.equals(start) || (mail.date.after(start) && mail.date.before(end)) || mail.date.equals(end)){
//                System.out.println(mail.message);
                count++;
            }
        }
        return count;

    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return Inbox.size();

    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return Trash.size();

    }

    public void emptyTrash(){
        // clear all mails in the trash
        Trash.clear();

    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
