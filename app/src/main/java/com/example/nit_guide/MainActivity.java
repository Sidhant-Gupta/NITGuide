package com.example.nit_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView places=(ImageView) findViewById(R.id.places);
        ImageView website=(ImageView) findViewById(R.id.website);
        ImageView cmap=(ImageView) findViewById(R.id.cmap);
        ImageView cdetails=(ImageView) findViewById(R.id.cdetails);
        ImageView prevyear=(ImageView) findViewById(R.id.prevyear);

        prevyear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent prev=new Intent(getApplicationContext(),register.class);
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
//        gmail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent gintent=new Intent();
//                gintent.setAction(Intent.ACTION_SEND);
//                gintent.putExtra(Intent.EXTRA_SUBJECT,"wohoo");
//                gintent.putExtra(Intent.EXTRA_TEXT,"United States");
//
//            }
//        });
    }
}
