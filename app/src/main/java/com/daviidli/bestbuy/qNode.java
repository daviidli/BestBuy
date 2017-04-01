package com.daviidli.bestbuy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy on 2017-03-31.
 */

public class qNode {
    private  ArrayList<qNode> qBranch;
    private String question;

    public qNode(String question) {
        this.question = question;
    }

    void changeString(String str){
        this.question = str;
    }

    void addNode(qNode node){
        qBranch.add(node);
    }
    void removeNode(qNode node){
        qBranch.remove(node);
    }

}
