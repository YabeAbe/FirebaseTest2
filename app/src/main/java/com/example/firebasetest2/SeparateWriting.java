package com.example.firebasetest2;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SeparateWriting {
    private static String TAG;
    private static HashMap<String, Person2> personsMap;
    private static HashMap<String, Family2> familiesMap;

    public SeparateWriting() {
        TAG = "separateWriting";
    }
    public static void separateWriting() {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        // Create Person Object
        Person2 person1 = new Person2("Yuki", "Abe", "warutu4aria@gmail.com", "08045008120");
        Person2 person2 = new Person2("Daijiro", "Sagane", "something@gmail.com", "01234567890");
        Person2 person3 = new Person2("Mika", "Abe", "amanita@gmail.com", "0987654321");

        // Create Faily2 Object
        Family2 family_A = new Family2("Abe", "Hokkaido, Sapporo");
        Family2 family_B = new Family2("Sagane", "Kanto");

        // Add persons to map
        personsMap = new HashMap<String, Person2>();
        personsMap.put(person1.first_name, person1);
        personsMap.put(person2.first_name, person2);
        personsMap.put(person3.first_name, person3);
        mDatabase.child("s_persons").setValue(personsMap);

        familiesMap = new HashMap<String, Family2>();
        familiesMap.put(family_A.familyName, family_A);
        familiesMap.put(family_B.familyName, family_B);


        mDatabase.child("s_families").setValue(familiesMap);
        mDatabase.child("1").setValue("1");

    }
}
