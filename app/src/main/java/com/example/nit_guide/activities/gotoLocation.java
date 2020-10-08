package com.example.nit_guide.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.nit_guide.R;

public class gotoLocation extends AppCompatActivity {

    private static final String TAG = "gotoLocation";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_goto_location);
        Log.d (TAG, "onCreate: Created");

    }
}
