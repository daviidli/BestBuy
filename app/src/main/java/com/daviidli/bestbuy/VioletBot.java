package com.daviidli.bestbuy;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Andy on 2017-03-31.
 */

public class VioletBot {
    public ArrayList<qNode> questions;

    public static void main(String[] args) {

        (new VioletBot()).parse();
    }

    /**
     * Parse JSON library file and print data to console
     */
    private void parse() {
        try {
            InputStream is = new FileInputStream("./questions.json");
            String jsonData =  readSource(is);
            QuestionParser queParse = new QuestionParser();
            queParse.parseJSON(jsonData);
        } catch (IOException e) {
            System.out.println("Error reading file...");
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("JSON error...");
            e.printStackTrace();
        }
    }

    /**
     * Read source data from input stream as string
     *
     * @param is  input stream connected to source data
     * @return  source data as string
     * @throws IOException  when error occurs reading data from file
     */
    private String readSource(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;

        while((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }

        br.close();

        return sb.toString();
    }

}
