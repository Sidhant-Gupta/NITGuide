package com.example.nit_guide.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.nit_guide.R;

import java.util.ArrayList;

public class openPapers_db extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_open_papers_db);

        ArrayList<String> place = getIntent ( ).getStringArrayListExtra ("Year+Subject");
    }
}
