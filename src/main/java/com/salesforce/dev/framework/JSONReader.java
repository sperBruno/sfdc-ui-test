package com.salesforce.dev.framework;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

/**
 * Created by jimmy vargas on 6/22/2015.
 */
public class JSONReader {

    String jsonFile;
    JSONParser parser;
    JSONObject jsonObject;

    public JSONReader(String JSONfile){

        this.jsonFile = JSONfile;
        initializer();
    }

    private void initializer(){
        parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader(jsonFile));
            jsonObject = (JSONObject)obj;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getValue(String key){
        Object value = null;

        try{
            value = jsonObject.get(key);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        if (value!=null) {
            return value.toString();
        }
        return null;
    }

}
