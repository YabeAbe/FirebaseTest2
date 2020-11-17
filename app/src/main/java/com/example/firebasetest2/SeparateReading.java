package com.example.firebasetest2;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SeparateReading {
    private static String TAG;

    public SeparateReading() {
        TAG = "s_read";
    }

    public static void separateReading() {
        Log.d(TAG, "start separate reading");
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        // Create ValueEventListener
        mDatabase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d(TAG, "call onDataChange");

                Person2 person_A = snapshot.child("s_persons").child("Yuki").getValue(Person2.class);

                String fullName = person_A.first_name + person_A.last_name;

                Family2 family_A = snapshot.child("s_families").
                        child(String.valueOf(person_A.last_name)).getValue(Family2.class);
                String address = family_A.familyAddress;

                Log.d(TAG, fullName);

                Log.d(TAG, fullName + " " + address);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}
