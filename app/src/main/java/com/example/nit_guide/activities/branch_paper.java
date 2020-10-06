package com.example.nit_guide.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.nit_guide.R;

import java.util.ArrayList;

public class branch_paper extends AppCompatActivity implements View.OnClickListener{
    //    Toolbar tool;
    private CardView computerCard,itCard,electricalCard,eceCard,mechCard,civilCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_branch_paper);

//        setUpToolbar ();
        //setting view reference to card objects
        computerCard = (CardView) findViewById (R.id.sub_computer);
        itCard = (CardView)findViewById (R.id.sub_it);
        electricalCard = (CardView)findViewById (R.id.sub_electrical);
        eceCard = (CardView)findViewById (R.id.sub_ece);
        civilCard = (CardView)findViewById (R.id.sub_civil);
        mechCard = (CardView)findViewById (R.id.sub_mech_pie);

        computerCard.setOnClickListener (this);
        itCard.setOnClickListener (this);
        electricalCard.setOnClickListener (this);
        civilCard.setOnClickListener (this);
        mechCard.setOnClickListener (this);
        eceCard.setOnClickListener (this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch(view.getId ( )){
            case R.id.sub_computer:
                i = new Intent(getApplicationContext(), ListSubjects.class);
                i.putExtra("Subject", "Computer");
                startActivity(i);
                break;
            case R.id.sub_it:
                i = new Intent(getApplicationContext(), ListSubjects.class);
                i.putExtra("Subject", "I.T.");
                startActivity(i);
                break;
            case R.id.sub_civil:
                i = new Intent(getApplicationContext(), ListSubjects.class);
                i.putExtra("Subject", "Civil.");
                startActivity(i);
                break;
            case R.id.sub_ece:
                i = new Intent(getApplicationContext(), ListSubjects.class);
                i.putExtra("Subject", "E.C.E.");
                startActivity(i);
                break;
            case R.id.sub_electrical:
                i = new Intent(getApplicationContext(), ListSubjects.class);
                i.putExtra("Subject", "Electrical");
                startActivity(i);
                break;
            case R.id.sub_mech_pie:
                i = new Intent(getApplicationContext(), ListSubjects.class);
                i.putExtra("Subject", "Mech/P.I.E.");
                startActivity(i);
                break;
            default:
                break;
        }
    }

//    stringArray= new String[]{"OOPs in C++", "C", "Java", "Automata", "Web Development", "Software Eng.", "Unix/Linux", "O.S.", "Data Mining"};
//                for(int j=0;j<stringArray.length;j++){
//        SubjectList.add(stringArray[j]);
//    }
//
//    i = new Intent(getApplicationContext(), ListSubjects.class);
//                i.putStringArrayListExtra("String Array",SubjectList);
//    startActivity(i);

//    private void setUpToolbar(){
//        tool=(Toolbar) findViewById(R.id.toolbar);
//        tool.setTitle("Previous Year Question Papers");
//        setSupportActionBar(tool);
//    }

}
