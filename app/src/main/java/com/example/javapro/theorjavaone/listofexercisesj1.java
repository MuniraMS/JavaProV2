package com.example.javapro.theorjavaone;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import com.example.javapro.materials.javaone;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;

public class listofexercisesj1 extends AppCompatActivity {
    ListView lstview;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofexercises);
        lstview = findViewById(R.id.listview);
        String [] titles = new String [] {
                "Exercise ( 1 ) introduction", "Exercise ( 2 ) Java basics ( I )" ,
                "Exercise ( 3 ) Java basics ( II )" , "Exercise ( 4 ) conditions" ,
                "Exercise ( 5 ) loops" , "Exercise ( 6 ) methods" ,
                "Exercise ( 7 ) arrays", "Exercise ( 8 ) objects & classes" ,
                "Exercise ( 9 ) All chapters"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1,titles);
        lstview.setAdapter(adapter);
        lstview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent = new Intent (listofexercisesj1.this, J1exercise1.class);
                    startActivity(intent); }
                else
                    if (position==1){
                            Intent intent = new Intent (listofexercisesj1.this, J1exercise2.class);
                            startActivity(intent); }
                    else
                    if (position==2){
                        Intent intent = new Intent (listofexercisesj1.this, J1exercise3.class);
                        startActivity(intent); }
                    else
                    if (position==3){
                        Intent intent = new Intent (listofexercisesj1.this, J1exercise4.class);
                        startActivity(intent); }
                    else
                    if (position==4){
                        Intent intent = new Intent (listofexercisesj1.this, J1exercise5.class);
                        startActivity(intent); }
                    else
                    if (position==5){
                        Intent intent = new Intent (listofexercisesj1.this, J1exercise6.class);
                        startActivity(intent); }
                    else
                    if (position==6){
                        Intent intent = new Intent (listofexercisesj1.this, J1exercise7.class);
                        startActivity(intent); }
                    else
                    if (position==7){
                        Intent intent = new Intent (listofexercisesj1.this, J1exercise8.class);
                        startActivity(intent); }
                    else
                    if (position==8){
                        Intent intent = new Intent (listofexercisesj1.this, J1exercise9all.class);
                        startActivity(intent); }
            }

        });
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (listofexercisesj1.this, javaone.class);
                startActivity(intent);
            }
        });
    }
}