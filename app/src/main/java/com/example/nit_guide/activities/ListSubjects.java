package com.example.nit_guide.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.nit_guide.R;
import com.example.nit_guide.adapters.PageAdapter;
import com.example.nit_guide.adapters.SubjectAdapter;
import com.example.nit_guide.fragments.year1;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ListSubjects extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem tabitem1,tabitem2,tabitem3,tabitem4;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_list_subjects);

        String Subject = getIntent ( ).getStringExtra ("Subject");
        setUpToolbar ( );

        tabLayout = (TabLayout) findViewById (R.id.tabLayoutSubject);
        tabitem1 = (TabItem) findViewById ((R.id.tab1));
        tabitem2 = (TabItem) findViewById (R.id.tab2);
        tabitem2 = (TabItem) findViewById (R.id.tab3);
        tabitem4 = (TabItem)findViewById (R.id.tab4);
        viewPager = (ViewPager) findViewById (R.id.vpager);

        pagerAdapter = new SubjectAdapter (getSupportFragmentManager ( ), tabLayout.getTabCount ( ));
        viewPager.setAdapter (pagerAdapter);


        tabLayout.setOnTabSelectedListener (new TabLayout.OnTabSelectedListener ( ) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem (tab.getPosition ( ));

                if (tab.getPosition ( ) == 0 || tab.getPosition ( ) == 1 || tab.getPosition ( ) == 2) {
                    pagerAdapter.notifyDataSetChanged ( );
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
        viewPager.addOnPageChangeListener (new TabLayout.TabLayoutOnPageChangeListener (tabLayout));
    }

    private void setUpToolbar(){
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Subjecto-Papyrus");
        setSupportActionBar(toolbar);
    }

}
