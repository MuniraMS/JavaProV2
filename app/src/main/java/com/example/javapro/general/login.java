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
    FirebaseAuth mFirebaseAuth;
   FirebaseDatabase firebaseDatabase;

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
                startActivity(intent);            }
        });

        firebaseDatabase = FirebaseDatabase.getInstance();
        mFirebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser userde = mFirebaseAuth.getCurrentUser();

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
                    mFirebaseAuth.signInWithEmailAndPassword(uEmail,uPassword)
                     .addOnCompleteListener(login.this,new OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull Task<AuthResult> task) {
                             if (!task.isSuccessful()) {
                                 Toast.makeText(getApplicationContext(), "login failed.\nMake sure you entered valid email and password.", Toast.LENGTH_SHORT).show();
                                 email.setText("");
                                 password.setText("");
                             }
                             else {
                               // users user = snapshot.getValue(users.class);
                                // String name = user.getUsername();

                                // String name = mFirebaseAuth.getInstance().getCurrentUser().getDisplayName();
                                 Toast.makeText(getApplicationContext(), "You've logged in successfully", Toast.LENGTH_SHORT).show();
                                 Intent intent = new Intent(login.this, courses.class);
                              //  intent.putExtra("username",name);
                                 startActivity(intent);
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
    public void Forgot_Password(View view){

        Intent forgot_pass=new Intent(getApplicationContext(),forgetpassword.class);
        startActivity(forgot_pass);

    }

}
