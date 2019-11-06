package com.example.nit_guide;

public class db_contact {
    private String name;
    private String Designation;
    private String cont;
    private String email;

    public db_contact() {
    }

    public db_contact(String name, String designation, String cont, String email) {
        this.name = name;
        Designation = designation;
        this.cont = cont;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public String getDesignation() {
        return Designation;
    }

    public String getCont() {
        return cont;
    }

    public String getEmail() {
        return email;
    }
}
