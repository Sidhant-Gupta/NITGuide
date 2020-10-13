package com.example.nit_guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.nit_guide.activities.gotoLocation;
import com.example.nit_guide.adapters.AdapterContacts;
import com.example.nit_guide.models.ModelContacts;

import java.util.ArrayList;

public class fun_spots extends AppCompatActivity implements AdapterContacts.onNoteListener {

    private AdapterContacts adapter;
    private RecyclerView recyclerView;
    ArrayList<ModelContacts> restList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_fun_spots);

            restList = new ArrayList<> ( );
            restList = dataqueue ( );
            recyclerView = (RecyclerView) findViewById (R.id.rv_contactDep);
            recyclerView.setLayoutManager (new LinearLayoutManager (this));
            adapter = new AdapterContacts (this, restList, this,"fun_spots");
            recyclerView.setAdapter (adapter);

        }

        public ArrayList<ModelContacts> dataqueue() {
            ArrayList<ModelContacts> holder = new ArrayList<> ( );
            ModelContacts ob1 = new ModelContacts ( );
            ob1.setHeading ("Food Foundry");
            ob1.setSubHeading ("Rating: ");
            ob1.setImgName (R.drawable.dep);
            holder.add (ob1);

            ModelContacts ob2 = new ModelContacts ( );
            ob2.setHeading ("Kalu Food Corner");
            ob2.setSubHeading ("Rating: ");
            ob2.setImgName (R.drawable.dep);
            holder.add (ob2);

            ModelContacts ob3 = new ModelContacts ( );
            ob3.setHeading ("Aman Food Corner");
            ob3.setSubHeading ("Faculty members of ME Department");
            ob3.setImgName (R.drawable.dep);
            holder.add (ob3);

            ModelContacts ob4 = new ModelContacts ( );
            ob4.setHeading ("NITIAN Khokha");
            ob4.setSubHeading ("Faculty members of CE Department");
            ob4.setImgName (R.drawable.dep);
            holder.add (ob4);


            ModelContacts ob5 = new ModelContacts ( );
            ob5.setHeading ("Suraj Dhaba");
            ob5.setSubHeading ("Affordable, " + "Nice ambiance"+
                    "\nRating: 4");
            ob5.setImgName (R.drawable.dep);
            holder.add (ob5);

            ModelContacts ob6 = new ModelContacts ( );
            ob6.setHeading ("Amigos");
            ob6.setSubHeading ("Affordable, " + "Nice ambiance"+
                    "\nRating: 4");
            ob6.setImgName (R.drawable.dep);
            holder.add (ob6);



            ModelContacts ob7 = new ModelContacts ( );
            ob7.setHeading ("Bikaner Sweet Shop");
            ob7.setSubHeading ("Affordable, " + "Nice ambiance"+
                    "\nRating: 4");
            ob7.setImgName (R.drawable.dep);
            holder.add (ob7);
            return holder;
        }

        @Override
        public void onNoteClick(int position) {

            Intent t =  new Intent(this, gotoLocation.class);
            t.putExtra("obj", restList.get (position).getHeading ());
            startActivity (t);
            System.out.print (position+": yaaay");
        }
    }