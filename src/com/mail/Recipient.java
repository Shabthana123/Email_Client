package com.mail;


public abstract class Recipient {
    private String name;
    private String email;
    private static int count;

    public Recipient(String name,String email){
        this.name=name;
        this.email=email;
        count++;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static int getCount() {
        return count;
    }
}
