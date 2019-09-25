package com.example.nit_guide;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

//import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView places=(ImageView) findViewById(R.id.places);
        ImageView website=(ImageView) findViewById(R.id.website);
        ImageView cmap=(ImageView) findViewById(R.id.cmap);
        ImageView cdetails=(ImageView) findViewById(R.id.cdetails);
        ImageView prevyear=(ImageView) findViewById(R.id.prevyear);

        setUpToolbar();

        prevyear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent prev=new Intent(getApplicationContext(),branches.class);
                startActivity(prev);
            }
        });

        places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent=new Intent(getApplicationContext(),places.class);
                startActivity(startIntent);
            }
        });

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("http://www.nitkkr.ac.in/"));
                startActivity(myWebLink);
            }
        });

        cmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camp=new Intent(getApplicationContext(),campus.class);
                startActivity(camp);
            }
        });

        cdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sIntent=new Intent(getApplicationContext(),contact.class);
                startActivity(sIntent);
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setUpToolbar(){
        drawerLayout=(DrawerLayout) findViewById(R.id.drawerlayout);
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

}
