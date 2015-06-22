package com.salesforce.dev.pages.Opportunities;

import com.salesforce.dev.framework.JSONReader;

/**
 * Created by jimmy vargas on 6/22/2015.
 */
public class OpportunityEnum {
    String file;
    JSONReader jsonReader;

    public boolean privateChk;
    public String opportunityName;
    public String accountName;
    public String accountNameLookup;
    public String type;
    public String leadSource;
    public String amount;
    public String closeDate;
    public String nextStep;
    public String stage;
    public String probability;
    public String primaryCampaignSource;
    public String primaryCampaignSourceLookUp;

    /*Additional Information*/
    public String orderNumber;
    public String currentGenerator;
    public String trackingNumber;
    public String mainCompetitors;
    public String deliveryStatus;

    /*description*/
    public String description;

    public OpportunityEnum(String file){
        jsonReader = new JSONReader(file);

        initializer();
    }

    private void initializer(){
        privateChk = Boolean.parseBoolean(jsonReader.getValue("Private"));
        opportunityName = jsonReader.getValue("Opportunity Name");
        accountName = jsonReader.getValue("Account Name");
        accountNameLookup = jsonReader.getValue("Account Name Lookup");
        type = jsonReader.getValue("Type");
        leadSource = jsonReader.getValue("Lead Source");
        amount = jsonReader.getValue("Amount");
        closeDate = jsonReader.getValue("Close Date");
        nextStep = jsonReader.getValue("Next Step");
        stage = jsonReader.getValue("Stage");
        probability = jsonReader.getValue("Probability");
        primaryCampaignSource = jsonReader.getValue("Primary Campaign Source");
        primaryCampaignSourceLookUp = jsonReader.getValue("Primary Campaign Source Lookup");

    /*Additional Information*/
        orderNumber = jsonReader.getValue("Order Number");
        currentGenerator = jsonReader.getValue("Current Generator");
        trackingNumber = jsonReader.getValue("Tracking Number");
        mainCompetitors = jsonReader.getValue("Main Competitor");
        deliveryStatus = jsonReader.getValue("DeliveryInstallation Status");

    /*description*/
        description = jsonReader.getValue("Description");
    }

}
