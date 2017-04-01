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
            ArrayList<qNode> questionsList = new ArrayList<qNode>();
            JSONObject jsonObj = new JSONObject(json);
            questionsList.add(parseQuestion(jsonObj));
            return questionsList;
        }
        else return null;
    }
    private qNode parseQuestion (JSONObject inputObject) throws JSONException {
        JSONArray MainQuestions = inputObject.getJSONArray("MainQ");
        qNode root = new qNode("");
        for (int i = 0; i < MainQuestions.length(); i++) {
            JSONObject c = MainQuestions.getJSONObject(i);
            String qString = c.getString("question");
            root.changeString(qString);
            JSONArray cont = inputObject.getJSONArray("continue");
            for (int j = 0; j<cont.length();i++){
                JSONObject d = cont.getJSONObject(i);
                root.addNode(parseQuestion(d));
            }

        }
        return root;
    }
    private ArrayList<qNode> parseArray (){


    }
}