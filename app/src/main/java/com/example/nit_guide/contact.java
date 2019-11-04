package com.example.nit_guide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class contact extends AppCompatActivity {

    private Spinner dp_spin,hostel_spin,emergency_spin;

    public void addItemondpSpinner(){
        dp_spin = (Spinner) findViewById(R.id.dp_spin);
        List<String> list = new ArrayList<String>();
        list.add("Departments");
        list.add("CSE");
        list.add("ECE");
        list.add("IT");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dp_spin.setAdapter(dataAdapter);
    }
    public void addItemonhostelSpinner(){
        hostel_spin=(Spinner) findViewById(R.id.hostel_spin);
        List<String> list = new ArrayList<String>();
        list.add("Hostels");
        list.add("Boys hostel");
        list.add("Girls Hostel");
//        list.add("IT");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hostel_spin.setAdapter(dataAdapter);

    }

    public void addItemonEmergencySpinner(){
        emergency_spin=(Spinner) findViewById(R.id.emergency_spin);
        List<String> list = new ArrayList<String>();
        list.add("Emergency");
        list.add("Health Centre");
//        list.add("IT");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        emergency_spin.setAdapter(dataAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        addItemondpSpinner();
        addItemonhostelSpinner();
        addItemonEmergencySpinner();

        dp_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String ii=Integer.toString(i);
                if (i == 0) {
                    return;
                }
                else {
                    Intent mintent = new Intent(getApplicationContext(), contact_list.class);
                    mintent.putExtra("select", ii);
                    startActivity(mintent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
