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

public class exceptionhandling extends AppCompatActivity {
    TextView tv,answer;
    Button btn,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exceptionhandling);
        tv = (TextView) findViewById(R.id.question);
        tv.setText("Write a program take tow integer  variable , a=5 and b=0 and divide a/b. \nNote : test the program if it runs the right way or not.\nIf not ، you need to do something for your code so what you need , think!");
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
