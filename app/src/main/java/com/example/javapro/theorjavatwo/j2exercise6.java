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

public class j2exercise6 extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3;
    String questions[] = { "The ability to define more than one function with the same name is called?",
            "Which of the following is FALSE about abstract classes in Java?",
            "Polymorphism is features of object oriented programming?",
            "Which among the following best describes polymorphism?" };
    String answers[] = {"polymorphism","a class can inherit from multiple abstract classes","true","It is the ability for a message/data to be processed in more than one form"};
    String options[] = {
           "abstraction" , "polymorphism" , "inheritance",
            "a class can inherit from multiple abstract classes","Abstract classes can have constructors"," A class can be made abstract without any abstract method",
            "true","false","-",
            "It is the ability for many messages/data to be processed in one way", "It is the ability for undefined message/data to be processed in at least one way","It is the ability for a message/data to be processed in more than one form"
           };

    int q=0;
    public static int correct=0,wrong=0,sum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j2exercise6);
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
