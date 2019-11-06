package com.example.nit_guide;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class firebasedatabasehelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mmReferencecontact,mReferencecontact;
    private List<db_contact> contacts=new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<db_contact>contacts,List<String>keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();

    }

    public firebasedatabasehelper(String i) {
        FirebaseDatabase.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mmReferencecontact = mDatabase.getReference();
        if(i.equals("1"))
            mReferencecontact=mmReferencecontact.child("CSE");
        else if(i.equals("2"))
            mReferencecontact=mmReferencecontact.child("ECE");
        else
            mReferencecontact=mmReferencecontact.child("CSE");

//
//        mReferencecontact.setValue("hello");
    }

    public void readContacts(final DataStatus datastatus){
        mReferencecontact.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                contacts.clear();
                List<String> keys=new ArrayList<>();
                for(DataSnapshot keynode:dataSnapshot.getChildren()){
                    keys.add(keynode.getKey());
                    db_contact con1=keynode.getValue(db_contact.class);
                    contacts.add(con1);
                }
                datastatus.DataIsLoaded(contacts,keys);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
