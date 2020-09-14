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
import android.widget.Button;
import android.widget.ListView;

public class videos extends AppCompatActivity {
    ListView lstview;
    Button back;
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
                switch(position) {

                    case 0:
                        goToUrl("https://youtu.be/FbviMTJ_vP8");
                        break;
                    case 1:
                        goToUrl("https://youtu.be/KYhy6Q914C0");
                        break;
                    case 2:
                        goToUrl("https://youtu.be/pleAjW8KJrg");
                        break;
                    case 3:
                        goToUrl("https://youtu.be/0uU-DwqpY74");
                        break;
                    case 4:
                        goToUrl("https://youtu.be/0Nb4wHNj5bE");
                        break;
                    case 5:
                        goToUrl("https://youtu.be/eAVLutX8bL0");
                        break;
                    case 6:
                        goToUrl("https://youtu.be/FG7-8gAJ-5k");
                        break;
                    case 7:
                        goToUrl("https://youtu.be/V4W5vNAP-t0");
                        break;
                    case 8:
                        goToUrl("https://youtu.be/B_hJVREXkxo");
                        break;
                    case 9:
                        goToUrl("https://youtu.be/4HOpxzgyNoo");
                        break;
                    case 10:
                        goToUrl("https://youtu.be/MI3RMJ07zdU");
                        break;
                    case 11:
                        goToUrl("https://youtu.be/qvs_hmpMsmQ");
                        break;
                    case 12:
                        goToUrl("https://youtu.be/J_-M2HuO8Ng");
                        break;
                    case 13:
                        goToUrl("https://youtu.be/KNJZqS6IwaU");
                        break;
                    case 14:
                        goToUrl("https://youtu.be/GDb7diTDq9I");
                        break;
                    case 15:
                        goToUrl("https://youtu.be/up20my-_yCY");
                        break;
                    case 16:
                        goToUrl("https://youtu.be/FdUQaSjPPiQ");
                        break;
                    case 17:
                        goToUrl("https://youtu.be/L9-AiQHBUc0");
                        break;

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
