package com.example.nit_guide.firebase;


import androidx.annotation.NonNull;
import com.example.nit_guide.models.FBModelContacts;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
 import java.util.ArrayList;
 import java.util.List;

public class FirebaseDbHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mmReferencecontact,mReferencecontact;
    private List<FBModelContacts> contacts=new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<FBModelContacts>contacts,List<String>keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();

    }

    public FirebaseDbHelper(String intentMsg) {
        FirebaseDatabase.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mmReferencecontact = mDatabase.getReference();
        mReferencecontact=mmReferencecontact.child("Department").child(intentMsg).child("Contacts");
    }

    public void readContacts(final DataStatus datastatus){
        mReferencecontact.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                contacts.clear();
                List<String> keys=new ArrayList<>();
                for(DataSnapshot keynode:dataSnapshot.getChildren()){
                    keys.add(keynode.getKey());
                    FBModelContacts con1=keynode.getValue(FBModelContacts.class);
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
