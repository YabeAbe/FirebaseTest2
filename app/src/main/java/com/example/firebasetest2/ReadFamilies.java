package com.example.firebasetest2;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Scanner;

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
                Log.d(TAG, String.valueOf(person_A.name));

                Family abe_family = snapshot.child("FamilyMap").child("Abe").getValue(Family.class);
                abe_family.familyMemberMap.get("Yuki");
                Log.d(TAG, "abe_family: " + abe_family.familyName);
                Log.d(TAG, String.valueOf(abe_family.getClass()));
                Log.d(TAG, "Person name: " + person_A.name + " " + abe_family.familyName);

                // Read family



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}
