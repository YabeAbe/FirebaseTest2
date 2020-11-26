package com.example.firebasetest2;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ArrayTest {
    private static final String TAG = "ArrayTest";


    public ArrayTest () {}

    public static void arrayTest() {
        Person person1 = new Person("Yuki", "warutu4aria@gmail.com", "08045008120");
        Person person2 = new Person("Daijiro", "something@gmail.com", "01234567890");
        Person person3 = new Person("Mika", "amanita@gmail.com", "0987654321");
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        // Add persons to List
        ArrayList<Person> personsArray = new ArrayList<Person>();
        personsArray.add(person1);
        personsArray.add(person2);
        personsArray.add(person3);
        mDatabase.child("personsArray").setValue(personsArray);
        Log.d(TAG, "Arraylist is written");

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("personsArray");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot1 : snapshot.getChildren()) {
                    String personName = (String) dataSnapshot1.child("name").getValue();
                    Log.d(TAG, "name is " + personName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
