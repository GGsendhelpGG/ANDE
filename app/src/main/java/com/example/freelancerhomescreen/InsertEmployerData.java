package com.example.freelancerhomescreen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InsertEmployerData extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    DatabaseReference userDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CreateTables db = new CreateTables(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        userDbRef = FirebaseDatabase.getInstance().getReference().child("Employers");
//        insertEmployerData();

        Employer e1 = new Employer("Prince Kharal Tech", "Singapore", "Description1");
        Employer e2 = new Employer("NCS", "Singapore", "Description2");
        Employer e3 = new Employer("A*STAR", "Singapore", "Description3");
        db.addEmployers(e1);
        db.addEmployers(e2);
        db.addEmployers(e3);


    }

//    public void insertEmployerData() {
//
//
//        Employer e1 = new Employer("Prince Kharal Tech", "Singapore", "Description1");
//        Employer e2 = new Employer("NCS", "Singapore", "Description2");
//        Employer e3 = new Employer("A*STAR", "Singapore", "Description3");
//        userDbRef.push().setValue(e1);
//        userDbRef.push().setValue(e2);
//        userDbRef.push().setValue(e3);
//
//    }

}
