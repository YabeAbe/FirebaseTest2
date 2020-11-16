package com.example.firebasetest2;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class WriteFamilies {
    private static String TAG;

    public WriteFamilies() {
        TAG = "WriteFamilies";
    }
    public static void writeFamilies() {
        //[START write_data]
        // Create database reference
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        // Create Person Object
        Person person1 = new Person("Yuki", "warutu4aria@gmail.com", "08045008120");
        Person person2 = new Person("Daijiro", "something@gmail.com", "01234567890");
        Person person3 = new Person("Mika", "amanita@gmail.com", "0987654321");

        // Create Family object
        HashMap<String, Person> personMap_A = new HashMap<String, Person>();
        personMap_A.put(person1.name, person1);
        personMap_A.put(person3.name, person3);
        Family family1 = new Family("Abe", "Hokkaido, Sapporo", personMap_A);

        HashMap<String, Person> personMap_B = new HashMap<String, Person>();
        personMap_B.put(person2.name, person2);
        Family family2 = new Family("Sagane", "Kanto", personMap_B);

        HashMap<String, Family> familyMap = new HashMap<String, Family>();
        familyMap.put(family1.familyName, family1);
        familyMap.put(family2.familyName, family2);

        mDatabase.child("FamilyMap").setValue(familyMap);
    }
}