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

public class vowels extends AppCompatActivity {
    TextView tv,answer;
    Button btn,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vowels);
        tv = (TextView) findViewById(R.id.question);
        tv.setText("write a java program to check a character is Vowel or Consonant ");
        answer = (TextView) findViewById(R.id.answer_text);
        answer.setText("import java.util.Scanner;\n" +
                "class JavaExample\n" +
                "{\n" +
                "   public static void main(String[ ] arg)\n" +
                "   {\n" +
                "\tboolean isVowel=false;;\n" +
                "\tScanner scanner=new Scanner(System.in);\n" +
                "\tSystem.out.println(\"Enter a character : \");\n" +
                "\tchar ch=scanner.next().charAt(0); \n" +
                "\tscanner.close();\n" +
                "\tswitch(ch)\n" +
                "\t{\n" +
                "\t   case 'a' :\n" +
                "\t   case 'e' :\n" +
                "    \t   case 'i' :\n" +
                "\t   case 'o' :\n" +
                "\t   case 'u' :\n" +
                "\t   case 'A' :\n" +
                "\t   case 'E' :\n" +
                "\t   case 'I' :\n" +
                "\t   case 'O' :\n" +
                "\t   case 'U' : isVowel = true;\n" +
                "\t}\n" +
                "\tif(isVowel == true) {\n" +
                "\t   System.out.println(ch+\" is  a Vowel\");\n" +
                "\t}\n" +
                "\telse {\n" +
                "\t   if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z'))\n" +
                "\t\tSystem.out.println(ch+\" is a Consonant\");\n" +
                "\t   else\n" +
                "\t\tSystem.out.println(\"Input is not an alphabet\");\t\t\n" +
                "        }\n" +
                "   }\n" +
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