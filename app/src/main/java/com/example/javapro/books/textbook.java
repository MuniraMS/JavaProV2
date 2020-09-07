package com.example.javapro.books;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class textbook extends AppCompatActivity {
    ListView lstview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textbook);
        lstview = findViewById(R.id.listview);
        String [] titles = new String [] {
                "1. JavaTM Programming: From Problem Analysis to Program Design (Introduction to Programming)" ,
                "2. Java. How to Program"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1,titles);
        lstview.setAdapter(adapter);
    }
}
