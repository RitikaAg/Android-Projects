package com.example.android.complaintapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by ritika on 9/3/18.
 */

public class EntertimeActivity  extends DispcomplaintsActivity {
    private AutoCompleteTextView timeView;
    private String time;

    private Button enter;
    private DatabaseReference mDatabase;


// ...
private void sendEmail(String t,String em) {
    //Getting content for email
     /*email = em;
     subject = "complaint";
    message = t;*/

    //Creating SendMail object
    SendMail sm = new SendMail(this, em, "complaint", t);

    //Executing sendmail to send email
    sm.execute();
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertime);
        timeView = (AutoCompleteTextView) findViewById(R.id.time);
        time = timeView.getText().toString();
        enter = (Button) findViewById(R.id.button2);
        //TODO fix this

            String key = getIntent().getStringExtra("fkey");
            final String email = getIntent().getStringExtra("emailid");





        mDatabase = FirebaseDatabase.getInstance().getReference().child("complaints");

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                timeView = (AutoCompleteTextView) findViewById(R.id.time);
                time = timeView.getText().toString();
               // mDatabase.child("complaints").child(key).child("res").setValue(time);
                String key = getIntent().getStringExtra("fkey");
                 String email = getIntent().getStringExtra("emailid");

               //TODO fix this
                sendEmail("Your rectification time is:"+time+"\n"+"Your complaint id is:"+key+"\n"+"Please copy this complaint id when your complaint is rectified,and paste it in the, give your complaint status form",email);
                Toast.makeText(view.getContext(), "Time Updated", Toast.LENGTH_SHORT).show();

            }
        });


    }


}
   /* private Calendar myCalendar;
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

        };*/
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

   /* private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalendar.getTime()));*/

   /* private void updateLabel1{
        String myFormat="HH/MM";
        SimpleTimeZone t=new SimpleTimeZone(myFormat,Locale.US);
    }*/


