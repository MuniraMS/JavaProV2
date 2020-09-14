package com.example.javapro.practicaljavaone;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.materials.javaone;
import com.example.javapro.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;
import com.example.javapro.practicaljavatwo.listofprexercisesj2;
public class listofprexercisesj1 extends AppCompatActivity {
    ListView lstview;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofprexercisesj1);
        lstview = findViewById(R.id.listview);
        String [] titles = new String [] {
                "Exercise ( 1 ) Odd and Even",
                "Exercise ( 2 ) Check Leap Year",
                "Exercise ( 3 ) Check whether input character is vowel or consonant",
                "Exercise ( 4 ) Calculate power of a number",
                "Exercise ( 5 ) Check if a number is Positive or Negative",
                "Exercise ( 6 ) Find the smallest number",
                "Exercise ( 7 ) Area of Rectangle" ,
                "Exercise ( 8 ) Find the largest number in an array",
                "Exercise ( 9 ) Swap two numbers"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1,titles);
        lstview.setAdapter(adapter);
        lstview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent = new Intent (listofprexercisesj1.this, oddeven.class);
                    startActivity(intent);
                }
                else
                if (position==1){
                    Intent intent = new Intent (listofprexercisesj1.this, leapyear.class);
                    startActivity(intent);
                }
                else
                if (position==2){
                    Intent intent = new Intent (listofprexercisesj1.this, vowels.class);
                    startActivity(intent);
                }
                else
                if (position==3){
                    Intent intent = new Intent (listofprexercisesj1.this, power.class);
                    startActivity(intent);
                }
                else
                if (position==4){
                    Intent intent = new Intent (listofprexercisesj1.this, positivenegative.class);
                    startActivity(intent);
                }
                else
                if (position==5){
                    Intent intent = new Intent (listofprexercisesj1.this, smallest.class);
                    startActivity(intent);
                }
                else
                if (position==6){
                    Intent intent = new Intent (listofprexercisesj1.this, area.class);
                    startActivity(intent);
                }
                else
                if (position==7){
                    Intent intent = new Intent (listofprexercisesj1.this, largestarr.class);
                    startActivity(intent);
                }
                else
                if (position==8){
                    Intent intent = new Intent (listofprexercisesj1.this, swap.class);
                    startActivity(intent);
                }

            }
        });
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (listofprexercisesj1.this, javaone.class);
                startActivity(intent);
            }
        });
    }
}
