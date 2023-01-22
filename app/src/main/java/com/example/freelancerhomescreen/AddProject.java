package com.example.freelancerhomescreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddProject extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
EditText startDate;
EditText endDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);

        EditText startDateEditText = (EditText) findViewById(R.id.startDatePicker);
EditText endDateEditText = (EditText) findViewById(R.id.endDatePicker);
        startDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment startDatePicker = new DatePickerFragment();
                startDatePicker.show(getSupportFragmentManager(), "start date picker");
            }
        });

        endDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment startDatePicker2 = new DatePickerFragment();
                startDatePicker2.show(getSupportFragmentManager(), "start date picker");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        Log.d("Year", String.valueOf(year));
        Log.d("Month", String.valueOf(month));
        Log.d("Day Of Month", String.valueOf(dayOfMonth));
        String currentDateString = DateFormat.getTimeInstance().format(c.getTime());
startDate = (EditText)findViewById(R.id.startDatePicker);
startDate.setText(currentDateString);
    }
}