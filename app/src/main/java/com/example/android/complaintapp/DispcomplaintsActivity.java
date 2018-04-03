package com.example.android.complaintapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ritika on 6/3/18.
 */

public class DispcomplaintsActivity extends AppCompatActivity{
    ListView listViewComplaints;
    List<Complaint> complaintList;
    ComplaintList adapter;
    String key;
    private DatabaseReference databaseComp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispcomplaints);
        complaintList = new ArrayList<>();
        listViewComplaints=(ListView)findViewById(R.id.listViewcomp);

        databaseComp= FirebaseDatabase.getInstance().getReference("complaints");
        databaseComp.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                complaintList.clear();
                for(DataSnapshot compSnapshot: dataSnapshot.getChildren())
                {
                    Complaint complaint=compSnapshot.getValue(Complaint.class);


                    complaintList.add(complaint);

                }
                ComplaintList adapter = new ComplaintList(DispcomplaintsActivity.this,complaintList);
                listViewComplaints.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
            }

        });






        listViewComplaints.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //TODO get key of the clicked complaint


                Complaint c=(Complaint)  adapterView.getItemAtPosition(i);
                String key=c.getKey();
                String email=c.getEmail();
                Toast.makeText(view.getContext(),key+email,Toast.LENGTH_SHORT).show();
                Intent ServicesIntent = new Intent(DispcomplaintsActivity.this, EntertimeActivity.class);

                ServicesIntent.putExtra("fkey",key.toString());
                ServicesIntent.putExtra("emailid",email.toString());
                Intent appInfo = new Intent(getApplicationContext(), EntertimeActivity.class);

                startActivity(appInfo);

            }
        });
    }





}
