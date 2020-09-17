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
    FirebaseAuth mFirebaseAuth;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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
                                        Toast.makeText(getApplicationContext(), "registeration failed.\nMake sure you enter valid email.", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        users user = new users (uName);
                                        String userID = task.getResult().getUser().getUid();
                                        firebaseDatabase.getReference(userID).setValue(user)
                                       .addOnSuccessListener(new OnSuccessListener<Void>() {
                                           @Override
                                           public void onSuccess(Void aVoid) {
                                               Toast.makeText(getApplicationContext(), "You've signed up successfully", Toast.LENGTH_SHORT).show();
                                               Intent intent = new Intent(register.this, courses.class);
                                               intent.putExtra("username",uName);
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
