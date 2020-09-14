package com.example.javapro.practicaljavatwo;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class inheritance extends AppCompatActivity {
    TextView tv,answer;
    Button btn,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inheritance);
        tv = (TextView) findViewById(R.id.question);
        tv.setText("Create a class named 'Member' having the following members: \n Data members\n" +
                "1 - Name\n 2 - Age\n 3 - Phone number \n 4 - Address \n 5 - Salary \n It also has a method named 'PrintInfo' which prints the Information of the members. The members are 'Employee' and 'Manager' so create two classes of  'Employee' and  'Manager'");
        answer = (TextView) findViewById(R.id.answer_text);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn = (Button) findViewById(R.id.ansr);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.getVisibility()==View.GONE){
                    answer.setVisibility(View.VISIBLE); }

                else {
                    answer.setVisibility(View.GONE); }            }
        });
    }
    public void gotocompiler (View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
        builder1.setTitle("Warning");
        builder1.setMessage("Note that you need internet access to be able to use this feature."  );
        builder1.setCancelable(true);
        builder1.setPositiveButton(
                "Okay",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        goToUrl ( "https://rextester.com/l/java_online_compiler");
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
