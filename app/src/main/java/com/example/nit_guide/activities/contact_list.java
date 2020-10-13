package com.example.nit_guide.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.nit_guide.R;
import com.example.nit_guide.adapters.Recyclerview_contact;
import com.example.nit_guide.firebase.FirebaseDbHelper;
import com.example.nit_guide.firebasedatabasehelper;
import com.example.nit_guide.models.FBModelContacts;

import java.util.ArrayList;
import java.util.List;

public class contact_list extends AppCompatActivity {

    private RecyclerView mrecyclerView;
    Toolbar toolbar;
    TextView heading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        setUpToolbar();

        mrecyclerView=(RecyclerView) findViewById(R.id.rv_clist);
        heading=(TextView)findViewById(R.id.tv_specificContact);

        ArrayList<String> intentMsg=new ArrayList<>();
        intentMsg=getIntent().getStringArrayListExtra("select"); //which table to select
        System.out.println("trrefhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhbdfghjksdfghhsdf");
        System.out.println(intentMsg);

        heading.setText(intentMsg.get(0)+" "+intentMsg.get(1));
        new FirebaseDbHelper(intentMsg.get(0)).readContacts(new FirebaseDbHelper.DataStatus() {


            @Override
            public void DataIsLoaded(List<FBModelContacts> contacts, List<String> keys) {
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
    private void setUpToolbar(){
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Phone Book");
        setSupportActionBar(toolbar);
    }
}
