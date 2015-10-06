package com.example.danny.models;

/**
 * Created by DArica on 05/10/2015.
 */
public class Images {
    private int id;
    private String urlImage;
    private String title;
    private String content;
    private String date;

    public Images(int id,String urlImage, String title, String content, String date) {
        this.setId(id);
        this.setUrlImage(urlImage);
        this.setTitle(title);
        this.setContent(content);
        this.setDate(date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
