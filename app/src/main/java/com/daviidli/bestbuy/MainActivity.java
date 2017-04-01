package com.daviidli.bestbuy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Help(View view) {
        Intent k = new Intent(MainActivity.this, HelpScreen.class);
        startActivity(k);
    }

    public void Chat(View view){
        Intent k = new Intent (MainActivity.this, ChatActivity.class);
        startActivity(k);
    }

    public void website(View view) {
        Intent k = new Intent(MainActivity.this, Website.class);
        startActivity(k);
    }
}
