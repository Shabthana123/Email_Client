package com.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaMailUtil{
    public static void SendMail(Email email) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();


        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties


        // Setup mail server
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "sj366592@gmail.com";
        String password = "brscyahkdbbzgniq";
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(myAccountEmail, password);

            }

        });

        // Used to debug SMTP issues
        //session.setDebug(true);



        Message message = prepareMessage(session,myAccountEmail,email);
        Transport.send(message);
        System.out.println("Message Send Successfully");


    }

    private static Message prepareMessage(Session session, String myAccountEmail, Email email) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(email.getToMailAddress()) );
            message.setSubject(email.getSubject());
            message.setText(email.getContent());
            return message;
        }
        catch (Exception ex){
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE,null,ex);
        }

        return null;
    }
}
