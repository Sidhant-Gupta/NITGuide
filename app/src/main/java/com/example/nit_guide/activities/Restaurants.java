package com.example.nit_guide.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.nit_guide.R;
import com.example.nit_guide.adapters.AdapterContacts;
import com.example.nit_guide.models.ModelContacts;

import java.util.ArrayList;

public class Restaurants extends AppCompatActivity {

    private AdapterContacts adapter;
    private RecyclerView recyclerView;
    ArrayList<ModelContacts> restList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_restaurants);

        restList = new ArrayList<> ( );
        restList = dataqueue ( );
        recyclerView = (RecyclerView) findViewById (R.id.rv_contactDep);
        recyclerView.setLayoutManager (new LinearLayoutManager (this));
        adapter = new AdapterContacts (this, restList);
        recyclerView.setAdapter (adapter);
//        recyclerView.setOnClickListener (new AdapterView<AdapterContacts>.OnItemClickListener (){

//        });

    }

    public ArrayList<ModelContacts> dataqueue() {
        ArrayList<ModelContacts> holder = new ArrayList<> ( );
        ModelContacts ob1 = new ModelContacts ( );
        ob1.setHeading ("Computer Department");
        ob1.setSubHeading ("Faculty members of CS Department");
        ob1.setImgName (R.drawable.dep);

        holder.add (ob1);


        ModelContacts ob2 = new ModelContacts ( );
        ob2.setHeading ("Electrical Department");
        ob2.setSubHeading ("Faculty members of EE Department");
        ob2.setImgName (R.drawable.dep);
        holder.add (ob2);


        ModelContacts ob3 = new ModelContacts ( );
        ob3.setHeading ("Mechanical Department");
        ob3.setSubHeading ("Faculty members of ME Department");
        ob3.setImgName (R.drawable.dep);
        holder.add (ob3);

        ModelContacts ob4 = new ModelContacts ( );
        ob4.setHeading ("Civil Department");
        ob4.setSubHeading ("Faculty members of CE Department");
        ob4.setImgName (R.drawable.dep);
        holder.add (ob4);
        return holder;

    }
}