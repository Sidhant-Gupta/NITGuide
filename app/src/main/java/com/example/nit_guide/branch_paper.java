package com.example.nit_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import javax.security.auth.Subject;

public class branch_paper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_paper);
        //startActivity();
        ImageView comp=(ImageView)findViewById(R.id.computer_img);
        ImageView it=(ImageView)findViewById(R.id.it_img);
        ImageView civil=(ImageView)findViewById(R.id.civil_img);
        ImageView ece=(ImageView)findViewById(R.id.ece_img);
        ImageView elect=(ImageView)findViewById(R.id.electrical_img);
        ImageView mech=(ImageView)findViewById(R.id.mechanical_img);

        Button up=(Button)findViewById (R.id.button2);
        Button home=(Button) findViewById (R.id.button3);
//        Button upload=(Button)findViewById (R.id.upload_btn);
        up.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext (),profile.class);
                startActivity (intent);
            }
        });
        home.setOnClickListener (new View.OnClickListener (){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext (),MainActivity.class);
                startActivity (intent);
            }
        });
        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> SubjectList = new ArrayList<String>();
                String[] stringArray={"OOPs in C++","C","Java","Automata","Web Development","Software Eng.","Unix/Linux","O.S.","Data Mining"};
                for(int i=0;i<stringArray.length;i++){
                    SubjectList.add(stringArray[i]);
                }
                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
                comp.putStringArrayListExtra("String Array",SubjectList);
                startActivity(comp);
            }
        });

        civil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> SubjectList = new ArrayList<String>();
                String[] stringArray={"OOPs in C++","C","Java","Automata","Web Development","Software Eng.","Unix/Linux","O.S.","Data Mining"};
                for(int i=0;i<stringArray.length;i++){
                    SubjectList.add(stringArray[i]);
                }
                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
                comp.putExtra("String Array",SubjectList);
                startActivity(comp);
            }
        });

        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> SubjectList = new ArrayList<String>();
                String[] stringArray={"OOPs in C++","C","Java","Automata","Web Development","Software Eng.","Unix/Linux","O.S.","Data Mining"};
                for(int i=0;i<stringArray.length;i++){
                    SubjectList.add(stringArray[i]);
                }
                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
                comp.putExtra("String Array",SubjectList);
                startActivity(comp);
            }
        });

        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> SubjectList = new ArrayList<String>();
                String[] stringArray={"Mchine Design","C","Java","Automata","Web Development","Software Eng.","Unix/Linux","O.S.","Data Mining"};
                for(int i=0;i<stringArray.length;i++){
                    SubjectList.add(stringArray[i]);
                }
                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
                comp.putExtra("String Array",SubjectList);
                startActivity(comp);

            }
        });

        elect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> SubjectList = new ArrayList<String>();
                String[] stringArray={"OOPs in C++","C","Java","Automata","Web Development","Software Eng.","Unix/Linux","O.S.","Data Mining"};
                for(int i=0;i<stringArray.length;i++){
                    SubjectList.add(stringArray[i]);
                }
                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
                comp.putExtra("String Array",SubjectList);
                startActivity(comp);
            }
        });

        ece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> SubjectList = new ArrayList<String>();
                String[] stringArray={"OOPs in C++","C","Java","Automata","Web Development","Software Eng.","Unix/Linux","O.S.","Data Mining"};
                for(int i=0;i<stringArray.length;i++){
                    SubjectList.add(stringArray[i]);
                }
                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
                comp.putExtra("String Array",SubjectList);
                startActivity(comp);
            }
        });

    }

}
