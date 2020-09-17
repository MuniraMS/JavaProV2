package com.example.javapro.books;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import android.os.Bundle;
import android.webkit.WebView;

public class book2 extends AppCompatActivity {
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book2);
        wv = (WebView) findViewById(R.id.wview);
        wv.loadUrl("https://www.amazon.com/Java-Program-Early-Objects-10th/dp/0133807800");
    }
}
