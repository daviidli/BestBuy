package com.daviidli.bestbuy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;

public class ThankYouScreen extends AppCompatActivity {

    private FirebaseDatabase database;
    private int queueNumber = 0;
    private LinkedList<Customer> customerList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you_screen);

        EditText nameText = (EditText)findViewById(R.id.Name);
        String name = nameText.getText().toString();

        database = FirebaseDatabase.getInstance();
        DatabaseReference databaseRefChildQueue = database.getReference().child("queue");
        databaseRefChildQueue.setValue(queueNumber);
        DatabaseReference databaseRefChildCustomers = database.getReference().child("customers").push();

        Customer customer = new Customer(name, queueNumber++);
        databaseRefChildCustomers.setValue(customer);
        databaseRefChildQueue.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                queueNumber = dataSnapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        databaseRefChildCustomers.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> customers = dataSnapshot.getChildren();

                for (DataSnapshot customer: customers) {
                    Customer retrievedCustomer = customer.getValue(Customer.class);
                    customerList.addLast(retrievedCustomer);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });

        TextView thankYouMessage = (TextView) findViewById(R.id.thankYouMessage);
        thankYouMessage.setText("Thank you " + name + ", you are in position " + queueNumber + " of " +
                "the queue. An employee will be with you shortly. :)");
    }

    public void goBack(View view) {
        Intent k = new Intent(ThankYouScreen.this, MainActivity.class);
        startActivity(k);
    }
}
