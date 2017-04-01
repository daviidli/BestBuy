package com.daviidli.bestbuy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ThankYouScreen extends AppCompatActivity {

    private FirebaseDatabase database;
    private String name = HelpScreen.name;
    private String comments = HelpScreen.selectedOption;
    public Departments department = Departments.ComputerTabletsAccessories;
    private int queue = HelpScreen.queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_thank_you_screen);

        database = FirebaseDatabase.getInstance();

        DatabaseReference databaseRefChildCustomers = database.getReference().child("customers");
        DatabaseReference databaseRefListCustomers = databaseRefChildCustomers.child("listCustomers").push();

        Customer customer = new Customer(name, comments, department);
        databaseRefListCustomers.setValue(customer);

        TextView thankYouMessage = (TextView) findViewById(R.id.thankYouMessage);
        thankYouMessage.setText("Thank you " + name + ". An employee will be with you within " +
        queue + " mins.");
    }

    public void goBack(View view) {
        Intent k = new Intent(ThankYouScreen.this, MainActivity.class);
        startActivity(k);
    }
}
