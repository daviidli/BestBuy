package com.daviidli.bestbuy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HelpScreen extends AppCompatActivity {

    public static String name = "no name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);
    }

    public void SubmitInfo(View view) {
        EditText nameText = (EditText)findViewById(R.id.Name);
        name = nameText.getText().toString();

        Intent k = new Intent(HelpScreen.this, ThankYouScreen.class);
        startActivity(k);
    }

}
