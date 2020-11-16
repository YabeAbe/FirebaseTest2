package com.example.firebasetest2;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ReadFamilies {
    private static String TAG;

    public ReadFamilies() {
        TAG = "ReadFamilies";
    }
    public static void readFamilies() {
        //[START read_data]
        // Create database reference
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        // Create ValueEventListener
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Read from FamilyMap node by direct access
                Person person_A = snapshot.child("FamilyMap").child("Abe").child("familyMemberMap").
                        child("Yuki").getValue(Person.class);
                Log.d(TAG, "PersonA: " + person_A.name);


                // Read family
                Family abe_family = snapshot.child("FamilyMap").child("Abe").getValue(Family.class);
                Log.d(TAG, "abe_family: " + abe_family.familyName);
                Log.d(TAG, "abe_family: " + abe_family.familyMemberMap.get("Yuki").getClass());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}
