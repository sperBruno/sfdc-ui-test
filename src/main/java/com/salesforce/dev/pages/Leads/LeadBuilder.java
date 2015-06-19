package com.salesforce.dev.pages.Leads;

/**
 * Created by Jimmy Vargas on 6/15/2015.
 */
public class LeadBuilder {

    /*attributes for the lead information*/
    protected String firstNameTitle, firstName, lastName, company, title;
    protected String leadSource, campaign, industry, annualRevenue;
    protected String phone, mobile, fax, email, website, leadStatus, rating;
    protected int numEmployees;

    /*attributes for the address information*/
    protected String street, city, stateProvince, zipPostalCode,country;

    /*attributes for the additional information*/
    protected String productInterest, sicCode, currentGenerators,primary;
    protected int numberLocations;

    /*description information*/
    protected String description;

    /*optional*/
    protected boolean usingAsignRule;

    public LeadBuilder(String lastName, String company, String leadStatus){
        this.lastName = lastName;
        this.company = company;
        this.leadStatus = leadStatus;
    }

    /*attributes for the lead information*/
    public LeadBuilder setFirstNameTitle(String firstNameTitle){
        this.firstNameTitle = firstNameTitle;
        return this;
    }
    public LeadBuilder setFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public LeadBuilder setTitle(String title){
        this.title = title;
        return this;
    }
    public LeadBuilder setLeadSource(String leadSource){
        this.leadSource = leadSource;
        return this;
    }

    public LeadBuilder setCampaign(String campaign){
        this.campaign = campaign;
        return this;
    }

    public LeadBuilder setIndustry(String industry){
        this.industry = industry;
        return this;
    }

    public LeadBuilder setAnnualRevenue(String annualRevenue){
        this.annualRevenue = annualRevenue;
        return  this;
    }

    public LeadBuilder setPhone(String phone){
        this.phone = phone;
        return  this;
    }

    public LeadBuilder setMobile(String mobile){
        this.mobile = mobile;
        return this;
    }

    public LeadBuilder setFax(String fax){
        this.fax = fax;
        return this;
    }

    public LeadBuilder setEmail(String email){
        this.email = email;
        return this;
    }

    public LeadBuilder setWebsite(String website){
        this.website = website;
        return  this;
    }

    public LeadBuilder setLeadStatus(String leadStatus){
        this.leadStatus = leadStatus;
        return this;
    }

    public LeadBuilder setRating(String rating){
        this.rating = rating;
        return this;
    }

    public LeadBuilder setNumEmployees(int numEmployees){
        this.numEmployees = numEmployees;
        return this;
    }

    public LeadBuilder setStreet(String street){
        this.street = street;
        return this;
    }

    public LeadBuilder setCity(String city){
        this.city = city;
        return this;
    }
    public LeadBuilder setStateProvince(String stateProvince){
        this.stateProvince = stateProvince;
        return this;
    }

    public LeadBuilder setZipPostalCode(String zipPostalCode){
        this.zipPostalCode = zipPostalCode;
        return this;
    }
    public LeadBuilder setCountry(String country){
        this.country = country;
        return this;
    }

    public LeadBuilder setProductInterest(String productInterest){
        this.productInterest = productInterest;
        return this;
    }

    public LeadBuilder setSicCode(String sicCode){
        this.sicCode = sicCode;
        return this;
    }

    public LeadBuilder setCurrentGenerators(String currentGenerators){
        this.currentGenerators = currentGenerators;
        return this;
    }

    public LeadBuilder setPrimary(String primary){
        this.primary = primary;
        return this;
    }

    public LeadBuilder setNumberLocations(int numberLocations){
        this.numberLocations = numberLocations;
        return this;
    }

    public LeadBuilder setDescription(String description){
        this.description = description;
        return this;
    }

    public LeadBuilder setUsingAsignRule(boolean usingAsignRule){
        this.usingAsignRule = usingAsignRule;
        return this;
    }

    public LeadForm build(){
        return new LeadForm(this);
    }
}
