package com.example.datepicker2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText dateTXT;
    ImageView cal;
    private int mDate, mMonth, mYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTXT = findViewById(R.id.date);
        cal = findViewById(R.id.datepicker);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar cal = Calendar.getInstance();
                mDate = cal.get(Calendar.DAY_OF_MONTH);
                mMonth = cal.get(Calendar.MONTH);
                mYear = cal.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Black_NoTitleBar, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                        dateTXT.setText(date+"-"+month+"-"+year);

                    }
                }, mYear,mMonth,mDate);
                datePickerDialog.show();


            }
        });

    }
}