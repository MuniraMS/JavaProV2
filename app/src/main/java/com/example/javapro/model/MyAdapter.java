package com.example.javapro.model;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javapro.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context; //context
    DatabaseReference mDatabase;
    FirebaseDatabase firebaseDatabase;
    List<PDFs> list;
    List<String> bookmarklist=new ArrayList<String>();
    boolean isemptyimag=true;
    public MyAdapter(Context context,  List<PDFs> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size(); //returns total of items in the list;
    }

    @Override
    public Object getItem(int position) {

        return list.get(position); //returns list item at the specified position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.customlist, parent, false);
        }
        PDFs ss = (PDFs) getItem(position);
        TextView textViewItemName = (TextView)
                convertView.findViewById(R.id.titleview);

        final ImageView imageView = (ImageView)
                convertView.findViewById(R.id.imgview12);
        imageView.setImageResource(list.get(position).getImg());
        textViewItemName.setText(list.get(position).getName());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                  // loadArray(context);
                  /* if(bookmarklist.isEmpty()){
                       bookmarklist.add(list.get(position).getName());
                       saveArray();
                       Toast.makeText(context.getApplicationContext(), "You've booked in successfully", Toast.LENGTH_SHORT).show();
                       notifyDataSetChanged();
                   }
                   else {
                       String lecture=list.get(position).getName();
                       deletefromdb(user.getUid(),lecture);
                   }*/
                   /* bookmarklist.add(list.get(position).getName());
                   Toast.makeText(context.getApplicationContext(), "You've booked in successfully", Toast.LENGTH_SHORT).show();
                   notifyDataSetChanged();*/
                   //saveArray();
                    loadArray(context);
                    if(bookmarklist.isEmpty()){
                        bookmarklist.add(list.get(position).getName());
                        saveArray();
                        Toast.makeText(context.getApplicationContext(), "You've booked in successfully", Toast.LENGTH_SHORT).show();
                        notifyDataSetChanged();
                    }
                    else {
                        if(bookmarklist.contains(list.get(position).getName())){
                            bookmarklist.remove(list.get(position).getName());
                            Toast.makeText(context.getApplicationContext(), "deleted", Toast.LENGTH_SHORT).show();
                            saveArray();
                        }
                        else {
                            bookmarklist.add(list.get(position).getName());
                            saveArray();
                            Toast.makeText(context.getApplicationContext(), "You've booked in successfully", Toast.LENGTH_SHORT).show();
                            notifyDataSetChanged();
                        }
                    }
                    mDatabase = FirebaseDatabase.getInstance().getReference();
                    mDatabase.child("allusers").child(user.getUid()).child("booked").setValue(bookmarklist);

                }
                else{
                    Toast.makeText(context.getApplicationContext(), "This feature for registered users only", Toast.LENGTH_SHORT).show();
                }

            }
        });


        return convertView;
    }

    public void deletefromdb (String userID, final String name) {
        mDatabase = FirebaseDatabase.getInstance().getReference().child("allusers")
                .child(userID).child("booked");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot data: snapshot.getChildren()){
                    if (data.getValue().equals(name)){
                        data.getRef().removeValue();
                        Toast.makeText(context.getApplicationContext(), "This lecture has been removed from bookmark.", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public  boolean saveArray()
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("SHARED_PREFS",context.MODE_PRIVATE);
        SharedPreferences.Editor mEdit1 = sharedPreferences.edit();
        mEdit1.putInt("Status_size", bookmarklist.size());
        for(int i=0;i<bookmarklist.size();i++)
        {
            mEdit1.remove("Status_" + i);
            mEdit1.putString("Status_" + i, bookmarklist.get(i));
        }
        return mEdit1.commit();
    }
    public  void loadArray(Context mContext)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("SHARED_PREFS",context.MODE_PRIVATE);
        bookmarklist.clear();
        int size = sharedPreferences.getInt("Status_size", 0);

        for(int i=0;i<size;i++)
        {
            bookmarklist.add(sharedPreferences.getString("Status_" + i, null));
        }

    }

}
