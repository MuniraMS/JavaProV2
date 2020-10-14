package com.example.javapro.slidesjavatwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import com.example.javapro.materials.javatwo;
import com.example.javapro.model.PDFs;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class listofslidesj2 extends AppCompatActivity {
    ListView lstview;
    Button back;
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

                String [] uploadslide = new String [list.size()];
                for (int i=0;i<uploadslide.length;i++){

                    uploadslide[i]=list.get(i).getName();

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploadslide);
                lstview.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}