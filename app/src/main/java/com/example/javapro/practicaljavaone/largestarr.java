package com.example.javapro.practicaljavaone;

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

public class largestarr extends AppCompatActivity {
    TextView tv,answer;
    Button btn,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_largestarr);
        tv = (TextView) findViewById(R.id.question);
        tv.setText("write a java program to Find Largest Element of an Array");
        answer = (TextView) findViewById(R.id.answer_text);
        answer.setText("public class Largest {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        double[] numArray = { 23.4, -34.5, 50.0, 33.5, 55.5, 43.7, 5.7, -66.5 };\n" +
                "        double largest = numArray[0];\n" +
                "\n" +
                "        for (double num: numArray) {\n" +
                "            if(largest < num)\n" +
                "                largest = num;\n" +
                "        }\n" +
                "\n" +
                "        System.out.format(\"Largest element = %.2f\", largest);\n" +
                "    }\n" +
                "}");
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