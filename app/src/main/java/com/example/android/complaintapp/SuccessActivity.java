package com.example.android.complaintapp;

import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ritika on 4/3/18.
 */

public class SuccessActivity extends FormcomplaintActivity  {

    public void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_success);
        TextView keyview=(TextView) findViewById(R.id.key);
        String key=getIntent().getStringExtra("fkey");
        keyview.setText("Your Complaint registeration number is"+key);

    }

}
