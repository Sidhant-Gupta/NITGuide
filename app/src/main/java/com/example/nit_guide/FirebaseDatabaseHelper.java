package com.example.nit_guide;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDataRef;
    private List<db_contact> dblist=new ArrayList<> ();

    public interface DataStatus{
        void DataIsLoaded(List<db_contact> details,List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper(){
        mDatabase = FirebaseDatabase.getInstance ();
        mDataRef = mDatabase.getReference ("CSE");
    }
    public void readcontacts(final DataStatus ds){
        mDataRef.addValueEventListener (new ValueEventListener ( ) {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dblist.clear ();
                List<String> keys=new ArrayList<> ();
                for(DataSnapshot keynode:dataSnapshot.getChildren ()){
                    keys.add(keynode.getKey ());
                    db_contact details=keynode.getValue (db_contact.class);
                    dblist.add(details);
                }
                ds.DataIsLoaded (dblist,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}