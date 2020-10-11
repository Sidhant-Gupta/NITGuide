package com.example.nit_guide.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.nit_guide.Adapter;
import com.example.nit_guide.R;
import com.example.nit_guide.adapters.AdapterPaper;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ListSubjects extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem tabitem1,tabitem2,tabitem3,tabitem4;
    ViewPager viewPager;
    AdapterPaper pagerAdapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_subjects);


        setupToolbar();
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutContact);
        tabitem1 = (TabItem) findViewById((R.id.tab1));
        tabitem2 = (TabItem) findViewById(R.id.tab2);
        tabitem3 = (TabItem) findViewById(R.id.tab3);
        tabitem4 = (TabItem) findViewById (R.id.tab4);
        viewPager = (ViewPager) findViewById(R.id.vpager);

        Toast.makeText (this, "Tab layout pr", Toast.LENGTH_SHORT).show ( );
        String s = getIntent().getStringExtra ("Subject");

        pagerAdapter = new AdapterPaper (getSupportFragmentManager(),tabLayout.getTabCount(),s);
        viewPager.setAdapter(pagerAdapter);



        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition () ==3) {
                    pagerAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // listen for scroll or page change
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }


    private void setupToolbar() {
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Previous Year Papers");
        setSupportActionBar(toolbar);
    }

}
