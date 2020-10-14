package com.example.javapro.general;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.javapro.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class firstActivity extends AppCompatActivity implements View.OnClickListener {
    Button  register, login, guest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user!=null){
            Intent intent = new Intent(firstActivity.this, courses.class);
            startActivity(intent);
        }
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        guest = (Button) findViewById(R.id.guest);
        guest.setOnClickListener(this);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.register) {
            Intent intent = new Intent(firstActivity.this, register.class);
            startActivity(intent);
        }
        else
            if (v.getId() == R.id.login){
                Intent intent = new Intent(firstActivity.this, login.class);
                startActivity(intent);
            }
            else
                if (v.getId() ==R.id.guest){
                    Intent intent = new Intent(firstActivity.this, courses.class);
                    startActivity(intent);
                }
    }
}
