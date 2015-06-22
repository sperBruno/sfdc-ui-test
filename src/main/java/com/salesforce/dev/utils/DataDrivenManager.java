package com.salesforce.dev.utils;

/**
 * Created by Walter Mercado on 6/22/2015.
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataDrivenManager {
    private JSONParser parser;
    private String[][] properties;

    public DataDrivenManager(){
        JSONParser parser = new JSONParser();
    }

    public Object[][] getDataDrivenAccount() {
        try {
            parser = new JSONParser();
            Object obj = parser.parse(new FileReader("dataDriven/accounts.json"));

            JSONArray jsonObject = (JSONArray) obj;
            properties = new String[jsonObject.size()][2];

            for (int i=0; i<properties.length; i++) {
                JSONObject account = (JSONObject) jsonObject.get(i);
                properties[i][0]= (String) account.get("accountName");
                properties[i][1]= (String) account.get("accountDesc");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
