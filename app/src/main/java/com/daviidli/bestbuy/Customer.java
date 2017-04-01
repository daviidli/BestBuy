package com.daviidli.bestbuy;

/**
 * Created by David on 2017-04-01.
 */

public class Customer {

    private String name;
    private int queueNumber;
    //private Departments department;

    public Customer(String name, int queueNumber/*, Departments department*/) {
        this.name = name;
        this.queueNumber = queueNumber;
        //this.department = department;
    }

    public String getName() {
        return name;
    }

    /*
    public Departments getDepartment() {
        return department;
    }
    */

    public int getQueue() {
        return queueNumber;
    }
}
