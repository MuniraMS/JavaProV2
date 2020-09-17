package com.example.javapro.general;
import com.example.javapro.model.users;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

public class login extends AppCompatActivity  {
    TextView notuser;
    EditText email,password;
    Button login;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.button3);
        notuser = (TextView) findViewById(R.id.textView6);
        notuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, register.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);            }
        });

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = firebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    moveTocourses(mFirebaseUser);
                } else {
                    Toast.makeText(getApplicationContext(), "login failed", Toast.LENGTH_SHORT).show();
                }
            }
        };
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uEmail = email.getText().toString();
                String uPassword = password.getText().toString();
                if (uEmail.isEmpty()) {
                    email.setError("Please enter your email.");
                    email.requestFocus();
                } else if (uPassword.isEmpty()) {
                    password.setError("Please enter your password");
                    password.requestFocus();
                } else
                    if(uEmail.isEmpty() && uPassword.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please enter email and password.", Toast.LENGTH_SHORT).show();
                }
                else
                if (!(uEmail.isEmpty() && uPassword.isEmpty())) {
                    firebaseAuth.signInWithEmailAndPassword(uEmail,uPassword)
                     .addOnCompleteListener(login.this,new OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull Task<AuthResult> task) {
                             if (!task.isSuccessful()) {
                                 Toast.makeText(getApplicationContext(), "login failed.\nMake sure you entered valid email and password.", Toast.LENGTH_SHORT).show();
                             }
                             else {
                                 moveTocourses(task.getResult().getUser());
                             }
                             }
                         });
                }
                else {
                    Toast.makeText(getApplicationContext(), "Problem occurred", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    private void moveTocourses(FirebaseUser mFirebaseUser) {
        firebaseDatabase.getReference().child(mFirebaseUser.getUid())
        .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
             users user = snapshot.getValue(users.class);
             String name = user.getUsername();
                Toast.makeText(getApplicationContext(), "You've logged in successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(login.this, courses.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("username",name);
                startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
