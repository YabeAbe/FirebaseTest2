package com.example.firebasetest2;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AdvanceWriteRead {
    private static String TAG;

    public AdvanceWriteRead() {
        TAG = "AdvanceWriteRead";
    }
/*
    public static void advanceWriteRead() {
        //[Start write_data]
        DatabaseReference mDatabase;
        ArrayList<Person> personsArray_A;
        ArrayList<Person> personsArray_B;
        List<Family> familiesArray;

        // Create Database reference
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Create Person Object
        Person person1 = new Person("Yuki", "warutu4aria@gmail.com", "08045008120");
        Person person2 = new Person("Daijiro", "something@gmail.com", "01234567890");
        Person person3 = new Person("Mika", "amanita@gmail.com", "0987654321");

        // Create Family object
        personsArray_A = new ArrayList<Person>();
        personsArray_A.add(person1);
        personsArray_A.add(person3);

        personsArray_B = new ArrayList<Person>();
        personsArray_B.add(person2);

        Family family1 = new Family("Abe", "Hokkaido, Sapporo", personsArray_A);
        Log.d(TAG, family1.familyMemberList.get(1).name);
        Family family2 = new Family("Sagane", "Kanto", personsArray_B);
        Log.d(TAG, family2.familyMemberList.get(0).name);

        // Write family1 into database
        mDatabase.child("family").setValue(family1);

        // Create ArrayList families
        List<Family> families = new ArrayList<Family>();
        families.add(family1);
        families.add(family2);

        //Write families into database
        mDatabase.child("families").setValue(families);


    }
 */
}
