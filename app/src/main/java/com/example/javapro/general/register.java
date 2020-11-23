package com.example.javapro.general;
import com.example.javapro.model.users;
import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import androidx.annotation.NonNull;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

public class register extends AppCompatActivity implements View.OnClickListener {
    TextView alreadyuser;
    EditText username,email,password;
    Button register;
    AlertDialog.Builder builder1;
    FirebaseAuth mFirebaseAuth;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        builder1 = new AlertDialog.Builder(this);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.button);
        alreadyuser = (TextView) findViewById(R.id.textView3);
        alreadyuser.setOnClickListener(this);

        mFirebaseAuth= FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                final String uName = username.getText().toString();
                final String uEmail = email.getText().toString();
                final String uPassword = password.getText().toString();
                if (uName.isEmpty()) {
                    username.setError("Please enter a username.");
                    username.requestFocus();
                } else if (uEmail.isEmpty()) {
                    email.setError("Please enter an email.");
                    email.requestFocus();
                } else if (uPassword.isEmpty()) {
                    password.setError("Please enter a password");
                    password.requestFocus();
                } else if (!(uEmail.isEmpty() && uPassword.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(uEmail, uPassword)
                            .addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        builder1.setMessage("You have entered invalid email or invalid password.\nPlease make sure you entered the email like: example@exapmle.com and the password should be at least 6 character.");
                                        builder1.setTitle("Warning");
                                        builder1.setCancelable(true);
                                        builder1.setPositiveButton(
                                                "Ok",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        username.setText("");
                                                        email.setText("");
                                                        password.setText("");
                                                    }
                                                });
                                        AlertDialog alert11 = builder1.create();
                                        alert11.show();
                                    }
                                    else {
                                        users user = new users (uName);
                                        final String userID = task.getResult().getUser().getUid();
                                        firebaseDatabase.getReference("allusers").child(userID).setValue(user)
                                       .addOnSuccessListener(new OnSuccessListener<Void>() {
                                           @Override
                                           public void onSuccess(Void aVoid) {
                                               Toast.makeText(getApplicationContext(), "You've signed up successfully", Toast.LENGTH_SHORT).show();
                                               Intent intent = new Intent(register.this, courses.class);
                                               startActivity(intent);
                                           }

                                       });
                                    }
                                }
                            });
                }
                else {
                    Toast.makeText(getApplicationContext(), "a problem occured", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void onClick(View v) {
        if (v.getId() == R.id.textView3) {
            Intent intent = new Intent(register.this, login.class);
            startActivity(intent);
        }
    }
}
