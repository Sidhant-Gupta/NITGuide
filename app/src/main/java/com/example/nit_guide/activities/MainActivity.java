package com.example.nit_guide.activities;

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
import androidx.fragment.app.Fragment;

import com.example.nit_guide.R;
import com.example.nit_guide.fragments.Home;
import com.example.nit_guide.fragments.NavContactUs;
import com.example.nit_guide.fragments.navAcadCalender;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//import android.widget.Toolbar;
//implements NavigationView.OnNavigationItemSelectedListener
public class MainActivity extends AppCompatActivity  {
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
//        ImageView places=(ImageView) findViewById(R.id.places);
//        ImageView website=(ImageView) findViewById(R.id.website);
//        ImageView cmap=(ImageView) findViewById(R.id.cmap);
//        ImageView cdetails=(ImageView) findViewById(R.id.cdetails);
//        ImageView prevyear=(ImageView) findViewById(R.id.prevyear);
//        ImageView timetable=(ImageView) findViewById (R.id.timetable);



        setUpToolbar();
        drawerLayout = findViewById (R.id.drawerlayout);

        NavigationView navigationView=findViewById (R.id.navigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new NavContactUs()).commit();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            Fragment temp=null;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId ()){
                    case R.id.nav_share:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new navAcadCalender()).commit();
                        System.out.println("drawer clicked");
                        break;
                    case R.id.nav_home:
                        System.out.println("drawer clicked");
                        Log.d ("navigation drawer","yaayaaaaaaaaaaaaaaaaaaaa");
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Home()).commit();
//                        temp=new Home();
                        break;
                    case R.id.nav_notifs:
                        System.out.println("drawer clicked");
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Home()).commit();
//                        temp =new navAcadCalender();
                        break;
                    case R.id.nav_contact:
//                        temp =new NavContactUs();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new NavContactUs()).commit();
                        System.out.println("drawer clicked");
                        break;
                    default:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Home()).commit();

                }
//                getSupportFragmentManager().beginTransaction().replace(R.id.container, temp).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        TextView username=(TextView) findViewById (R.id.username);
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        System.out.print (user.getDisplayName ());
        //username.setText(user.getDisplayName ());
        TextView usermail=(TextView) findViewById (R.id.usermail);
        Log.d ("user.getEmail()","yaay");
        System.out.println(user.getEmail());
        System.out.println (" rrrrrrrrrrrrrrrr " + user.getDisplayName ());
        //usermail.setText(user.getEmail ());
//        prevyear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent prev=new Intent(getApplicationContext(), branch_paper.class);
//                startActivity(prev);
//            }
//        });
//
//        timetable.setOnClickListener (new View.OnClickListener ( ) {
//            @Override
//            public void onClick(View view) {
//                Intent time=new Intent(getApplicationContext (), com.example.nit_guide.activities.timetable.class);
//                startActivity(time);
//            }
//        });
//
//        places.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent startIntent=new Intent(getApplicationContext(), MapsActivity.class);
//                startActivity(startIntent);
//            }
//        });
//
//        website.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
//                myWebLink.setData(Uri.parse("http://www.nitkkr.ac.in/"));
//                startActivity(myWebLink);
//            }
//        });
//
//        cmap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent camp=new Intent(getApplicationContext(), MapsActivity.class);
//                startActivity(camp);
//            }
//        });
//
//        cdetails.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent sIntent=new Intent(getApplicationContext(), Contacts.class);
//                startActivity(sIntent);
//            }
//        });

    }



//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        switch(menuItem.getItemId ()){
//            case R.id.nav_share:
//                System.out.println("drawer clicked");
//                break;
//            case R.id.nav_home:
//                System.out.println("drawer clicked");
//                Intent timetable = new Intent(MainActivity.this, Contacts.class);
//                startActivity(timetable);
//                break;
//            case R.id.nav_notifs:
//                System.out.println("drawer clicked");
//                temp =new navAcadCalender();
//                break;
//            case R.id.nav_contact:
//                temp =new NavContactUs();
//                System.out.println("drawer clicked");
//                break;
//        }
////                getSupportFragmentManager().beginTransaction().replace(R.id.container, temp).commit();
//        drawerLayout.closeDrawer(GravityCompat.START);
//        return true;
//    }

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
