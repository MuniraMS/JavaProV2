package com.example.javapro.model;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.javapro.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.List;
import com.sackcentury.shinebuttonlib.ShineButton;

public class MyAdapter extends BaseAdapter {
    private Context context; //context
    DatabaseReference mDatabase;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String shinebtn = "shine";
    public static final String name = "shine";
    private  boolean isshine;

    FirebaseDatabase firebaseDatabase;

    List<PDFs> list;

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
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.customlist, parent, false);
        }
        // get current item to be displayed
        PDFs ss = (PDFs) getItem(position);

        // get the TextView for item name and item description
        TextView textViewItemName = (TextView)
                convertView.findViewById(R.id.titleview);

        /*final ImageView imageView = (ImageView)
                convertView.findViewById(R.id.imgview12);*/
       final ShineButton shine = (ShineButton) convertView.findViewById(R.id.shine);

        textViewItemName.setText(list.get(position).getName());
        //imageView.setImageResource(list.get(position).getImg());


        shine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS,context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(shinebtn,shine.isChecked());
                editor.apply();
                /*if(isemptyimag) {
                    imageView.setImageResource(R.drawable.bookmarkk);
                    isemptyimag = false;
                }else {

                    imageView.setImageResource(R.drawable.bookmark);
                    isemptyimag=true;
                }*/

            }
        });
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS,context.MODE_PRIVATE);
        isshine = sharedPreferences.getBoolean(shinebtn, false);
        shine.setChecked(isshine);

        return convertView;

    }


}
