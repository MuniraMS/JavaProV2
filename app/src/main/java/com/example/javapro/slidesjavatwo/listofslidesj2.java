package com.example.javapro.slidesjavatwo;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import com.example.javapro.materials.javatwo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class listofslidesj2 extends AppCompatActivity {
    ListView lstview;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofslidesj2);
        lstview = findViewById(R.id.listview);
        String [] titles = new String [] {
                "1. Object & classes ", "2. More in Object & classes" ,
                "3. Composition" , "4. Inheritance" ,
                "5. Arrays & Arraylists" , "6. Polymorphism" ,
                "7. Interfaces", "8. Exception handling"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1,titles);
        lstview.setAdapter(adapter);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listofslidesj2.this, javatwo.class);
                startActivity(intent);
            }
        });
    }
}