package com.mail;

import java.io.*;
import java.util.ArrayList;

public class SerializedDeserialized {
    public static void serialized(ArrayList<Email> emails){
        try
        {
            FileOutputStream fos = new FileOutputStream("EmailObject.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(emails);
            oos.flush();
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public static ArrayList<Email> Deserialized() throws FileNotFoundException{
        ArrayList<Email> mailList = new ArrayList<Email>();

        try
        {
            FileInputStream fis = new FileInputStream("EmailObject.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            mailList = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return mailList;
    }
}
