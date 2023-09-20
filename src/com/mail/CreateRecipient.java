package com.mail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateRecipient {
    ArrayList<String> mailDetails = new ArrayList<String>();
    ArrayList<Messageable> birthdayWish = new ArrayList<Messageable>();

    public ArrayList<Messageable> getBirthdayWish() {
        return birthdayWish;
    }

    public void readFile(){
        try {
            File file = new File("clientList.txt");
            FileReader reader = new FileReader(file);
            BufferedReader reader1 = new BufferedReader(reader);
            String line = null;
            Recipient recipient;
            while ((line = reader1.readLine()) != null) {
                mailDetails.add(line);
                recipient=createRecipient(line);
                if(recipient instanceof Messageable){
                    birthdayWish.add((Messageable) recipient);
                }
            }
            reader.close();
            reader1.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public Recipient createRecipient(String data){
        String[] category= data.split(":");
        String[] details= category[1].split(",");
        switch (category[0]){
            case "Personal":
                return new Personal(details[0],details[1],details[2],details[3]);
            case "Official":
                return new Official(details[0],details[1],details[2]);
            case "Official_friend":
                return new Official_friend(details[0],details[1],details[2],details[3]);
            default:
                return null;
        }
    }

}
