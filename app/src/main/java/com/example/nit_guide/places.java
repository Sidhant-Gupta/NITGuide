package com.example.nit_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class places extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);



        ListView lview=(ListView) findViewById(R.id.lview);
        ArrayList<String> allPlaces=new ArrayList<String>();
        allPlaces.add("Library");
        allPlaces.add("CCN");
        allPlaces.add("NIT market");
        allPlaces.add("Senate hall");
        allPlaces.add("Administrative Block");

        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,allPlaces);
        lview.setAdapter(arrayAdapter);

    }
}
