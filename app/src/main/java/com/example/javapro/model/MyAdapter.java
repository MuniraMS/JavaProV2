package com.example.javapro.model;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javapro.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context; //context
    DatabaseReference mDatabase;
    FirebaseDatabase firebaseDatabase;
    List<PDFs> list;
    List<String> bookmarks=new ArrayList<String>();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

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
        //imageView.setImageResource(list.get(position).getImg());
        textViewItemName.setText(list.get(position).getName());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                        loadJavaone(context);
                        if (bookmarks.contains(list.get(position).getName())) {
                            bookmarks.remove(list.get(position).getName());
                            Toast.makeText(context.getApplicationContext(), "Lecture deleted from your bookmarks.", Toast.LENGTH_SHORT).show();
                            saveJavaone();
                        }
                        else {
                            bookmarks.add(list.get(position).getName());
                            saveJavaone();
                            Toast.makeText(context.getApplicationContext(), "Lecture added to your bookmarks.", Toast.LENGTH_SHORT).show();
                            notifyDataSetChanged();
                        }

                    mDatabase = FirebaseDatabase.getInstance().getReference();
                    mDatabase.child("allusers").child(user.getUid()).child("Bookmarks").setValue(bookmarks);
                }
                else{
                    Toast.makeText(context.getApplicationContext(), "This feature for registered users only", Toast.LENGTH_SHORT).show();
                }

            }
        });


        return convertView;
    }


    public  void saveJavaone()
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(user.getUid(),context.MODE_PRIVATE);
        SharedPreferences.Editor mEdit1 = sharedPreferences.edit();
        mEdit1.putInt("mylist_size", bookmarks.size());
        for(int i=0;i<bookmarks.size();i++)
        {
            mEdit1.remove("mylist" + i);
            mEdit1.putString("mylist" + i, bookmarks.get(i));
        }
         mEdit1.apply();
    }
    public  void loadJavaone(Context mContext)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(user.getUid(),context.MODE_PRIVATE);
        bookmarks.clear();
        int size = sharedPreferences.getInt("mylist_size", 0);

        for(int i=0;i<size;i++)
        {
            bookmarks.add(sharedPreferences.getString("mylist" + i, null));
        }
    }

}
