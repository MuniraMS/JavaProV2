package com.example.javapro.videosjavaone;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import com.example.javapro.theorjavaone.J1exercise1;
import com.example.javapro.theorjavaone.listofexercisesj1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class videos extends AppCompatActivity {
    ListView lstview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        lstview = findViewById(R.id.listview);
        String [] titles = new String [] {
                "Introduction",
                "What is programming ?",
                "Your First Program In java",
                "Displaying Program Output",
                "Input and Variables",
                "Arithmetic Operators",
                "IF statement",
                "For Loop Statement",
                "Switch statement",
                "While Loop Statement",
                "Flag Controlled While Loop",
                "Do While Loop Statement",
                "Break and Continue statements",
                "Revision on Loops and Conditional Statements",
                "Introduction To Methods",
                "Methods With Parameters",
                "Arrays",
                "Two Dimensional Arrays"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1,titles);
        lstview.setAdapter(adapter);
        lstview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    goToUrl("https://youtu.be/FbviMTJ_vP8");
                }
                else
                if (position==1){
                    goToUrl("https://youtu.be/KYhy6Q914C0");
                }
                else
                if (position==2){
                    goToUrl("https://youtu.be/pleAjW8KJrg");
                }
                else
                if (position==3){
                    goToUrl("https://youtu.be/0uU-DwqpY74");
                }
            }
        });
    }
    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
