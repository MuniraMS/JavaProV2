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

public class SecondAdapter extends BaseAdapter {
    private Context context; //context
    DatabaseReference mDatabase;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseDatabase firebaseDatabase;
    List<PDFs> list;
    List<String> bookmarkj2=new ArrayList<String>();
    public SecondAdapter(Context context,  List<PDFs> list) {
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
     //   imageView.setImageResource(list.get(position).getImg());
        textViewItemName.setText(list.get(position).getName());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    loadJavatwo(context);
                    if (bookmarkj2.contains(list.get(position).getName())) {
                        bookmarkj2.remove(list.get(position).getName());
                        Toast.makeText(context.getApplicationContext(), "deleted j1", Toast.LENGTH_SHORT).show();
                        saveJavatwo();
                    }
                    else {
                        bookmarkj2.add(list.get(position).getName());
                        saveJavatwo();
                        Toast.makeText(context.getApplicationContext(), "You've booked in successfully j1", Toast.LENGTH_SHORT).show();
                        notifyDataSetChanged();
                    }

                    mDatabase = FirebaseDatabase.getInstance().getReference();
                    mDatabase.child("allusers").child(user.getUid()).child("JavaTwo").setValue(bookmarkj2);
                }
                else{
                    Toast.makeText(context.getApplicationContext(), "This feature for registered users only", Toast.LENGTH_SHORT).show();
                }

            }
        });


        return convertView;
    }


    public  void saveJavatwo()
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(user.getUid(),context.MODE_PRIVATE);
        SharedPreferences.Editor mEdit1 = sharedPreferences.edit();
        mEdit1.putInt("mylist_size2", bookmarkj2.size());
        for(int i=0;i<bookmarkj2.size();i++)
        {
            mEdit1.remove("mylist2" + i);
            mEdit1.putString("mylist2" + i, bookmarkj2.get(i));
        }
        mEdit1.apply();
    }
    public  void loadJavatwo(Context mContext)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(user.getUid(),context.MODE_PRIVATE);
        bookmarkj2.clear();
        int size = sharedPreferences.getInt("mylist_size2", 0);

        for(int i=0;i<size;i++)
        {
            bookmarkj2.add(sharedPreferences.getString("mylist2" + i, null));
        }
    }

}