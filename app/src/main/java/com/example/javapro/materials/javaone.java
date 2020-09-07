package com.example.javapro.materials;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import com.example.javapro.books.textbook;
import com.example.javapro.practicaljavaone.listofprexercisesj1;
import com.example.javapro.videosjavaone.videos;
import com.example.javapro.slidesjavaone.listofslides;
import com.example.javapro.theorjavaone.listofexercisesj1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class javaone extends AppCompatActivity implements View.OnClickListener {
    Button txtbook,slide,pr,theor,video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javaone);
        txtbook = (Button) findViewById(R.id.book);
        txtbook.setOnClickListener(this);
        slide = (Button) findViewById(R.id.slide);
        slide.setOnClickListener(this);
        pr = (Button) findViewById(R.id.practical);
        pr.setOnClickListener(this);
        theor = (Button) findViewById(R.id.theor);
        theor.setOnClickListener(this);
        video = (Button) findViewById(R.id.video);
        video.setOnClickListener(this);
    }
    public void onClick(View v) {
        if (v.getId() == R.id.book) {
            Intent intent = new Intent(javaone.this, textbook.class);
            startActivity(intent);
        }
        else
        if (v.getId() == R.id.slide) {
            Intent intent = new Intent(javaone.this, listofslides.class);
            startActivity(intent);
        }
        else
        if (v.getId() == R.id.practical) {
            Intent intent = new Intent(javaone.this, listofprexercisesj1.class);
            startActivity(intent);
        }
        else
        if (v.getId() == R.id.theor) {
            Intent intent = new Intent(javaone.this, listofexercisesj1.class);
            startActivity(intent);
        }
        else
        if (v.getId() == R.id.video) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
            builder1.setCancelable(false);
            builder1.setTitle("warning");
            builder1.setMessage("To make efficient use of this feature you need internet access. \nPress ok to continue or cancel to go back.");
            builder1.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    Intent intent = new Intent(javaone.this, videos.class);
                    startActivity(intent);
                }})
                    .setNegativeButton("cancel",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            final AlertDialog alert = builder1.create();
            alert.show();
        }
}
}
