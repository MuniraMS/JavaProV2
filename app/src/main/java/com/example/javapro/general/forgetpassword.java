package com.example.javapro.general;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class forgetpassword extends AppCompatActivity {
    EditText editEmail;
    Button send_pass;

    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        mFirebaseAuth = FirebaseAuth.getInstance();
        editEmail = (EditText) findViewById(R.id.editEmail_2);
        send_pass = (Button) findViewById(R.id.send_pass);
    }
    public void Send_Pass(View view) {

        String email = editEmail.getText().toString();
        mFirebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"A reset link has been sent to your email.",Toast.LENGTH_LONG).show();
                            finish();
                        }else {
                            Toast.makeText(getApplicationContext(),"Please enter a valid email",Toast.LENGTH_LONG).show();
                            editEmail.setText("");
                        }
                    }
                });
    }
}
