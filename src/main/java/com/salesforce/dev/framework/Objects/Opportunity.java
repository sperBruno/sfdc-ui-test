package com.salesforce.dev.framework.Objects;

import com.salesforce.dev.framework.JSONMapper;

/**
 * Created by jimmy vargas on 6/22/2015.
 */
public class Opportunity {
    String file;
    JSONMapper jsonMapper;

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

    public Opportunity(){

    }


}
