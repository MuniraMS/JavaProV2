package com.example.javapro.slidesjavatwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import com.example.javapro.materials.javatwo;
import com.example.javapro.model.MyAdapter;
import com.example.javapro.model.PDFs;
import com.example.javapro.model.SecondAdapter;
import com.example.javapro.slidesjavaone.bookmarkedj1;
import com.example.javapro.slidesjavaone.listofslides;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class listofslidesj2 extends AppCompatActivity {
    ListView lstview;
    Button back,bookmark;
    DatabaseReference mDatabase;
    FirebaseDatabase firebaseDatabase;
    List<PDFs> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofslidesj2);
        lstview = findViewById(R.id.listview);
        lstview = (ListView) findViewById(R.id.listview);
        list = new ArrayList<>();
        ViewAllFailes();
        lstview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PDFs pdf= list.get(i);

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdf.getUrl()));
                startActivity(browserIntent);

            }
        });
        bookmark = (Button) findViewById(R.id.bookmark);
        bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user==null){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
                    builder1.setCancelable(false);
                    builder1.setTitle("warning");
                    builder1.setMessage("This feature is limited to registered users only.\nTo be able to use it please sign up or login.");
                    builder1.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {

                        }});
                    final AlertDialog alert = builder1.create();
                    alert.show();
                }
                else {
                    Intent intent = new Intent(listofslidesj2.this, bookmarkedj2.class);
                    startActivity(intent);
                }
            }
        });
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listofslidesj2.this, javatwo.class);
                startActivity(intent);
            }
        });
    }
    private void ViewAllFailes() {
        mDatabase = FirebaseDatabase.getInstance().getReference().child("javatwoslide");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds:snapshot.getChildren()){

                    PDFs slides=ds.getValue(PDFs.class);
                    list.add(slides);

                }

               /* String [] uploadslide = new String [list.size()];
                for (int i=0;i<uploadslide.length;i++){

                    uploadslide[i]=list.get(i).getName();

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploadslide);
                lstview.setAdapter(adapter);*/
                SecondAdapter adapter = new SecondAdapter(getApplicationContext(), list);

                lstview.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}