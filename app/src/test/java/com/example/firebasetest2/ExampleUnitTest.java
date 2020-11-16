package com.example.firebasetest2;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    DatabaseReference mDatabase;

    @Test
    public void basicWrite() {
        // [START write_message]
        // Write a message to the database


        // Create Database reference
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }
}