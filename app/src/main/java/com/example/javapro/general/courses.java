package com.example.javapro.general;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.javapro.materials.javaone;
import com.example.javapro.materials.javatwo;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class courses extends AppCompatActivity implements View.OnClickListener{
    Button java1,java2,signout;
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        msg = (TextView) findViewById(R.id.welcome);
        String holduser = getIntent().getStringExtra("username");
        msg.setText("Welcome " + holduser + " :D");
        signout = (Button) findViewById(R.id.logout);
        if (user!=null){
            msg.setVisibility(View.VISIBLE);
            signout.setVisibility(View.VISIBLE);
        }
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(courses.this, firstActivity.class);
                startActivity(intent);
            }
        });
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
