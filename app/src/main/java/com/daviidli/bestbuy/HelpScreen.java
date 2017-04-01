package com.daviidli.bestbuy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HelpScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);
    }

    public void SubmitInfo(View view) {
        Intent k = new Intent(HelpScreen.this, ThankYouScreen.class);
        startActivity(k);
    }

}
