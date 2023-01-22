package com.example.freelancerhomescreen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class InsertExperienceData extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    DatabaseReference experienceDBRef;

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

        Experience e1 = new Experience("Java GUI Support Helper", startDate1, endDate1, "My experience at GOogle included" +
                "me helping out in the Java Support role, which helped teach me a lot of things!!", "Google");

        Experience e2 = new Experience("Microsoft DevOps Assistant", startDate2, endDate2, "My experience at Microsoft included" +
                "me helping out in the DevOps Support role, which helped teach me a lot of things with regards to testing, maintenance, etc.", "Microsoft");

        Experience e3 = new Experience("Apple Mobile Developer", startDate3, endDate3, "My experience at Apple included" +
                "me helping out in the Swift Support role, which helped teach me a lot on Mobile Apps, and how to optimise performance", "Apple");

        db.addExperience(e1);
        db.addExperience(e2);
        db.addExperience(e3);

    }


}
