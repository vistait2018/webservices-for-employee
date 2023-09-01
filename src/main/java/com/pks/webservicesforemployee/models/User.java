package com.pks.webservicesforemployee.models;

public class User {
    private String name;
    private String sex;
    private String emailId;

    public User(){

    }
    public User(String name, String sex, String emailId) {
        this.name = name;
        this.sex = sex;
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
