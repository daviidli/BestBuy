package com.daviidli.bestbuy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChatActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat2);

    }
    public void Back(View view) {
        Intent k = new Intent(ChatActivity2.this, MainActivity.class);
        startActivity(k);
    }
    public void Next(View view) {
        Intent k = new Intent(ChatActivity2.this, ChatActivity3.class);
        startActivity(k);
    }
}
