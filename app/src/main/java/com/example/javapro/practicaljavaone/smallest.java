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

public class smallest extends AppCompatActivity {
    TextView tv,answer;
    Button btn,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smallest);
        tv = (TextView) findViewById(R.id.question);
        tv.setText("write a java program to find the smallest of three numbers");
        answer = (TextView) findViewById(R.id.answer_text);
        answer.setText("import java.util.Scanner;\n" +
                "public class smallest \n" +
                "{\n" +
                "    public static void main(String[] args) \n" +
                "    {\n" +
                "        int num1, num2, num3, result, temp;\n" +
                "\n" +
                "        Scanner scanner = new Scanner(System.in);\n" +
                "\n" +
                "        System.out.println(\"Enter First Number:\");\n" +
                "        num1 = scanner.nextInt();\n" +
                "        System.out.println(\"Enter Second Number:\");\n" +
                "        num2 = scanner.nextInt();\n" +
                "        System.out.println(\"Enter Third Number:\");\n" +
                "        num3 = scanner.nextInt();\n" +
                "        scanner.close();\n" +
                "        \n" +
                "        \n" +
                "        temp = num1 < num2 ? num1:num2;\n" +
                "        result = num3 < temp ? num3:temp;\n" +
                "        System.out.println(\"Smallest Number is:\"+result);\n" +
                "    }\n" +
                "}\n");
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