package com.example.javapro.theorjavatwo;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.materials.javatwo;
import com.example.javapro.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;
public class listofexercisesj2 extends AppCompatActivity {
    ListView lstview;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofexercisesj2);
        lstview = findViewById(R.id.listview);
        String [] titles = new String [] {
                "Exercise ( 1 ) Object & classes ", "Exercise ( 2 ) More in Object & classes" ,
                "Exercise ( 3 ) Composition" , "Exercise ( 4 ) Inheritance" ,
                "Exercise ( 5 ) Arrays & arraylist" , "Exercise ( 6 ) polymorphism" ,
                "Exercise ( 7 ) interfaces", "Exercise ( 8 ) exception handling"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1,titles);
        lstview.setAdapter(adapter);
        lstview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent = new Intent (listofexercisesj2.this, j2exercise1.class);
                    startActivity(intent); }
                else
                if (position==1){
                    Intent intent = new Intent (listofexercisesj2.this, j2exercise2.class);
                    startActivity(intent); }
                else
                if (position==2){
                    Intent intent = new Intent (listofexercisesj2.this, j2exercise3.class);
                    startActivity(intent); }
                else
                if (position==3){
                    Intent intent = new Intent (listofexercisesj2.this, j2exercise4.class);
                    startActivity(intent); }
                else
                if (position==4){
                    Intent intent = new Intent (listofexercisesj2.this, j2exercise5.class);
                    startActivity(intent); }
                else
                if (position==5){
                    Intent intent = new Intent (listofexercisesj2.this, j2exercise6.class);
                    startActivity(intent); }
               else
                if (position==6){
                    Intent intent = new Intent (listofexercisesj2.this, j2exercise7.class);
                    startActivity(intent); }
                else
                if (position==7){
                    Intent intent = new Intent (listofexercisesj2.this, j2exercise8.class);
                    startActivity(intent); }
            }

        });
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (listofexercisesj2.this, javatwo.class);
                startActivity(intent);
            }
        });
    }
}
