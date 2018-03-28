package com.example.android.complaintapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by ritika on 9/3/18.
 */

public class EntertimeActivity extends AppCompatActivity {
    private Calendar myCalendar;
    private TextView edittext;
    private TextView edittext1;
    private Calendar myClock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertime);
         myCalendar = Calendar.getInstance();

        edittext= (TextView) findViewById(R.id.date);
        edittext1=(TextView) findViewById(R.id.time);
       final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
      /* myClock= Calendar.getInstance();
       final TimePickerDialog.OnTimeSetListener time=new TimePickerDialog.OnTimeSetListener() {
           @Override
           public void onTimeSet(TimePicker timePicker, int i, int i1) {
               myClock.set(Calendar.HOUR_OF_DAY,i);
               myClock.set(Calendar.MINUTE,i1);
               updateLabel1();

           }
       };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(EntertimeActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        edittext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(EntertimeActivity.this,time,myClock.get(Calendar.HOUR_OF_DAY),myClock.get(Calendar.MINUTE),true).show();
            }
        });*/
    }
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalendar.getTime()));
    }
   /* private void updateLabel1{
        String myFormat="HH/MM";
        SimpleTimeZone t=new SimpleTimeZone(myFormat,Locale.US);
    }*/
}
