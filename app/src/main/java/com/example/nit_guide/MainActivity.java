package com.example.nit_guide;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

//import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

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

        navigationView=(NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_acad:
                        break;
                    case R.id.nav_contact:
                        Intent con=new Intent(getApplicationContext(),contact.class);
                        startActivity(con);
                        break;
                    case R.id.nav_home:
                        Intent h=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(h);
                        break;
                    case R.id.nav_notifs:
                        break;

                }
                return false;
            }
        });

        prevyear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent prev=new Intent(getApplicationContext(),branch_paper.class);

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
