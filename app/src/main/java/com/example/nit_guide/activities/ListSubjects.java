package com.example.nit_guide.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nit_guide.R;

import java.util.ArrayList;

public class ListSubjects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_subjects);

        ArrayList<String> SubjectList = getIntent().getStringArrayListExtra("Subject");
        ListView lview=(ListView) findViewById(R.id.lview);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,SubjectList);
        lview.setAdapter(arrayAdapter);
        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getApplicationContext(), papers.class);
                startActivity(intent);
            }
        });

    }

}
