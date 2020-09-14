package com.example.javapro.videosjavatwo;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class videos2 extends AppCompatActivity {
    ListView lstview;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos2);
        lstview = findViewById(R.id.listview);
        String [] titles = new String [] {
                "What IS Object Oriented Programming ?",
                "Create Your First Class in Java",
                "Constructors and constructor overloading in Java",
                "Static methods and fields in Java",
                "Passing an object to a method in Java",
                "Comparing and Copying objects in Java",
                "Inheritance and Polymorphism In Java",
                "Final Methods and Protected Members in Java",
                "Abstract class and Abstract Method in Java",
                "Interfaces in Java",
                "Exception Handling in Java",
                "ArrayList Class in Java"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1,titles);
        lstview.setAdapter(adapter);
        lstview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    goToUrl("https://youtu.be/IzjJqzX4hx0");
                }
                else
                if (position==1){
                    goToUrl("https://youtu.be/8Tx3ZkyutI4");
                }
                else
                if (position==2){
                    goToUrl("https://youtu.be/lhfX8FPG7ZE");
                }
                else
                if (position==3){
                    goToUrl("https://youtu.be/FMzuhNde4Os");
                }
                else
                if(position==4){
                    goToUrl("https://youtu.be/k2tHU_cegu4");
                }
                else
                if(position==5){
                    goToUrl("https://youtu.be/jo1SGSbgdRo");
                }
                else
                if(position==6){
                    goToUrl("https://youtu.be/IMBkkfo7z0s");
                }
                else
                if(position==7){
                    goToUrl("https://youtu.be/w99Owc11rMU");
                }
                else
                if(position==8){
                    goToUrl("https://youtu.be/BzhbsAnTX70");

                }
                else
                if (position==9){
                    goToUrl("https://youtu.be/1rNGO0113Ns");
                }
                else
                if (position==10){
                    goToUrl("https://youtu.be/8eRQ3CLsxew");
                }
                else
                if(position==11){
                    goToUrl("https://youtu.be/SV1EdFvhOCw");
                }
            }
        });
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
