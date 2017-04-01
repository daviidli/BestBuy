package com.daviidli.bestbuy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
        String pathName = "/path/to/file/request_help_button.png";
        Drawable d = Drawable.createFromPath(pathName);
    }

    public void Help(View view) {
        Intent k = new Intent(MainActivity.this, HelpScreen.class);
        startActivity(k);
    }

    public void website(View view) {
        Intent k = new Intent(MainActivity.this, Website.class);
        startActivity(k);
    }
}
