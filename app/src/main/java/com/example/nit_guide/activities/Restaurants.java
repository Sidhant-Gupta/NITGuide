package com.example.nit_guide.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.example.nit_guide.R;
import com.example.nit_guide.adapters.AdapterContacts;
import com.example.nit_guide.models.ModelContacts;

import java.util.ArrayList;

public class Restaurants extends AppCompatActivity implements AdapterContacts.onNoteListener {

    private AdapterContacts adapter;
    private RecyclerView recyclerView;
    ArrayList<ModelContacts> restList;

    private static final String TAG = "Restaurants";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_restaurants);

        restList = new ArrayList<> ( );
        restList = dataqueue ( );
        recyclerView = (RecyclerView) findViewById (R.id.rv_contactDep);
        recyclerView.setLayoutManager (new LinearLayoutManager (this));
        adapter = new AdapterContacts (this, restList, this);
        recyclerView.setAdapter (adapter);
//        recyclerView.setOnClickListener (new AdapterView<AdapterContacts>.OnItemClickListener (){

//        });

    }

    public ArrayList<ModelContacts> dataqueue() {
        ArrayList<ModelContacts> holder = new ArrayList<> ( );
        ModelContacts ob1 = new ModelContacts ( );
        ob1.setHeading ("Barcelo' Grill");
        ob1.setSubHeading ("Quality non-veg, "+"mandatory picture spot" +
                "\nRating: 4");
        ob1.setImgName (R.drawable.dep);

        holder.add (ob1);


        ModelContacts ob2 = new ModelContacts ( );
        ob2.setHeading ("Pizza Hut");
        ob2.setSubHeading ("Affordable, " + "Nice ambiance"+
                "\nRating: 4");
        ob2.setImgName (R.drawable.dep);
        holder.add (ob2);


        ModelContacts ob3 = new ModelContacts ( );
        ob3.setHeading ("The Vintage Cafe");
        ob3.setSubHeading ("Affordable, " + "Nice ambiance"+
                "\nRating: 4");
        ob3.setImgName (R.drawable.dep);
        holder.add (ob3);

        ModelContacts ob4 = new ModelContacts ( );
        ob4.setHeading ("C Seven Hotel");
        ob4.setSubHeading ("Affordable, " + "Nice ambiance"+
                "\nRating: 4");
        ob4.setImgName (R.drawable.dep);
        holder.add (ob4);

        ModelContacts ob5 = new ModelContacts ( );
        ob5.setHeading ("The Meridien");
        ob5.setSubHeading ("Affordable, " + "Nice ambiance"+
                "\nRating: 4");
        ob5.setImgName (R.drawable.dep);
        holder.add (ob5);

        ModelContacts ob6 = new ModelContacts ( );
        ob6.setHeading ("Mezban Hotel and Restaurant");
        ob6.setSubHeading ("Affordable, " + "Nice ambiance"+
                "\nRating: 4");
        ob6.setImgName (R.drawable.dep);
        holder.add (ob6);
        return holder;


    }

    @Override
    public void onNoteClick(int position) {
        Log.d (TAG, "onNoteClick: Clicked");

        Toast.makeText (this, restList.get (position).getHeading (), Toast.LENGTH_SHORT).show ( );
//        System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrr");
//        System.out.println (restList.get (position).getHeading ());
        Intent t =  new Intent(this, gotoLocation.class);
        t.putExtra("obj", restList.get (position).getHeading ());
        startActivity (t);


    }
}