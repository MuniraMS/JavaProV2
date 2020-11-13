package com.example.javapro.slidesjavaone;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import com.example.javapro.materials.javaone;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Button;
import com.example.javapro.model.PDFs;
import com.example.javapro.model.MyAdapter;
import java.util.ArrayList;
import java.util.List;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class listofslides extends AppCompatActivity {
    ListView lstview;
    Button back;
    DatabaseReference mDatabase;
    FirebaseDatabase firebaseDatabase;
    StorageReference storageRef;
    List<PDFs> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofslides);
        firebaseDatabase = FirebaseDatabase.getInstance();
        storageRef= FirebaseStorage.getInstance().getReference();
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
                Intent intent = new Intent(listofslides.this, javaone.class);
                startActivity(intent);
            }
        });
    }
    private void ViewAllFailes() {
        mDatabase = FirebaseDatabase.getInstance().getReference().child("javaoneslide");
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
                MyAdapter adapter = new MyAdapter(getApplicationContext(), list);

                lstview.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


}
