package com.example.javapro.slidesjavaone;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import com.example.javapro.materials.javaone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;
public class listofslides extends AppCompatActivity {
    ListView lstview;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofslides);
        lstview = findViewById(R.id.listview);
        String [] titles = new String [] {
                "1. Introduction", "2. Java basics ( I )" ,
                "3. Java basics ( II )" , "4. Conditions" ,
                "5. Loops" , "6. Methods" ,
                "7. Arrays", "8. Objects & Classes"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1,titles);
        lstview.setAdapter(adapter);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listofslides.this, javaone.class);
                startActivity(intent);
            }
        });
    }
}
