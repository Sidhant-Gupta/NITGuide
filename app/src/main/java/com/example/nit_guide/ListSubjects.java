package com.example.nit_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListSubjects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_subjects);

        ArrayList<String> SubjectList = getIntent().getStringArrayListExtra("String Array");
        ListView lview=(ListView) findViewById(R.id.lview);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,SubjectList);
        lview.setAdapter(arrayAdapter);

    }
}
