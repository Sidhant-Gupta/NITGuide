package com.example.nit_guide.models;

public class modelClass {

    private int imageResource;
    private String tv_rec;

    public modelClass(int imageResource, String tv_rec) {
        this.imageResource = imageResource;
        this.tv_rec = tv_rec;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTv_rec() {
        return tv_rec;
    }
}


