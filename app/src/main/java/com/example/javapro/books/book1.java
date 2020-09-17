package com.example.javapro.books;

import androidx.appcompat.app.AppCompatActivity;
import com.example.javapro.R;
import android.os.Bundle;
import android.webkit.WebView;

public class book1 extends AppCompatActivity {
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book1);
        wv = (WebView) findViewById(R.id.wview);
        wv.loadUrl("https://www.amazon.com/JavaTM-Programming-Problem-Analysis-Introduction-ebook-dp-B00B7JUP1M/dp/B00B7JUP1M/ref=mt_other?_encoding=UTF8&me=&qid=");
    }
}
