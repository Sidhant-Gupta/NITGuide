package com.example.nit_guide;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class contact_list extends AppCompatActivity {

    private RecyclerView mrecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        mrecyclerView=(RecyclerView) findViewById(R.id.rv_clist);
        String i=getIntent().getStringExtra("select");//which table to select
        System.out.println("trrefhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhbdfghjksdfghhsdf");
        System.out.println(i);
        new firebasedatabasehelper(i).readContacts(new firebasedatabasehelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<db_contact> contacts, List<String> keys) {
                new Recyclerview_contact().setConfig(mrecyclerView,contact_list.this,contacts,keys);
            }

            @Override
              public void DataIsInserted() {


            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }

}
