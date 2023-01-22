package com.example.freelancerhomescreen;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class InsertCertificationData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CreateTables db = new CreateTables(this);
//        try {
            String endDate1 = "2021-12-21 10:20:05.123";
            String endDate2 = "2022-12-25 10:20:05.123";
            String endDate3 = "2019-07-08 10:20:05.123";
            String endDate4 = "2022-08-01 10:20:05.123";
//            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//            Date d1 = format.parse(endDate1);
//            Date d2 = format.parse(endDate2);
//            Date d3 = format.parse(endDate3);
//            Date d4 = format.parse(endDate4);

//            Certification c1 = new Certification("-NLl4BQkHkhZmfTI5Kuz", "OCP 11 Java Programmer", "https://www.aws.training/certification", endDate1, "Java,JavaScript", "Description1");
//            Certification c2 = new Certification("-NLl4BQkHkhZmfTI5Kuz", "Singapore", "https://www.coursera.org/professional-certificates/ibm-data-science", endDate2, "Python,Java", "Description2");
//            Certification c3 = new Certification("-NLl4BR2gq9EwVWUHixE", "Singapore", "https://www.coursera.org/professional-certificates/ibm-data-science", endDate3, "Java", "Description3");
//            Certification c4 = new Certification("-NLl4BR2gq9EwVWUHixF", "IBM Professional Data Science Certification", "https://www.coursera.org/professional-certificates/ibm-data-science", endDate4, "Java", "Description4");
            Certification c1 = new Certification("OCP 11 Java Programmer","https://www.aws.training/certification",endDate1,"Java,JavaScript", "Description1");
            Certification c2 = new Certification("IBM Professional Data Science Certification","https://www.coursera.org/professional-certificates/ibm-data-science",endDate2,"Python,Java", "Description2");
            Certification c3 = new Certification("DataCamp Certified Data Professional","https://www.coursera.org/professional-certificates/ibm-data-science",endDate3,"Java", "Description3");
            Certification c4 = new Certification("Google Cloud Certified Data Scientist","https://www.coursera.org/professional-certificates/ibm-data-science",endDate4,"Java", "Description4");
            db.addCertifications(c1);
            db.addCertifications(c2);
            db.addCertifications(c3);
            db.addCertifications(c4);
//        List<Certification> contacts = db.getAllContacts();
//
//        for (Certification cn : contacts) {
//            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
//                    cn.getLink();
//            // Writing Contacts to log
//            Log.d("Name: ", log);
//        }


//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }



}
