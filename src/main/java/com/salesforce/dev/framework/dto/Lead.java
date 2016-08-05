package com.salesforce.dev.framework.dto;

import com.salesforce.dev.framework.utils.JSONMapper;

/**
 * @author jimmy vargas
 * @since 6/24/2015.
 */
public class Lead {

    String file;

    JSONMapper jsonMapper;

    /*Lead Information*/
    private String nameSalutation;
    private String firstName;
    private String lastName;
    private String company;
    private String title;
    private String leadSource;
    private String campaign;
    private String campaignLookup;
    private String industry;
    private String annualRevenue;
    private String phone;
    private String mobile;
    private String fax;
    private String email;
    private String website;
    private String leadStatus;
    private String rating;
    private String numEmployees;

    /*Address Information*/
    private String street;
    private String city;
    private String stateProvince;
    private String zipCode;
    private String country;

    /*additional information*/
    private String productInterest;
    private String SICCode;
    private String numberLocations;
    private String currentGenerators;
    private String primary;

    /*Others*/
    private String description;
    private String assignRule;
}
