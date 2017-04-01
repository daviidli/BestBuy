package com.daviidli.bestbuy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.concurrent.ThreadLocalRandom;

public class HelpScreen extends AppCompatActivity {

    public static String name = "no name";
    public static String selectedOption = "no option";
    public static int queue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);

        TextView radio1 = (TextView) findViewById(R.id.radio1);
        TextView radio2 = (TextView) findViewById(R.id.radio2);
        TextView radio3 = (TextView) findViewById(R.id.radio3);

        radio1.setText("I am looking general information about certain products in this department");
        radio2.setText("I am looking for information on warranty for certain products");
        radio3.setText("I am looking for information on in-home installations");
    }

    public void SubmitInfo(View view) {
        EditText nameText = (EditText)findViewById(R.id.Name);
        name = nameText.getText().toString();

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);

        selectedOption = radioButton.getText().toString();

        queue += ThreadLocalRandom.current().nextInt(2, 6);;

        Intent k = new Intent(HelpScreen.this, ThankYouScreen.class);
        startActivity(k);
    }

}
