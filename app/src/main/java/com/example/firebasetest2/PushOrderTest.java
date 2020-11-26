package com.example.firebasetest2;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class PushOrderTest {
    private static final String TAG = "PushOrderTest";

    public PushOrderTest() {

    }

    public static void pushOrderTest() {
        // クエリのorderでは、指定しない限り全ての要素に自動でループする。
        DatabaseReference peopleRef = FirebaseDatabase.getInstance().getReference("People");
        Query query = peopleRef.orderByChild("name");
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String personName = (String) snapshot.child("name").getValue();
                Log.d(TAG, "Name is " + personName);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
