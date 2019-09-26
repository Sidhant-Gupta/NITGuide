package com.example.nit_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class branch_paper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_paper);
        //startActivity();
        ImageView comp=(ImageView)findViewById(R.id.computer_img);
        ImageView it=(ImageView)findViewById(R.id.it_img);
        ImageView civil=(ImageView)findViewById(R.id.civil_img);
        ImageView ece=(ImageView)findViewById(R.id.ece_img);
        ImageView elect=(ImageView)findViewById(R.id.electrical_img);
        ImageView mech=(ImageView)findViewById(R.id.mechanical_img);

        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        civil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        elect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

}
