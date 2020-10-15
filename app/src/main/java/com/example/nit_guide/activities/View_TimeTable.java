package com.example.nit_guide.activities;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nit_guide.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class View_TimeTable extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listview;

    //TextView present, period1, period2, period3, period4, period5, period6, period7, period8;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_view_timetable);
        ArrayList<String> SubjectList = getIntent ( ).getStringArrayListExtra ("Branch, Year, Day and Section");

        final String[][] period = new String[3][3];
        final String[][] room = new String[3][3];
        final String[][] fromtime = new String[][]{{"8:30 a.m.","9:25 a.m.","10:20 a.m."}, {"10:40 a.m.", "11:35 a.m.", "12:30 p.m."}, {"1:25 p.m.","2:40 p.m.","3:35 p.m."}};
        final String[][] totime = new String[][]{{"to 9:25 a.m.","to 10:20 a.m.", "to 10:40 a.m."}, {"to 11:35 a.m.", "to 12:30 p.m.", "to 1:25 p.m."},{"to 2:40 p.m.","to 3:35 p.m.", "to 4:30 p.m."}};
//        fromtime[0][] = {"8:30 a.m.","",""};
//        fromtime[1] = "9:25 a.m.";
//        fromtime[2] = "10:40 a.m.";
//        fromtime[3] = "11:35 a.m.";
//        fromtime[4] = "12:30 p.m.";
//        fromtime[5] = "1:25 p.m.";
//        fromtime[6] = "2:40 p.m.";
//        fromtime[7] = "3:35 p.m.";
//
//        totime[0] = "to 9:25 a.m.";
//        totime[1] = "to 10:20 a.m.";
//        totime[2] = "to 11:35 a.m.";
//        totime[3] = "to 12:30 p.m.";
//        totime[4] = "to 1:25 p.m.";
//        totime[5] = "to 2:40 p.m.";
//        totime[6] = "to 3:35 p.m.";
//        totime[7] = "to 4:30 p.m.";



//        period[0][0] = "ef";
//        period[0][1] = "9:25 a.m.";
//        period[0][2] = "Break";
//
//        period[1][0] = "11:35 a.m.";
//        period[1][1] = "12:30 p.m.";
//        period[1][2] = "1:25 p.m.";
//
//        period[2][0] = "2:40 p.m.";
//        period[2][1] = "3:35 p.m.";
//        period[2][2] = "3:35 p.m.";
//
//
//        room[0][0] = "to 9:25 a.m.";
//        room[0][1] = "to 10:20 a.m.";
//        room[0][2] = "to 11:35 a.m.";
//
//        room[1][0] = "to 12:30 p.m.";
//        room[1][1] = "to 1:25 p.m.";
//        room[1][2] = "to 2:40 p.m.";
//
//        room[2][0] = "to 3:35 p.m.";
//        room[2][1] = "to 4:30 p.m.";
//        room[2][2] = "khatam";

        final String branch = SubjectList.get (0);
        final String year = SubjectList.get (1);
        final String day = SubjectList.get (2);
        final String section = SubjectList.get (3);
        Log.e ("year", year);
        System.out.println (branch);
        System.out.print (year);
        System.out.print (day);
        final DataSnapshot snapshot = null;


        DatabaseReference reff = FirebaseDatabase.getInstance ( ).getReference ( "nit-guide/data/TimeTable").child(branch).child(year).child(section).child(day);
        reff.addValueEventListener (new ValueEventListener ( ) {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                period[0][0] = snapshot.child("P1").getValue (String.class);
                period[0][1] = snapshot.child("P2").getValue (String.class);
                period[0][2] = snapshot.child("P3").getValue (String.class);

                period[1][0] = snapshot.child("P4").getValue (String.class);
                period[1][1] = snapshot.child("P5").getValue (String.class);
                period[1][2] = snapshot.child("P6").getValue (String.class);

                period[2][0] = snapshot.child("P7").getValue (String.class);
                period[2][1] = snapshot.child("P8").getValue (String.class);
                period[2][2] = snapshot.child("P9").getValue (String.class);
//
//
                room[0][0] = (String) snapshot.child("room1").getValue ();
                room[0][1] = snapshot.child("room2").getValue (String.class);
                room[0][2] = snapshot.child("room3").getValue (String.class);

                room[1][0] = snapshot.child("room4").getValue (String.class);
                room[1][1] = snapshot.child("room5").getValue (String.class);
                room[1][2] = snapshot.child("room6").getValue (String.class);

                room[2][0] = snapshot.child("room7").getValue (String.class);
                room[2][1] = snapshot.child("room8").getValue (String.class);
                room[2][2] = snapshot.child("room9").getValue (String.class);

                System.out.println(" "+room[0][0]);
//                period1.setText (p1);
//                period2.setText (p2);
//                period3.setText (p3);
//                period4.setText (p4);
//                period5.setText (p5);
//                period6.setText (p6);
//                period7.setText (p7);
//                period8.setText (p8);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
//
    });



        setupUIView ( );
        setUpToolbar();

        SimpleAdapter simpleAdapter = new SimpleAdapter (this, period, room, fromtime, totime);
        listview.setAdapter (simpleAdapter);
    }


    private void setupUIView(){
        toolbar = findViewById (R.id.toolbar);
        listview = findViewById (R.id.lvmain);
    }

    private void setUpToolbar(){
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("TimeTable");
        setSupportActionBar(toolbar);
    }


    public class SimpleAdapter extends BaseAdapter{

    private Context mContext;
    private LayoutInflater li = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);;
    private TextView subject, roomno,fromtime,totime, subject2, roomno2,fromtime2,totime2, subject3, roomno3,fromtime3,totime3;
    private String[][] subjectarray, roomarray,from,to;

        public SimpleAdapter(Context Context, String[][] subjectA, String[][] roomA, String[][] fromtimeA, String[][] totimeA){
            mContext = Context;
            subjectarray = subjectA;
            roomarray = roomA;
            from = fromtimeA;
            to = totimeA;

        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object getItem(int i) {
            return subjectarray[i][0];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view == null){
                view = li.inflate (R.layout.activity_view_timetable_singleitem,null,true);
            }

            roomno = (TextView)view.findViewById (R.id.room);
            subject = (TextView) view.findViewById (R.id.subject1);
            fromtime = (TextView) view.findViewById (R.id.fromtime);
            totime = (TextView)view.findViewById (R.id.totime);

            roomno.setText(roomarray[i][0]);
            subject.setText (subjectarray[i][0]);
            fromtime.setText (from[i][0]);
            totime.setText (to[i][0]);


            //second
            roomno2 = (TextView)view.findViewById (R.id.room2);
            subject2 = (TextView) view.findViewById (R.id.subject2);
            fromtime2 = (TextView) view.findViewById (R.id.fromtime2);
            totime2 = (TextView)view.findViewById (R.id.totime2);

            roomno2.setText(roomarray[i][1]);
            subject2.setText (subjectarray[i][1]);
            fromtime2.setText (from[i][1]);
            totime2.setText (to[i][1]);


            //third
            roomno3 = (TextView)view.findViewById (R.id.room3);
            subject3 = (TextView) view.findViewById (R.id.subject3);
            fromtime3 = (TextView) view.findViewById (R.id.fromtime3);
            totime3 = (TextView)view.findViewById (R.id.totime3);

            roomno3.setText(roomarray[i][2]);
            subject3.setText (subjectarray[i][2]);
            fromtime3.setText (from[i][2]);
            totime3.setText (to[i][2]);


            return view;


        }
    }

}
