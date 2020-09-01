package com.example.nit_guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class timetable extends AppCompatActivity{
    //    AdapterView.OnItemSelectedListener {
//        String[] country = { "India", "USA", "China", "Japan", "Other"};
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_main);
//            //Getting the instance of Spinner and applying OnItemSelectedListener on it
//            Spinner spin = (Spinner) findViewById(R.id.spinner);
//            spin.setOnItemSelectedListener(this);
//
//            //Creating the ArrayAdapter instance having the country list
//            ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
//            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            //Setting the ArrayAdapter data on the Spinner
//            spin.setAdapter(aa);
//
//        }
//
//        //Performing action onItemSelected and onNothing selected
//        @Override
//        public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
//            Toast.makeText(getApplicationContext(),country[position] , Toast.LENGTH_LONG).show();
//        }
//        @Override
//        public void onNothingSelected(AdapterView<?> arg0) {
//            // TODO Auto-generated method stub
//        }
//    }
    private Spinner branch_spin, year_spin,day_spin;
    private Button viewtt;
    public void addItemBranchSpinner(){
        branch_spin=(Spinner) findViewById (R.id.branch_spin);
        List<String> list =new ArrayList<String> ();
        list.add("Select branch");
        list.add("ME");
        list.add("CSE");
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
        Toolbar toolbar = null; //here toolbar is your id in xml
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("TimeTable");

        addItemBranchSpinner ();
        addItemYearSpinner ();
        addItemDaySpinner ();
        final String[] branch = new String[1];
        final String[] year = new String[1];
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
                if(branch[0].equals ("Select Branch") || year[0].equals ("Select Year") || day[0].equals ("Select Day")){ return;}
                ArrayList<String> BranchYear = new ArrayList<String>();
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
                Intent comp=new Intent(getApplicationContext(),View_TimeTable.class);
                comp.putStringArrayListExtra ("Branch and Year", BranchYear);
                startActivity(comp);
            }
        });

    }
}
