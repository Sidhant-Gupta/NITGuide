package com.example.nit_guide;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        final ArrayList<String> allPlaces=new ArrayList<String>();
        allPlaces.add("Library");
        allPlaces.add("CCN(Centre of Computer Networking)");
        allPlaces.add("NIT Market");
        allPlaces.add("Senate Hall");
        allPlaces.add("Administrative Block");
        allPlaces.add("Moxie's Grill Canteen");
        allPlaces.add("Amul Canteen");
        allPlaces.add("Jubilee Hall");
        allPlaces.add("Juice Corner");



        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,allPlaces);
        lview.setAdapter(arrayAdapter);

        lview.setOnItemClickListener (new AdapterView.OnItemClickListener ( ) {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {

//                AlertDialog.Builder first=new AlertDialog.Builder (places.this);
//                first.setTitle ("");
                Intent intent=new Intent (getApplicationContext (),MapsActivity.class);
                intent.putExtra ("name", allPlaces.get (pos));
                startActivity (intent);

            }
        });
    }
}
