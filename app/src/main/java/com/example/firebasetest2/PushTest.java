package com.example.firebasetest2;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PushTest {
    private static final String TAG = "PushTest";

    public PushTest() {

    }

    public static void pushTest() {
        Person person1 = new Person("Yuki", "warutu4aria@gmail.com", "08045008120");
        Person person2 = new Person("Daijiro", "something@gmail.com", "01234567890");
        Person person3 = new Person("Mika", "amanita@gmail.com", "0987654321");
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("People").push().setValue(person1);
        mDatabase.child("People").push().setValue(person2);
        mDatabase.child("People").push().setValue(person3);
        Log.d(TAG, "Persons pushed");


        // ここでpush で生成されたノード名はスキップされる。
        DatabaseReference peopleRef = FirebaseDatabase.getInstance().getReference("People");
        peopleRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String personName = (String) dataSnapshot.child("name").getValue();
                    Log.d(TAG, "name is " + personName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "Reading failed");
            }
        });
    }
}
