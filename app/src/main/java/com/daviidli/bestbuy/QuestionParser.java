package com.daviidli.bestbuy;

import android.util.JsonReader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Andy on 2017-03-31.
 */

public class QuestionParser {


    public ArrayList<qNode> parseJSON(String json) throws JSONException {
        if (json != null) {
            ArrayList<qNode> returnList = new ArrayList<qNode>();
            JSONObject jsonObj = new JSONObject(json);
            returnList.add(parseQuestion(jsonObj));
            return returnList;
        }
        else return null;
    }
    private qNode parseQuestion (JSONObject inputObject) throws JSONException {
        JSONArray questionList= inputObject.getJSONArray("MainQ");
        //qNode root; //= new qNode(null);
        if(questionList.length() > 0) {
            qNode root = null;
            for (int i = 0; i < questionList.length(); i++) {
                JSONObject c = questionList.getJSONObject(i);
                String qString = c.getString("question");
                JSONArray cont = inputObject.getJSONArray("continue");
                root = new qNode(qString);
                for (int j = 0; j < cont.length(); j++) {
                    JSONObject d = cont.getJSONObject(j);

                    root.addNode(parseArray(d));
                }
                root.changeString(qString);
            }
            return root;
        }
        else return null;
    }
    private qNode parseArray (JSONObject inputObject) throws JSONException{
        String question = inputObject.getString("question");
        qNode node = new qNode(question);
        JSONArray cont = inputObject.getJSONArray("continue");
        if (cont.length() != 0) {
            for (int i = 0; i < cont.length(); i++) {
                node.addNode(parseArray(cont.getJSONObject(i)));
            }
        }
        return node;
    }
}