package com.example.nit_guide;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class View_TimeTable extends AppCompatActivity {

TextView present, period1, period2, period3, period4, period5, period6, period7, period8;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_view_timetable);
        ArrayList<String> SubjectList = getIntent().getStringArrayListExtra("Branch and Year");

        
        final String branch = SubjectList.get(0);
        final String year = SubjectList.get(1);
        final String day =SubjectList.get(2);
        System.out.println(branch);
        System.out.print (year);
        System.out.print (day);
        final DataSnapshot snapshot = null;

        present = findViewById (R.id.day);
        present.setText (day);
        period1 = findViewById (R.id.period1);
        period2 = findViewById (R.id.period2);
        period3 = findViewById (R.id.period3);
        period4 = findViewById (R.id.period4);
        period5 = findViewById (R.id.period5);
        period6 = findViewById (R.id.period6);
        period7 = findViewById (R.id.period7);
        period8 = findViewById (R.id.period8);


        DatabaseReference reff = FirebaseDatabase.getInstance ( ).getReference ( "nit-guide/TimeTable");

        reff.addValueEventListener (new ValueEventListener ( ) {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String p1 = (String) snapshot.child(year).child(branch).child(day).child("P1").getValue ();
                String p2 = snapshot.child(year).child(branch).child(day).child("P2").getValue (String.class);
                String p3 = snapshot.child(year).child(branch).child(day).child("P3").getValue (String.class);
                String p4 = snapshot.child(year).child(branch).child(day).child("P4").getValue (String.class);
                String p5 = snapshot.child(year).child(branch).child(day).child("P5").getValue (String.class);
                String p6 = snapshot.child(year).child(branch).child(day).child("P6").getValue (String.class);
                String p7 = snapshot.child(year).child(branch).child(day).child("P7").getValue (String.class);
                String p8 = snapshot.child(year).child(branch).child(day).child("P8").getValue (String.class);
                System.out.println(p8);
                period1.setText (p1);
                period2.setText (p2);
                period3.setText (p3);
                period4.setText (p4);
                period5.setText (p5);
                period6.setText (p6);
                period7.setText (p7);
                period8.setText (p8);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
}
