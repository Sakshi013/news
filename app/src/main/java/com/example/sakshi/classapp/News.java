package com.example.sakshi.classapp;

public class News {

    String title,description,imgURL;

    public News(String title, String description, String imgURL) {
        this.title = title;
        this.description = description;
        this.imgURL = imgURL;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
