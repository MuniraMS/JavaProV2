package com.example.javapro.theorjavaone;

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

public class J1exercise9all extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3;
    String questions[] = {
            "Programming languages do not contain punctuations.",
            "how do you identify a string variable (x)?",
            "What does (%) stand for in the code(Note: we mean in general code not in the formatted print)?",
            "Which is easier to use if you have multiple choices and different conditions?",
            "do-while loops result in how many iterations (Note: consider condition was executed n times.)?",
            "Ideally, how many tasks should a method be limited to perform ?",
            "Do we need to give arrays values as soon as we initiate them, or can we take their values from user?",
            "What is an object?"
    };
    String answers[] = {"False","String x;","remainder of a division operation","Switch",
            "n+1","only one","we can treat them as variables, and give them values how we need in the program","an instance of a class"};
    String options[] = {
            "True" , "False" , "Only sometimes",
            "String x;" , "string x;" , " x = String;",
            "remainder of a division operation", "division result","none of them",
            "Nested if" , "Switch" , "Both",
            "n" , "n-1" , "n+1",
            "only one" , "as much as we want" , "two minimum",
            "we can give them values" , "we take values from user only if we delay it" , "we can treat them as variables, and give them values how we need in the program",
            "a new class" , "an instance of a class" , "all of above"
    };
    int q=0;
    public static int correct=0,wrong=0,sum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j1exercise9all);
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
                                    Intent intent=new Intent(getApplicationContext(),listofexercisesj1.class);
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