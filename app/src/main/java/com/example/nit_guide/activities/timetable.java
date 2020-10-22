package com.example.nit_guide.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.nit_guide.R;

import java.util.ArrayList;
import java.util.List;

public class timetable extends AppCompatActivity{

    private Spinner branch_spin, year_spin,section_spin,day_spin;
    private Button viewtt;
    Toolbar toolbar;
    ArrayList<String> BranchYear = new ArrayList<String>();

    public void addItemBranchSpinner(){
        branch_spin=(Spinner) findViewById (R.id.branch_spin);
        List<String> list =new ArrayList<String> ();
        list.add("Select branch");
        list.add("CSE");
        list.add("ME");
        list.add("ECE");
        list.add("EEE");
        list.add("CE");
        list.add("PIE");
        list.add("IT");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        branch_spin.setAdapter (adapter);
    }

    public void addItemYearSpinner(){
        year_spin=(Spinner) findViewById (R.id.year_spin);
        List<String> list =new ArrayList<String> ();
        list.add("Select Year");
        list.add("First");
        list.add("Second");
        list.add("Third");
        list.add("Fourth");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        year_spin.setAdapter (adapter);
    }
    public void addItemSectionSpinner(){
        section_spin= (Spinner)findViewById (R.id.section_spin);
        List<String> list = new ArrayList<> ();
        list.add("Select Section");
        list.add ("1");
        list.add ("2");
        list.add ("3");
        list.add ("4");
        list.add ("5");
        list.add ("6");
        list.add ("7");
        list.add ("8");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        section_spin.setAdapter (adapter);

    }
    public void addItemDaySpinner(){
        day_spin= (Spinner)findViewById (R.id.day_spin);
        List<String> list = new ArrayList<> ();
        list.add("Select Day");
        list.add ("Monday");
        list.add ("Tuesday");
        list.add ("Wednesday");
        list.add ("Thursday");
        list.add ("Friday");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        day_spin.setAdapter (adapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_timetable);
//        Toolbar toolbar = null; //here toolbar is your id in xml
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//            toolbar = (Toolbar) findViewById(R.id.my_toolbar);
//        }
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("TimeTable");
        setUpToolbar();

        addItemBranchSpinner ();
        addItemYearSpinner ();
        addItemSectionSpinner ();
        addItemDaySpinner ();
        final String[] branch = new String[1];
        final String[] year = new String[1];
        final String[] section = new String[1];
        final String[] day = new String[1];

        branch_spin.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener (){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                branch[0] = adapterView.getItemAtPosition(i).toString();

                // Showing selected spinner item
                //Toast.makeText(adapterView.getContext(), "Selected: " + branch[0], Toast.LENGTH_LONG).show();
                }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
        year_spin.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener (){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                year[0] =  adapterView.getItemAtPosition(i).toString();

                // Showing selected spinner item
                //Toast.makeText(adapterView.getContext(), "Selected: " + year[0], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
        section_spin.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener (){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                section[0] = adapterView.getItemAtPosition(i).toString();

                // Showing selected spinner item
                //Toast.makeText(adapterView.getContext(), "Selected: " + section[0], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
        day_spin.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener (){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                day[0] =  adapterView.getItemAtPosition(i).toString();

                // Showing selected spinner item
                //Toast.makeText(adapterView.getContext(), "Selected: " + day[0], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

        viewtt = (Button)findViewById (R.id.view);
        viewtt.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                if(branch[0].equals ("Select Branch") || year[0].equals ("Select Year") || day[0].equals ("Select Day") || section[0].equals("Select Section")){ return;}
//                ArrayList<String> BranchYear = new ArrayList<String>();
                BranchYear.add(branch[0]);
                if(year[0] == "First")
                    BranchYear.add("1");
                else if(year[0] == "Second")
                    BranchYear.add("2");
                else if(year[0] == "Third")
                    BranchYear.add("3");
                else if(year[0] == "Fourth")
                    BranchYear.add("4");
                BranchYear.add(day[0]);
                BranchYear.add(section[0]);
                Intent comp=new Intent(getApplicationContext(), timetable_open.class);
                comp.putStringArrayListExtra ("Branch, Year, Day and Section", BranchYear);
                startActivity(comp);
            }
        });

    }

    private void setUpToolbar(){
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Time Table");
        setSupportActionBar(toolbar);
    }
}
