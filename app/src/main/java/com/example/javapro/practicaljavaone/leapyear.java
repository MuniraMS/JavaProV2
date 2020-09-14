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

public class leapyear extends AppCompatActivity {
    TextView tv,answer;
    Button btn,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leapyear);
        tv = (TextView) findViewById(R.id.question);
        tv.setText("write a java program to check whether the input year is leap or not");
        answer = (TextView) findViewById(R.id.answer_text);
        answer.setText("import java.util.Scanner;\n" +
                "public class leap {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "\n" +
                "    \tint year;\n" +
                "    \tScanner scan = new Scanner(System.in);\n" +
                "    \tSystem.out.println(\"Enter any Year:\");\n" +
                "    \tyear = scan.nextInt();\n" +
                "    \tscan.close();\n" +
                "        boolean isLeap = false;\n" +
                "\n" +
                "        if(year % 4 == 0)\n" +
                "        {\n" +
                "            if( year % 100 == 0)\n" +
                "            {\n" +
                "                if ( year % 400 == 0)\n" +
                "                    isLeap = true;\n" +
                "                else\n" +
                "                    isLeap = false;\n" +
                "            }\n" +
                "            else\n" +
                "                isLeap = true;\n" +
                "        }\n" +
                "        else {\n" +
                "            isLeap = false;\n" +
                "        }\n" +
                "\n" +
                "        if(isLeap==true)\n" +
                "            System.out.println(year + \" is a Leap Year.\");\n" +
                "        else\n" +
                "            System.out.println(year + \" is not a Leap Year.\");\n" +
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