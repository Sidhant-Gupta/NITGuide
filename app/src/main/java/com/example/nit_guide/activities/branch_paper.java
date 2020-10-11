//package com.example.nit_guide.activities;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//
//import com.example.nit_guide.R;
//
//import java.util.ArrayList;
//
//public class branch_paper extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_branch_paper);
//        //startActivity();
//        ImageView comp=(ImageView)findViewById(R.id.computer_img);
//        ImageView it=(ImageView)findViewById(R.id.it_img);
//        ImageView civil=(ImageView)findViewById(R.id.civil_img);
//        ImageView ece=(ImageView)findViewById(R.id.ece_img);
//        ImageView elect=(ImageView)findViewById(R.id.electrical_img);
//        ImageView mech=(ImageView)findViewById(R.id.mechanical_img);
//
//        Button up=(Button)findViewById (R.id.button2);
//        Button home=(Button) findViewById (R.id.button3);
////        Button upload=(Button)findViewById (R.id.upload_btn);
//        up.setOnClickListener (new View.OnClickListener ( ) {
//            @Override
//            public void onClick(View view) {
//                Intent intent= new Intent(getApplicationContext (), profile.class);
//                startActivity (intent);
//            }
//        });
//        home.setOnClickListener (new View.OnClickListener (){
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent (getApplicationContext (), MainActivity.class);
//                startActivity (intent);
//            }
//        });
//        comp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ArrayList<String> SubjectList = new ArrayList<String>();
//                String[] stringArray={"OOPs in C++","C","Java","Automata","Web Development","Software Eng.","Unix/Linux","O.S.","Data Mining"};
//                for(int i=0;i<stringArray.length;i++){
//                    SubjectList.add(stringArray[i]);
//                }
//                Intent comp=new Intent(getApplicationContext(), ListSubjects.class);
//                comp.putStringArrayListExtra("String Array",SubjectList);
//                startActivity(comp);
//            }
//        });
//
//        civil.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ArrayList<String> SubjectList = new ArrayList<String>();
//                String[] stringArray={"OOPs in C++","C","Java","Automata","Web Development","Software Eng.","Unix/Linux","O.S.","Data Mining"};
//                for(int i=0;i<stringArray.length;i++){
//                    SubjectList.add(stringArray[i]);
//                }
//                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
//                comp.putExtra("String Array",SubjectList);
//                startActivity(comp);
//            }
//        });
//
//        it.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ArrayList<String> SubjectList = new ArrayList<String>();
//                String[] stringArray={"OOPs in C++","C","Java","Automata","Web Development","Software Eng.","Unix/Linux","O.S.","Data Mining"};
//                for(int i=0;i<stringArray.length;i++){
//                    SubjectList.add(stringArray[i]);
//                }
//                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
//                comp.putExtra("String Array",SubjectList);
//                startActivity(comp);
//            }
//        });
//
//        mech.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ArrayList<String> SubjectList = new ArrayList<String>();
//                String[] stringArray={"Mchine Design","C","Java","Automata","Web Development","Software Eng.","Unix/Linux","O.S.","Data Mining"};
//                for(int i=0;i<stringArray.length;i++){
//                    SubjectList.add(stringArray[i]);
//                }
//                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
//                comp.putExtra("String Array",SubjectList);
//                startActivity(comp);
//
//            }
//        });
//
//        elect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ArrayList<String> SubjectList = new ArrayList<String>();
//                String[] stringArray={"OOPs in C++","C","Java","Automata","Web Development","Software Eng.","Unix/Linux","O.S.","Data Mining"};
//                for(int i=0;i<stringArray.length;i++){
//                    SubjectList.add(stringArray[i]);
//                }
//                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
//                comp.putExtra("String Array",SubjectList);
//                startActivity(comp);
//            }
//        });
//
//        ece.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ArrayList<String> SubjectList = new ArrayList<String>();
//                String[] stringArray={"OOPs in C++","C","Java","Automata","Web Development","Software Eng.","Unix/Linux","O.S.","Data Mining"};
//                for(int i=0;i<stringArray.length;i++){
//                    SubjectList.add(stringArray[i]);
//                }
//                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
//                comp.putExtra("String Array",SubjectList);
//                startActivity(comp);
//            }
//        });
//
//    }
//
//}
package com.example.nit_guide.activities;

import androidx.appcompat.app.AppCompatActivity;

import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nit_guide.R;


public class branch_paper extends AppCompatActivity{
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


        onCLick();
//        computerCard.setOnClickListener (this);
//        itCard.setOnClickListener (this);
//        electricalCard.setOnClickListener (this);
//        civilCard.setOnClickListener (this);
//        mechCard.setOnClickListener (new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//////                Toast.makeText (view.getContext (), "what did i just get selected?", Toast.LENGTH_SHORT).show ( );
////                ArrayList<String> SubjectList = new ArrayList<String>();
////                String[] stringArray={"OOPs in C++","C","Java","Automata","Web Development","Software Eng.","Unix/Linux","O.S.","Data Mining"};
////                for(int i=0;i<stringArray.length;i++){
////                    SubjectList.add(stringArray[i]);
////                }
//                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
//                comp.putExtra("Subject","Mechanical");
//                startActivity(comp);
//            }
//        });
//
//        eceCard.setOnClickListener (new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
//                comp.putExtra("Subject","E.C.E.");
//                startActivity(comp);
//            }
//        });

    }

    private void onCLick() {
        computerCard.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
                comp.putExtra("Subject","Computer");
                startActivity(comp);
            }
        });

        itCard.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
                comp.putExtra("Subject","IT");
                startActivity(comp);
            }
        });

        electricalCard.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
                comp.putExtra("Subject","Electrical");
                startActivity(comp);
            }
        });

        civilCard.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
                comp.putExtra("Subject","Civil");
                startActivity(comp);
            }
        });
        mechCard.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
                comp.putExtra("Subject","Mechanical");
                startActivity(comp);
            }
        });

        eceCard.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent comp=new Intent(getApplicationContext(),ListSubjects.class);
                comp.putExtra("Subject","ECE");
                startActivity(comp);
            }
        });
    }
}
