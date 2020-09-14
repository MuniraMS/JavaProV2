package com.example.javapro.materials;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import com.example.javapro.books.textbook;
import com.example.javapro.practicaljavatwo.listofprexercisesj2;
import com.example.javapro.slidesjavatwo.listofslidesj2;
import com.example.javapro.theorjavatwo.listofexercisesj2;
import com.example.javapro.videosjavatwo.videos2;
import com.example.javapro.general.courses;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class javatwo extends AppCompatActivity implements View.OnClickListener {
    Button txtbook,slide,pr,theor,video,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javatwo);
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
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
    }
    public void onClick(View v) {
        if (v.getId() == R.id.book) {
            Intent intent = new Intent(javatwo.this, textbook.class);
            startActivity(intent);
        }
        else
        if (v.getId() == R.id.slide) {
            Intent intent = new Intent(javatwo.this, listofslidesj2.class);
            startActivity(intent);
        }
        else
        if (v.getId() == R.id.practical) {
            Intent intent = new Intent(javatwo.this, listofprexercisesj2.class);
            startActivity(intent);
        }
        else
        if (v.getId() == R.id.theor) {
            Intent intent = new Intent(javatwo.this, listofexercisesj2.class);
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
                    Intent intent = new Intent(javatwo.this, videos2.class);
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
        else
        if (v.getId() == R.id.back) {
            Intent intent = new Intent(javatwo.this, courses.class);
            startActivity(intent);
        }
    }
}
