package com.example.nit_guide.models;

public class FBModelContacts {
    private String name;
    private String designation;
    private String cont;
    private String email;

    public FBModelContacts() {
    }

    public FBModelContacts(String name, String designation, String cont, String email) {
        this.name = name;
        this.designation = designation;
        this.cont = cont;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
