package com.example.freelancerhomescreen;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InsertSkillsData extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    DatabaseReference skillsDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CreateTables db = new CreateTables(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Skills s1 = new Skills("Java");
        Skills s2 = new Skills("JavaScript");
        Skills s3 = new Skills("Go");
        Skills s4 = new Skills("Python");
        Skills s5 = new Skills("C#");
        Skills s6 = new Skills("C++");
        Skills s7 = new Skills("Node.js");
        Skills s8 = new Skills("Flask");
        Skills s9 = new Skills("Scala");
        db.addSkills(s1);
        db.addSkills(s2);
        db.addSkills(s3);
        db.addSkills(s4);
        db.addSkills(s5);
        db.addSkills(s6);
        db.addSkills(s7);
        db.addSkills(s8);
        db.addSkills(s9);



    }



}
