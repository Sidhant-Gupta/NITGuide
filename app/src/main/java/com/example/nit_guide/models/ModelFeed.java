package com.example.nit_guide.models;

public class ModelFeed {
    int img_logo,img_poster;
    private String title,writeUp;

    public int getImg_logo() {
        return img_logo;
    }

    public void setImg_logo(int img_logo) {
        this.img_logo = img_logo;
    }

    public int getImg_poster() {
        return img_poster;
    }

    public void setImg_poster(int img_poster) {
        this.img_poster = img_poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriteUp() {
        return writeUp;
    }

    public void setWriteUp(String writeUp) {
        this.writeUp = writeUp;
    }
}
