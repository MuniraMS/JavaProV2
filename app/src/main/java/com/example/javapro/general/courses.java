package com.example.javapro.general;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.javapro.materials.javaone;
import com.example.javapro.materials.javatwo;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class courses extends AppCompatActivity implements View.OnClickListener{
    Button java1,java2,signout;
    TextView msg;
    DatabaseReference mUserDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        msg = (TextView) findViewById(R.id.welcome);
        signout = (Button) findViewById(R.id.logout);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(courses.this, firstActivity.class);
                startActivity(intent);
            }
        });
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user!=null){
       String current_uid = user.getUid();
        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("allusers")
                .child(current_uid);
        mUserDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                 String name = dataSnapshot.child("username").getValue().toString();
                msg.setText("Welcome " + name + " :D");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

            msg.setVisibility(View.VISIBLE);
            signout.setVisibility(View.VISIBLE);
        }
        java1 = (Button) findViewById(R.id.jv1);
        java1.setOnClickListener(this);
        java2 = (Button) findViewById(R.id.jv2);
        java2.setOnClickListener(this);
    }
    public void onClick(View v) {
        if (v.getId() == R.id.jv1) {
            Intent intent = new Intent(courses.this, javaone.class);
            startActivity(intent);
        }
        else
            if (v.getId() == R.id.jv2){
                Intent intent = new Intent(courses.this,javatwo.class);
                startActivity(intent);
            }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(courses.this, firstActivity.class);
        startActivity(intent);
        finish();
    }

}
