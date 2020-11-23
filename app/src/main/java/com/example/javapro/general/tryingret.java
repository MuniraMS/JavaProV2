package com.example.javapro.general;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class tryingret extends AppCompatActivity {
    ListView listView;
    TextView msg;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tryingret);
        msg = (TextView) findViewById(R.id.msg);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("allusers").child(user.getUid()).child("booked");
        listView = (ListView) findViewById(R.id.lstview);
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String value=dataSnapshot.getValue(String.class);
                    arrayList.add(value);
                    Collections.sort(arrayList);
                    arrayAdapter = new ArrayAdapter<String>(tryingret.this, android.R.layout.simple_list_item_1, arrayList);
                    listView.setAdapter(arrayAdapter);
                    listView.setEmptyView(msg);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    }

