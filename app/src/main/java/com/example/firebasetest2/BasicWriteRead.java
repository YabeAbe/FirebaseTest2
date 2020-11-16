package com.example.firebasetest2;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicWriteRead {
    private static String TAG;

    public BasicWriteRead() {
        TAG = "BasicWriteRead";
    }

    public static void basicWriteRead() {
        // [START write_message]
        DatabaseReference mDatabase;
        List<Person> personsArray;
        Map<String, Person> personsMap;

        // Write a message to the database
        // Create Database reference (リアルタイムデータベースとの接続点を作る)
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // Add message as greeting
        //          ↓　.child("node")（リアルタイムデータベースはDictionaryで保存される。node はKey にあたる）
        //          ↓                                  ↓ .setValue("value")（このnodeに値を設定する）
        mDatabase.child("message").child("Greeting").setValue("Hello World!");
        /*
        test-project-a-80ad6 (データベースの名前　ID的な　特に使わない）
            |
            message
                |
                Greeting: "Hello World!"
         */

        // Create Person Object
        Person person1 = new Person("Yuki", "warutu4aria@gmail.com", "08045008120");
        Person person2 = new Person("Daijiro", "something@gmail.com", "01234567890");
        Person person3 = new Person("Mika", "amanita@gmail.com", "0987654321");

        // Add person to the Database "person" node
        mDatabase.child("person").setValue(person1);
        // object をデータベースに入れると、同じnodeに複数のデータが書き込まれる。
        /*
        Database
            |
            person
                |
                mail: "warutu4aria@gmail.com"
                name: "Yuki"
                phone: "08045008120"
         */

        // Add person by person's name's node
        mDatabase.child("persons").child(person2.name).setValue(person2);
        mDatabase.child("persons").child(person3.name).setValue(person3);

        // Add persons to List
        personsArray = new ArrayList<Person>();
        personsArray.add(person1);
        personsArray.add(person2);
        personsArray.add(person3);

        Log.d(TAG, "Array: " + personsArray.get(0).name + " " + personsArray.get(1).name +
                " " + personsArray.get(2).name);
        mDatabase.child("personsArray").setValue(personsArray);
        // Arrayはデータベース上で番号をnodeとして書き込まれる。
        /*
        Database
            |
            personsArray
                |
                0
                    |
                    mail: "warutu4aria@gmail.com"
                    name: "Yuki"
                    phone: "08045008120"
                1
                    |
                    mail: "something@gmail.com"
                    name: "Daijiro"
                    phone: "0123456789"
                2
                    |
                    mail: "amanita@gmail.com"
                    name: "Mika"
                    phone: "0987654321"
         */

        // Add persons to map
        personsMap = new HashMap<String, Person>();
        personsMap.put(person1.name, person1);
        personsMap.put(person2.name, person2);
        personsMap.put(person3.name, person3);

        mDatabase.child("personsMap").setValue(personsMap);
        // Map は要素をMapに加えたときのKey をnodeとして書き込まれる。
        /*
        Database
            |
            personsMap
                |
                Daijiro
                    |
                    mail: "something@gmail.com"
                    name: "Daijiro"
                    phone: "0123456789"
                Mika
                    |
                    mail: "amanita@gmail.com"
                    name: "Mika"
                    phone: "0987654321"
                Yuki
                    |
                    mail: "warutu4aria@gmail.com"
                    name: "Yuki"
                    phone: "08045008120"
         */

        // [END write_message]

        // [START read_message]
        // Read from the database
        mDatabase.addValueEventListener(new ValueEventListener() {
            // （データベース上の値が変更されたときに読み込まれるmethod）
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                // Person value = dataSnapshot.getValue(Person.class);

                        //.getValue(Datatype.class)　このnode内のデータを指定したクラスの形に読み込む
                // Read from message node                                         ↓
                String value = dataSnapshot.child("message").child("Greeting").getValue(String.class);
                Log.d(TAG, "Value is: " + value);

                // Read from person node
                Person person_A = dataSnapshot.child("person").getValue(Person.class);
                Log.d(TAG, "Person_A name: " + person_A.name);
                Log.d(TAG, "Person_A mail: " + person_A.mail);
                Log.d(TAG, "Person_A phone: " + person_A.phone);

                // Read from persons node
                Person person_B = dataSnapshot.child("persons").child(person2.name).getValue(Person.class);
                Log.d(TAG, "Person_B name: " + person_B.name);
                Log.d(TAG, "Person_B mail: " + person_B.mail);
                Log.d(TAG, "Person_B phone: " + person_B.phone);

                // Read from personsArray node　Arrayはchildに数字を指定しないといけない
                Person person_C = dataSnapshot.child("personsArray").child("2").getValue(Person.class);
                Log.d(TAG, "person_C name: " + person_C.name);
                Log.d(TAG, "person_C mail: " + person_C.mail);
                Log.d(TAG, "person_C phone: " + person_C.phone);

                // Read personsArray node by iteration
                int personsArrayLength = (int) dataSnapshot.child("personsArray").getChildrenCount();
                Log.d(TAG, "pseronsArray childrencount: " + personsArrayLength);
                for(int i = 0; i < personsArrayLength; i++) {
                    String personLabel = "person_" + i;
                    Person person_i = dataSnapshot.child("personsArray").child(String.valueOf(i)).
                            getValue(Person.class);
                    Log.d(TAG, personLabel + " name: " + person_i.name);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        // [END read_message]
    }
}
