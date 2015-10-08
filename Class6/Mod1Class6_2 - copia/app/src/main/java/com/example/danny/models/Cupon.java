package com.example.danny.models;

/**
 * Created by DArica on 05/10/2015.
 */
public class Cupon {

    private String title, url;

    public Cupon(String title, String url){
        this.title = title;
        this.url = url;
    }
    public String getTitle() {
        return title;
    }
    public String getUrl() {
        return url;
    }
}
