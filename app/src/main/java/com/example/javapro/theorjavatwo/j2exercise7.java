package com.example.javapro.theorjavatwo;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class j2exercise7 extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3;
    String questions[] = { "The ability to describes a set of methods that can be called on an object, but does not provide concrete implementations for all the methods?",
            " Each interface method must be declared in all the classes that explicitly implement the interface?", "Which of the following is true about interfaces in java:\n1-All interface members must be public\n2- An instance of interface can be created.\n3- Interfaces may not specify any implementation details such as concrete method declarations and instance variables\n4- All methods declared in an interface are implicitly public abstract methods",
            "Interfaces are particularly useful for assigning common functionality to possibly unrelated classes?"};
    String answers[] = {"interface","true","1,3 and 4","true"};
    String options[] = {
            "interface"," inheritance " , " abstract",
            "true"," false " , " -",
            "1,3 and 4","1,2 and 4","2,3 and 4",
            "true","false","-"};

    int q=0;
    public static int correct=0,wrong=0,sum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j2exercise7);
        final TextView score = (TextView)findViewById(R.id.thescore);
        submitbutton=(Button) findViewById(R.id.next);
        quitbutton= (Button) findViewById(R.id.quit);
        tv = (TextView) findViewById(R.id.questions);
        radio_g= (RadioGroup) findViewById(R.id.answersgrp);
        rb1= (RadioButton) findViewById(R.id.radioButton);
        rb2= (RadioButton) findViewById(R.id.radioButton2);
        rb3= (RadioButton) findViewById(R.id.radioButton3);
        tv.setText(questions[q]);
        rb1.setText(options[0]);
        rb2.setText(options[1]);
        rb3.setText(options[2]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton check = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = check.getText().toString();
                if(ansText.equals(answers[q])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else{
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }
                q++;
                if (score != null)
                    score.setText(""+correct);
                if(q<questions.length)
                {
                    tv.setText(questions[q]);
                    rb1.setText(options[q*3]);
                    rb2.setText(options[q*3 +1]);
                    rb3.setText(options[q*3 +2]);
                }
                else
                {
                    sum = correct + wrong;

                    AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
                    builder1.setTitle("End of exercise.");
                    builder1.setMessage("You got " + correct + " out of " + sum );
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Okay",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent=new Intent(getApplicationContext(),listofexercisesj2.class);
                                    startActivity(intent);
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
                radio_g.clearCheck();

            }
        });
        correct = 0;
        wrong = 0;
        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
