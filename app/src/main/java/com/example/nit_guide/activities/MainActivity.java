package com.example.nit_guide.activities;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
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
import com.example.nit_guide.fragments.navAbout;
import com.example.nit_guide.fragments.navAcadCalender;
import com.example.nit_guide.fragments.nav_olx;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//import android.widget.Toolbar;
//implements NavigationView.OnNavigationItemSelectedListener
public class MainActivity extends AppCompatActivity   {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;

    // Write a message to the database
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference myRef = database.getReference("message");

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        setUpToolbar();
        drawerLayout = findViewById (R.id.drawerlayout);

        NavigationView navigationView=findViewById (R.id.navigationView);
        navigationView.bringToFront();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Home()).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            Fragment temp=null;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId ()){
                    case R.id.nav_share:
                        temp=new NavContactUs();
                        break;
                    case R.id.nav_home:
                        temp=new Home();
                        break;
                    case R.id.nav_notifs:
                        temp =new navAcadCalender();
//                        Intent intent = new Intent(MainActivity.this, Contacts.class);
//                        startActivity(intent);
                        break;
                    case R.id.nav_contact:
                        temp =new navAbout();
                        break;
                    case R.id.nav_olx:
                        temp=new nav_olx();
                        break;
                    default:
                        temp=new Home();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, temp).commit();
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
//        usermail.setText(user.getEmail ());
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
