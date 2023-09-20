package com.mail;


import java.io.*;
import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Date;
import java.util.Scanner;


public class Email_Client {

    public static void main(String[] args) throws Exception {
        // write your code here


        Scanner scanner = new Scanner(System.in);
        CreateRecipient object = new CreateRecipient();
        object.readFile();
        ArrayList<Email> emailList = new ArrayList<>();
        SimpleDateFormat dtf = new SimpleDateFormat("MM/dd");
        Date now = new Date();


        for (Messageable obj : object.birthdayWish) {
            if (obj.getBirthday().contains((String) dtf.format(now))) {
                Email email = new Email(obj.getEmail(), "BithdayWish", obj.sendingMessage());
                JavaMailUtil.SendMail(email);
                emailList.add(email);
            }
        }
        boolean exit = false;
        while (!exit) {
            System.out.println("Enter option type: \n"
                    + "1 - Adding a new recipient\n"
                    + "2 - Sending an email\n"
                    + "3 - Printing out all the recipients who have birthdays\n"
                    + "4 - Printing out details of all the emails sent\n"
                    + "5 - Printing out the number of recipient objects in the application");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // input format - Official:nimal,nimal@gmail.com,ceo
                    System.out.println("Forms:\n"
                            +"Official:Name,MailAddres,designation\nor\n"
                            +"Official_friend:Name,MailAddres,designation,Birthday(YY/MM/DD)\nor\n"
                            +"Personal:Name,Nickname,MailAddres,Birthday(YY/MM/DD)");
                    String format = scanner.next();
                    // Use a single input to get all the details of a recipient
                    // code to add a new recipient
                    // store details in clientList.txt file

                    try {
                        FileWriter writer = new FileWriter("clientList.txt", true);
                        BufferedWriter writer1 = new BufferedWriter(writer);
                        writer1.write(format);
                        writer1.newLine();
                        writer1.close();
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    object.createRecipient(format);
                    // Hint: use methods for reading and writing files
                    break;

                case 2:
                    // input format - email, subject, content
                    System.out.println("input format - email,subject,content");
                    String input = scanner.next();
                    String[] store = input.split(",");
                    // code to send an email
                    Email email = new Email(store[0], store[1], store[2]);
                    JavaMailUtil.SendMail(email);
                    emailList.add(email);
                    break;
                case 3:
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    System.out.println("input format - yyyy/MM/dd (ex: 2018/09/17)");
                    String date1 = scanner.next();

                    // code to print recipients who have birthdays on the given date
                    for (Messageable obj : object.birthdayWish) {
                        if (obj.getBirthday().contains(date1.substring(4))) {
                            System.out.println(obj.getName());
                        } else
                            continue;
                    }
                    break;
                case 4:
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    System.out.println("input format - yyyy/MM/dd (ex: 2018/09/17)");
                    String date2 = scanner.next();
                    // code to print the details of all the emails sent on the input date
                    ArrayList<Email> emaillist = SerializedDeserialized.Deserialized();
                    for (Email obj3 : emaillist) {
                        if (date2.contains(obj3.getCurDate())) {
                            System.out.println("To Address: " + obj3.getToMailAddress() + " \nSubject " + obj3.getSubject() + "\nContent " + obj3.getContent());
                        }
                    }
                    break;
                case 5:
                    // code to print the number of recipient objects in the application
                    System.out.println(Recipient.getCount());
                    break;
                default:
                    exit = true;
            }

        }
        SerializedDeserialized.serialized(emailList);

        // start email client
        // code to create objects for each recipient in clientList.txt
        // use necessary variables, methods and classes


    }
}
