package com.example.freelancerhomescreen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertYourSkillsData extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    DatabaseReference yourSkillsDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yourSkillsDbRef = FirebaseDatabase.getInstance().getReference().child("YourSkills");
        insertYourSkillsData();
    }

    public void insertYourSkillsData() {

//        try {
//
//            String startDate1 = "1/12/2021";
//            String startDate2 = "1/12/2022";
//            String startDate3 = "1/6/2019";
//
//            String endDate1 = "31/12/2021";
//            String endDate2 = "31/12/2022";
//            String endDate3 = "1/7/2019";
//            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//
//            Date sd1 = format.parse(startDate1);
//            Date sd2 = format.parse(startDate2);
//            Date sd3 = format.parse(startDate3);
//
//            Date ed1 = format.parse(endDate1);
//            Date ed2 = format.parse(endDate2);
//            Date ed3 = format.parse(endDate3);
//            Experience e1 = new Experience("Java GUI Support Helper", sd1, ed1, "My experience at GOogle included" +
//                    "me helping out in the Java Support role, which helped teach me a lot of things!!", "Google","-NLl4BQkHkhZmfTI5Kuz");
//
//            Experience e2 = new Experience("Microsoft DevOps Assistant", sd2, ed2, "My experience at Microsoft included" +
//                    "me helping out in the DevOps Support role, which helped teach me a lot of things with regards to testing, maintenance, etc.", "Microsoft", "-NLl4BR2gq9EwVWUHixE");
//
//            Experience e3 = new Experience("Apple Mobile Developer", sd3, ed3, "My experience at Apple included" +
//                    "me helping out in the Swift Support role, which helped teach me a lot on Mobile Apps, and how to optimise performance", "Apple","-NLl4BR2gq9EwVWUHixF");
//            experienceDBRef.push().setValue(e1);
//            experienceDBRef.push().setValue(e2);
//            experienceDBRef.push().setValue(e3);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        YourSkills s1 = new YourSkills("-NLl4BQkHkhZmfTI5Kuz","-NLnl__U7HcQtDTj8zK2","Java");
        YourSkills s2 = new YourSkills("-NLl4BQkHkhZmfTI5Kuz", "-NLnl__dzz4znJ1dPGnW","Scala");
        YourSkills s3 = new YourSkills("-NLl4BQkHkhZmfTI5Kuz","-NLnl__c6-tbHS5TAWYp","JavaScript");


        YourSkills s4 = new YourSkills("-NLl4BR2gq9EwVWUHixE","-NLnl__c6-tbHS5TAWYq","Go");
        YourSkills s5 = new YourSkills("-NLl4BR2gq9EwVWUHixE","-NLnl__c6-tbHS5TAWYp","JavaScript");
        YourSkills s6 = new YourSkills("-NLl4BR2gq9EwVWUHixE","-NLnl__c6-tbHS5TAWYs","C#");

        YourSkills s7 = new YourSkills("-NLl4BR2gq9EwVWUHixF","-NLnl__c6-tbHS5TAWYt","C++");
        YourSkills s8 = new YourSkills("-NLl4BR2gq9EwVWUHixF","-NLnl__c6-tbHS5TAWYp","JavaScript");
        YourSkills s9 = new YourSkills("-NLl4BR2gq9EwVWUHixF","-NLnl__c6-tbHS5TAWYs","C#");

        yourSkillsDbRef.push().setValue(s1);
        yourSkillsDbRef.push().setValue(s2);
        yourSkillsDbRef.push().setValue(s3);
        yourSkillsDbRef.push().setValue(s4);
        yourSkillsDbRef.push().setValue(s5);
        yourSkillsDbRef.push().setValue(s6);
        yourSkillsDbRef.push().setValue(s7);
        yourSkillsDbRef.push().setValue(s8);
        yourSkillsDbRef.push().setValue(s9);
    }
}
