package com.example.javapro.practicaljavaone;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class listofprexercisesj1 extends AppCompatActivity {
    ListView lstview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofprexercisesj1);
        lstview = findViewById(R.id.listview);
        String [] titles = new String [] {
                "Exercise ( 1 ) Algorithmic Problem Solving", "Exercise ( 2 ) Java basics I" ,
                "Exercise ( 3 )Java basics II" , "Exercise ( 4 ) Conditions and Branches" ,
                "Exercise ( 5 ) Loops" , "Exercise ( 6 ) methods" ,
                "Exercise ( 7 ) arrays", "Exercise ( 8 ) 2D arrays"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1,titles);
        lstview.setAdapter(adapter);
        lstview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==1){
                    Intent intent = new Intent (listofprexercisesj1.this, j1practical1.class);
                    startActivity(intent);
                }
            }
        });
    }
}
