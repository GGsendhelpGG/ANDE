package com.example.freelancerhomescreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertProjectData extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CreateTables db = new CreateTables(this);
        String startDate1 = "2020-09-21 10:20:05.123";
        String startDate2 = "2020-12-25 10:20:05.123";
        String startDate3 = "2019-01-01 10:20:05.123";

        String endDate1 = "2021-12-21 10:20:05.123";
        String endDate2 = "2022-12-25 10:20:05.123";
        String endDate3 = "2019-07-08 10:20:05.123";
        Projects p1 = new Projects("Student Management System", startDate1, endDate1, "https://github.com/shayaanak32/JADProjectRepo", "Java,J2EE", "Description1");
        Projects p2 = new Projects("IceBreaker!", startDate2, endDate2, "https://github.com/VielenKaat/ADES-Repo", "Java,J2EE", "Description1");
        Projects p3 = new Projects("Software Engineering Practice", startDate3, endDate3, "https://github.com/GGsendhelpGG/SEP_CA2", "Node.js,JavaScript", "Description3");
        db.addProjects(p1);
        db.addProjects(p2);
        db.addProjects(p3);

    }

}
