package com.example.nit_guide.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.nit_guide.R;
import com.example.nit_guide.adapters.PageAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class timetable_open extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem tabitem1,tabitem2,tabitem3,tabitem4,tabitem5;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable_open);
        setUpToolbar();
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutContact);
        tabitem1 = (TabItem) findViewById((R.id.mon));
        tabitem2 = (TabItem) findViewById(R.id.tue);
        tabitem3 = (TabItem) findViewById(R.id.wed);
        tabitem4 = (TabItem) findViewById(R.id.thur);
        tabitem5 = (TabItem) findViewById(R.id.fri);
        viewPager = (ViewPager) findViewById(R.id.vpager);

        pagerAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount(),"timetable");
        viewPager.setAdapter(pagerAdapter);

        viewPager.setAdapter(pagerAdapter);


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4) {
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
    private void setUpToolbar(){
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Time Table");
        setSupportActionBar(toolbar);
    }
}
