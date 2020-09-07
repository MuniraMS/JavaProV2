package com.example.javapro.general;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.javapro.materials.javaone;
import com.example.javapro.materials.javatwo;

public class courses extends AppCompatActivity implements View.OnClickListener{
    Button java1,java2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
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
}
