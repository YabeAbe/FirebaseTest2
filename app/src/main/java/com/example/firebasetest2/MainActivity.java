package com.example.firebasetest2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.firebasetest2.ArrayTest.arrayTest;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        new BasicWriteRead();
        BasicWriteRead.basicWriteRead();

        //new AdvanceWriteRead();
        //AdvanceWriteRead.advanceWriteRead();

        new WriteFamilies();
        WriteFamilies.writeFamilies();

        new ReadFamilies();
        ReadFamilies.readFamilies();

        new SeparateWriting();
        SeparateWriting.separateWriting();

        new SeparateReading();

        SeparateReading.separateReading();


        new ArrayTest();
        ArrayTest.arrayTest();
*/
        new PushTest();
        PushTest.pushTest();

        new PushOrderTest();
        PushOrderTest.pushOrderTest();

    }
}