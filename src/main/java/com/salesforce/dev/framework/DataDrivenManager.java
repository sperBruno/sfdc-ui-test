package com.salesforce.dev.framework;

/**
 * Created by Walter Mercado on 6/22/2015.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.salesforce.dev.framework.Objects.Account;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataDrivenManager {
    private JSONParser parser;

    public DataDrivenManager(){
    }

    public Iterator<Account[]> getAccountsDD(){

        Collection<Account[]> accountsArray =new ArrayList<Account[]>();
        try {
            parser = new JSONParser();
            Object jsonObject = parser.parse(new FileReader("src\\test\\resources\\AccountsBaseDD.json"));
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

}
