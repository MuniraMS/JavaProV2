package com.example.javapro.practicaljavatwo;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import com.example.javapro.materials.javatwo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;

public class listofprexercisesj2 extends AppCompatActivity {
    ListView lstview;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofprexercisesj2);
        lstview = findViewById(R.id.listview);
        String [] titles = new String [] {
                "Exercise ( 1 ) object & classes ", "Exercise ( 2 ) more in object & classes" ,
                "Exercise ( 3 )composition" , "Exercise ( 4 ) inheritance" ,
                "Exercise ( 5 ) arrays & arraylist " , "Exercise ( 6 ) polymorphism" ,
                "Exercise ( 7 ) interface", "Exercise ( 8 ) exception handling"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1,titles);
        lstview.setAdapter(adapter);
        lstview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent = new Intent (listofprexercisesj2.this, objclass.class);
                    startActivity(intent);
                }
                else
                if (position==1){
                    Intent intent = new Intent (listofprexercisesj2.this, moreobjclass.class);
                    startActivity(intent);
                }
                else
                if (position==2){
                    Intent intent = new Intent (listofprexercisesj2.this, composition.class);
                    startActivity(intent);
                }
                else
                if (position==3){
                    Intent intent = new Intent (listofprexercisesj2.this, inheritance.class);
                    startActivity(intent);
                }
                else
                if (position==4){
                    Intent intent = new Intent (listofprexercisesj2.this, arrayp.class);
                    startActivity(intent);
                }
                else
                if (position==5){
                    Intent intent = new Intent (listofprexercisesj2.this, polymorphism.class);
                    startActivity(intent);
                }
                else
                if (position==6){
                    Intent intent = new Intent (listofprexercisesj2.this, interfaces.class);
                    startActivity(intent);
                }
                else
                if (position==7){
                    Intent intent = new Intent (listofprexercisesj2.this, exceptionhandling.class);
                    startActivity(intent);
                }
            }
        });
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (listofprexercisesj2.this, javatwo.class);
                startActivity(intent);
            }
        });
    }
}
