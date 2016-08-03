package com.salesforce.dev.framework.utils;


import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salesforce.dev.framework.dto.Account;
import com.salesforce.dev.framework.dto.Contact;
import com.salesforce.dev.framework.dto.Lead;
import com.salesforce.dev.framework.dto.Opportunity;

import static com.salesforce.dev.framework.utils.Constants.SRC_TEST_RESOURCES_JSON;

/**
 * @author jimmy vargas on 6/22/2015.
 * @author Mijhail Villarroel
 */
public class JSONMapper<T> {

    private static JSONMapper instance;


    private JSONMapper () {
    }

    public static  JSONMapper getInstance() {
        if(instance == null){
            instance = new JSONMapper();
        }
        return instance;
    }

    /**
     * Return T generic any class
     *
     * @param elementClass
     * @param nameJson Path of a json.
     * @return
     */
    public  T getGeneric(T elementClass, String nameJson) {
        final String pathFileJson = SRC_TEST_RESOURCES_JSON.concat(nameJson) ;
        try {
            ObjectMapper mapper = new ObjectMapper();
            elementClass = mapper.readValue(new File(pathFileJson), (Class<T>) elementClass.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return elementClass;
    }



}
