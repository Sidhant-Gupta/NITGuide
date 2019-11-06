package com.example.nit_guide;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

//import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;



    // Write a message to the database
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference myRef = database.getReference("message");


//    myRef.child()

//    myRef.setValue("Hello, World!");
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        ImageView places=(ImageView) findViewById(R.id.places);
        ImageView website=(ImageView) findViewById(R.id.website);
        ImageView cmap=(ImageView) findViewById(R.id.cmap);
        ImageView cdetails=(ImageView) findViewById(R.id.cdetails);
        ImageView prevyear=(ImageView) findViewById(R.id.prevyear);
        ImageView timetable=(ImageView) findViewById (R.id.timetable);

        setUpToolbar();
        drawerLayout = findViewById (R.id.drawerlayout);
        NavigationView navigationView=findViewById (R.id.navigationView);
        navigationView.setNavigationItemSelectedListener (this);
        TextView username=(TextView) findViewById (R.id.username);
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        System.out.print (user.getDisplayName ());
        //username.setText(user.getDisplayName ());
        TextView usermail=(TextView) findViewById (R.id.usermail);
        Log.d ("user.getEmail()","yaay");
        System.out.println(user.getEmail());
        System.out.println (" rrrrrrrrrrrrrrrr " + user.getDisplayName ());
        //usermail.setText(user.getEmail ());
        prevyear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent prev=new Intent(getApplicationContext(),branch_paper.class);
                startActivity(prev);
            }
        });

        timetable.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent time=new Intent(getApplicationContext (),timetable.class);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId ( )){
            case R.id.nav_share:
//                Intent sendIntent = new Intent();
//                sendIntent.setAction(Intent.ACTION_SEND);
//                sendIntent.putExtra(Intent.EXTRA_TEXT,
//                        "Hey check out my app at: https://play.google.com/store/apps/details?id=com.google.android.apps.plus");
//                sendIntent.setType("text/plain");
//                startActivity(sendIntent);

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_TEXT, "Like and Comment!");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Ho gya Share :O");
                startActivity(Intent.createChooser(intent, "Share Via..."));
                break;
            case R.id.nav_home:
                break;
            case R.id.nav_notifs:
                break;
            case R.id.nav_contact:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
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
