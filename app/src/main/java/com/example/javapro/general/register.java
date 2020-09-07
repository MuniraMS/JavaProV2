package com.example.javapro.general;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;

public class register extends AppCompatActivity implements View.OnClickListener {
    TextView user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        user = (TextView) findViewById(R.id.textView3);
        user.setOnClickListener(this);
    }
    public void onClick(View v) {
        if (v.getId() == R.id.textView3) {
            Intent intent = new Intent(register.this, login.class);
            startActivity(intent);
        }
    }
}
