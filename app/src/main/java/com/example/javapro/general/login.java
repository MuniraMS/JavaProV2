package com.example.javapro.general;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;

public class login extends AppCompatActivity implements View.OnClickListener {
    TextView notuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        notuser = (TextView) findViewById(R.id.textView6);
        notuser.setOnClickListener(this);
    }
    public void onClick(View v) {
        if (v.getId() == R.id.textView6) {
            Intent intent = new Intent(login.this, register.class);
            startActivity(intent);
        }
    }
}
