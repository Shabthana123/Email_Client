package com.mail;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import java.util.Date;

public class Email implements Serializable {
    private static final long serialVersionUID = -6785413924474493813L;
    private  String toMailAddress;
    private  String subject;
    private  String content;
    private String curDate;
    transient SimpleDateFormat dtf = new SimpleDateFormat("MM/dd");
    transient Date now = new Date();

    public Email(String toMailAddress, String subject, String content) {
        this.toMailAddress = toMailAddress;
        this.subject = subject;
        this.content = content;
        this.curDate=  dtf.format(now);

    }

    public  String getToMailAddress() {
        return toMailAddress;
    }

    public  String getSubject() {
        return subject;
    }

    public  String getContent() {
        return content;
    }

    public String getCurDate() {
        return curDate;
    }
}
