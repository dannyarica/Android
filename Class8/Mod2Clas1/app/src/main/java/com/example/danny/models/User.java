package com.example.danny.models;

/**
 * Created by DArica on 14/10/2015.
 */
public class User {
    private String name;
    private String email;
    private String pwd;
    private Boolean remember;

    public User(){

    }

    public User(String name, String email, String pwd){
        this.name=name;
        this.email=email;
        this.pwd=pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Boolean getRemember() {
        return remember;
    }

    public void setPwd(Boolean remember) {
        this.remember = remember;
    }
}
