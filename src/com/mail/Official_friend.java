package com.mail;

public class Official_friend extends Official implements Messageable{
    private String birthday;
    public Official_friend(String name, String email, String designation, String birthday) {
        super(name, email, designation);
        this.birthday=birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public String sendingMessage() {
        return " Wish you a Happy Birthday.\nShabthana";
    }
}
