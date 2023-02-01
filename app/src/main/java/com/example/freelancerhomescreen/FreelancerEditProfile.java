package com.example.freelancerhomescreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class FreelancerEditProfile extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "MainActivity";
    EditText freelancerName, freelancerDescription;
    Button saveChanges;
    CircleImageView pfp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freelancer_edit_profile);
        int userid = 1;
        //todo: get from sharedPrefs

        DatabaseHandler db = new DatabaseHandler(this);
        Freelancer fl = db.getFreelancer(userid);
        freelancerName = findViewById(R.id.nameEdit);
        freelancerDescription = findViewById(R.id.descEdit);
        saveChanges = findViewById(R.id.saveChanges);
        freelancerName.setText(fl.getName());
        freelancerDescription.setText(fl.getDescription());
        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fN = freelancerName.getText().toString();
                String fD = freelancerDescription.getText().toString();
                Freelancer f = new Freelancer(userid, fN, fD);
                db.updateFreelancer(f);
                Intent i = new Intent(getApplicationContext(), FreelancerOwnProfile.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {

        Log.d(TAG, "onClick: putang ina mo");
//        switch (view.getId()) {
//            case R.id.showDataButton:
//                Log.d("Status ", "Inside onClick !!!");
//                //sd.displayDB();
//            case R.id.certificationsLinearLayout:
//                //db.createTable();
////        try {
//                String endDate1 = "2021-12-21 10:20:05.123";
//                String endDate2 = "2022-12-25 10:20:05.123";
//                String endDate3 = "2019-07-08 10:20:05.123";
//                String endDate4 = "2022-08-01 10:20:05.123";
//                Log.d("About to Create!!","Not Created");
//
////            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
////            Date d1 = format.parse(endDate1);
////            Date d2 = format.parse(endDate2);
////            Date d3 = format.parse(endDate3);
////            Date d4 = format.parse(endDate4);
//
//
//                Certification c1 = new Certification("OCP 11 Java Programmer","https://www.aws.training/certification",endDate1,"Java,JavaScript", "Description1");
//                Certification c2 = new Certification("IBM Professional Data Science Certification","https://www.coursera.org/professional-certificates/ibm-data-science",endDate2,"Python,Java", "Description2");
//                Certification c3 = new Certification("DataCamp Certified Data Professional","https://www.coursera.org/professional-certificates/ibm-data-science",endDate3,"Java", "Description3");
//                Certification c4 = new Certification("Google Cloud Certified Data Scientist","https://www.coursera.org/professional-certificates/ibm-data-science",endDate4,"Java", "Description4");
//                ct.addCertifications(c1);
//                ct.addCertifications(c2);
//                ct.addCertifications(c3);
//                ct.addCertifications(c4);
//                //ct.showTableData();
//                Intent i = new Intent(this, CertificationPage.class);
//                startActivity(i);
//
//        }

    }




}