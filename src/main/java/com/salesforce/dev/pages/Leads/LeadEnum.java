package com.salesforce.dev.pages.Leads;

import com.salesforce.dev.framework.JSONReader;

/**
 * Created by jimmy vargas on 6/24/2015.
 */
public class LeadEnum {
    String file;
    JSONReader jsonReader;

    /*Lead Information*/
    public String nameSalutation;
    public String firstName;
    public String lastName;
    public String company;
    public String title;
    public String leadSource;
    public String campaign;
    public String campaingLookup;
    public String industry;
    public String annualRevenue;
    public String phone;
    public String mobile;
    public String fax;
    public String email;
    public String website;
    public String leadStatus;
    public String rating;
    public String numEmployees;

    /*Address Information*/
    public String street;
    public String city;
    public String state;
    public String zipCode;
    public String country;

    /*additional information*/
    public String productInterest;
    public String SICcode;
    public String numLocations;
    public String currentGenerators;
    public String primary;

    /*Others*/
    public String description;
    public String assignRule;

    public LeadEnum(String file){
        jsonReader = new JSONReader(file);
        initializer();
    }

    private void initializer(){
        /*Lead Information*/
        nameSalutation = jsonReader.getValue("Salutation");
        firstName = jsonReader.getValue("First Name");
        lastName = jsonReader.getValue("Last Name");
        company = jsonReader.getValue("Company");
        title = jsonReader.getValue("Title");
        leadSource = jsonReader.getValue("Lead Source");
        campaign = jsonReader.getValue("Campaign");
        campaingLookup = jsonReader.getValue("Campaign LookUp");
        industry = jsonReader.getValue("Industry");
        annualRevenue = jsonReader.getValue("Annual Revenue");
        phone = jsonReader.getValue("Phone");
        mobile = jsonReader.getValue("Mobile");
        fax = jsonReader.getValue("Fax");
        email = jsonReader.getValue("Email");
        website = jsonReader.getValue("Website");
        leadStatus = jsonReader.getValue("Lead Status");
        rating = jsonReader.getValue("Rating");
        numEmployees = jsonReader.getValue("Num of Employees");

    /*Address Information*/
        street = jsonReader.getValue("Street");
        city = jsonReader.getValue("City");
        state = jsonReader.getValue("State");
        zipCode = jsonReader.getValue("Zip Code");
        country = jsonReader.getValue("Country");

    /*additional information*/
        productInterest = jsonReader.getValue("Product Interest");
        SICcode = jsonReader.getValue("SIC Code");
        numLocations = jsonReader.getValue("Number of Locations");
        currentGenerators = jsonReader.getValue("Current Generator");
        primary = jsonReader.getValue("Primary");

    /*Others*/
        description = jsonReader.getValue("Description");
        assignRule = jsonReader.getValue("Assign Rule");
    }
}
