package com.example.android.complaintapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread=new Thread()
        {
            @Override
            public void run()
            {
                try{
                    sleep(9*100);
                    Intent i=new Intent(getApplicationContext(),UserActivity.class);
                    startActivity(i);

                }
                catch(Exception ex)
                {

                }
            }
        };
        thread.start();

    }
}
