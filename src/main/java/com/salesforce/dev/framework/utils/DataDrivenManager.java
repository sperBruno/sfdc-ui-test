package com.salesforce.dev.framework.utils;

/**
 * Created by Walter Mercado on 6/22/2015.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salesforce.dev.framework.dto.Account;
import com.salesforce.dev.framework.dto.Campaign;
import com.salesforce.dev.framework.dto.Chatter;
import com.salesforce.dev.framework.dto.ViewSalesForce;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static com.salesforce.dev.framework.utils.Constants.SRC_TEST_RESOURCES_JSON;

public class DataDrivenManager {
    private JSONParser parser;
    private static final Logger LOGGER = Logger.getLogger(DataDrivenManager.class.getName());

    public DataDrivenManager(){
    }

    public Iterator<Account[]> getAccountsDD(String nameJson){

        Collection<Account[]> accountsArray =new ArrayList<Account[]>();
        try {
            parser = new JSONParser();
            final String pathFileJson = SRC_TEST_RESOURCES_JSON.concat(nameJson) ;
            Object jsonObject = parser.parse(new FileReader(pathFileJson));
            JSONArray jsonArray = (JSONArray) jsonObject;

            ObjectMapper objectMapper = new ObjectMapper();

            List<Account> navigation = objectMapper.readValue(jsonArray.toJSONString(),
                    objectMapper.getTypeFactory().constructCollectionType(
                            List.class, Account.class));

            for (int i = 0 ; i< navigation.size(); i++){
                Account account = (Account)navigation.get(i);
                accountsArray.add(new Account[]{account});
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return accountsArray.iterator();
    }

    public Iterator<ViewSalesForce[]> getDataView(String fileJson){

        Collection<ViewSalesForce[]> viewSalesForcesArray =new ArrayList<ViewSalesForce[]>();
        try {
            parser = new JSONParser();
            final String pathFileJson = SRC_TEST_RESOURCES_JSON + fileJson;
            Object jsonObject = parser.parse(new FileReader(pathFileJson));
            JSONArray jsonArray = (JSONArray) jsonObject;

            ObjectMapper objectMapper = new ObjectMapper();

            List<ViewSalesForce> navigation = objectMapper.readValue(jsonArray.toJSONString(),
                    objectMapper.getTypeFactory().constructCollectionType(
                            List.class, ViewSalesForce.class));

                        for (ViewSalesForce view : navigation) {
                viewSalesForcesArray.add(new ViewSalesForce[]{view});
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.error("Error on data view from Json file:", e);
        } catch (ParseException e) {
            LOGGER.error("Error on data view from Json file:", e);
        }
        return viewSalesForcesArray.iterator();
    }


    public Iterator<Campaign[]> getCampaign(String fileJson) {

        Collection<Campaign[]> campaignsArray = new ArrayList<Campaign[]>();
        try {
            parser = new JSONParser();
            final String pathFileJson = SRC_TEST_RESOURCES_JSON.concat(fileJson);
            Object jsonObject = parser.parse(new FileReader(pathFileJson));
            JSONArray jsonArray = (JSONArray) jsonObject;
            ObjectMapper objectMapper = new ObjectMapper();
            List<Campaign> navigation = objectMapper.readValue(jsonArray.toJSONString(),
                    objectMapper.getTypeFactory().constructCollectionType(
                            List.class, Campaign.class));

            for (int i = 0; i < navigation.size(); i++) {
                Campaign campaign = (Campaign) navigation.get(i);
                campaignsArray.add(new Campaign[]{campaign});
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.error("Error on data for Campaign from Json file:", e);
        } catch (ParseException e) {
            LOGGER.error("Error on data for Campaign from Json file:", e);
        }
        return campaignsArray.iterator();
    }

    /*Returns chatter properties
    * @param fileJson
    * @return Iterator<chatter[]>
    * */
    public Iterator<Chatter[]> getChatter(String fileJson) {

        Collection<Chatter[]> chattersArray = new ArrayList<Chatter[]>();
        try {
            parser = new JSONParser();
            final String pathFileJson = SRC_TEST_RESOURCES_JSON.concat(fileJson);
            Object jsonObject = parser.parse(new FileReader(pathFileJson));
            JSONArray jsonArray = (JSONArray) jsonObject;
            ObjectMapper objectMapper = new ObjectMapper();
            List<Chatter> navigation = objectMapper.readValue(jsonArray.toJSONString(),
                    objectMapper.getTypeFactory().constructCollectionType(
                            List.class, Chatter.class));

            for (Chatter chatter : navigation)
                chattersArray.add(new Chatter[]{chatter});

        } catch (FileNotFoundException e) {
            LOGGER.error("File not found for chatter - Json file:", e);;
        } catch (IOException e) {
            LOGGER.error("Error on data for chatter from Json file:", e);
        } catch (ParseException e) {
            LOGGER.error( "Error on data for chatter:", e);
        }
        return chattersArray.iterator();
    }
}
