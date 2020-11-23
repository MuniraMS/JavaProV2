package com.example.javapro.slidesjavaone;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class bookmarkedj1 extends AppCompatActivity {
    ListView listView;
    TextView msg;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarkedj1);
        String[] lectures = new String[]{"1. Introduction", "2. Java basics (I)", "3. Java basics (II)",
        "4. Conditions","5. Loops","6. Methods","7. Arrays","8. Objects & Classes"};
        final  List<String>  list = Arrays.asList(lectures);
        msg = (TextView) findViewById(R.id.msg);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("allusers").child(user.getUid()).child("Bookmarks");
        listView = (ListView) findViewById(R.id.lstview);
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value=dataSnapshot.getValue(String.class);
                arrayList.add(value);
                arrayList.retainAll(list);
                Collections.sort(arrayList);
                arrayAdapter = new ArrayAdapter<String>(bookmarkedj1.this, android.R.layout.simple_list_item_1, arrayList);
                listView.setAdapter(arrayAdapter);
                listView.setEmptyView(msg);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}