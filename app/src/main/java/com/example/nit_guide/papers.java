package com.example.nit_guide;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class papers extends AppCompatActivity {
    private RecyclerView recycler_view;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papers);

        recycler_view=(RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recycler_view.setLayoutManager(layoutManager);
        List<modalClass> modalClassList=new ArrayList<>();
        modalClassList.add(new modalClass(R.drawable.contact_details,"DAA Endsem"));
        modalClassList.add(new modalClass(R.drawable.contact_details,"CN Endsem"));
        modalClassList.add(new modalClass(R.drawable.contact_details,"AUTOMATA Endsem"));
        modalClassList.add(new modalClass(R.drawable.contact_details,"DS Endsem"));
        modalClassList.add(new modalClass(R.drawable.contact_details,"JAVA Endsem"));
        modalClassList.add(new modalClass(R.drawable.contact_details,"PYTHON Endsem"));
        modalClassList.add(new modalClass(R.drawable.contact_details,"OS Endsem"));
        modalClassList.add(new modalClass(R.drawable.contact_details,"DBMS Endsem"));

        Adapter adapter=new Adapter(modalClassList);
        recycler_view.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
