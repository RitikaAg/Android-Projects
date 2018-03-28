package com.example.android.complaintapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ritika on 3/3/18.
 */

public class UserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        TextView Login = (TextView) findViewById(R.id.controlroom);

        // Set a click listener on that View
        Login.setOnClickListener(new View.OnClickListener()

        {

            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent LoginIntent = new Intent(UserActivity.this, LoginActivity.class);

                // Start the new activity
                startActivity(LoginIntent);
            }
        });
        TextView Services = (TextView) findViewById(R.id.user);

        // Set a click listener on that View
        Services.setOnClickListener(new View.OnClickListener()

        {

            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent ServicesIntent = new Intent(UserActivity.this, ServicesActivity.class);

                // Start the new activity
                startActivity(ServicesIntent);
            }
        });


    }
}
