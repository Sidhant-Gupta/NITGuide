package com.example.nit_guide.models;

import com.google.firebase.database.Exclude;

public class ModelTimetable {
    private String time,subject,room;
    private int img;

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    public String getSubject() { return subject; }

    public void setSubject(String subject) { this.subject = subject; }

    public String getRoom() { return room; }

    public void setRoom(String room) { this.room = room; }

    public int getImg() { return img; }

    public void setImg(int img) { this.img = img; }
}
