package com.example.javapro.slidesjavaone;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class listofslides extends AppCompatActivity {
    ListView lstview;
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

    }
}
