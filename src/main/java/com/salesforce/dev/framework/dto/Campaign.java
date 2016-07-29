package com.salesforce.dev.framework.dto;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import com.salesforce.dev.pages.Accounts.AccountSteps;
import com.salesforce.dev.pages.Campaigns.CampaignSteps;

import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_ACTIVE;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_ANNUAL_REVENUE;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_BILLING_STREET;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_CUSTOMER_PRIORITY;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_DESCRIPTION;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_EMPLOYEES;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_FAX;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_INDUSTRY;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_NAME;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_NUMBER;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_NUMBER_LOCATIONS;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_OWNER_SHIP;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_PHONE;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_RATING;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_SHIPPING_STREET;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_SICCODE;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_SITE;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_SLA;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_SLASERIAL_NUMBER;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_SLA_EXPIRATION_DATE;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_THICKER;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_TYPE;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_UPSELL_OPPORTUNITY;
import static com.salesforce.dev.pages.Accounts.AccountSteps.ACCOUNT_WEBSITE;
import static com.salesforce.dev.pages.Campaigns.CampaignSteps.ACTUAL_COST;
import static com.salesforce.dev.pages.Campaigns.CampaignSteps.BUDGETED_COST;
import static com.salesforce.dev.pages.Campaigns.CampaignSteps.CAMPAIGN_NAME;
import static com.salesforce.dev.pages.Campaigns.CampaignSteps.CAMPAIGN_STATUS;
import static com.salesforce.dev.pages.Campaigns.CampaignSteps.CAMPAIGN_TYPE;
import static com.salesforce.dev.pages.Campaigns.CampaignSteps.END_DATE;
import static com.salesforce.dev.pages.Campaigns.CampaignSteps.EXPECTED_RESPONSE;
import static com.salesforce.dev.pages.Campaigns.CampaignSteps.EXPECTED_REVENUE;
import static com.salesforce.dev.pages.Campaigns.CampaignSteps.NUM_SENT;
import static com.salesforce.dev.pages.Campaigns.CampaignSteps.PARENT_CAMPAIGN;
import static com.salesforce.dev.pages.Campaigns.CampaignSteps.START_DATE;

/**
 * Created by Veronica Prado on 8/27/2015.
 */
public class Campaign {
    private String campaignName;
    private String campaignType;
    private String campaignStatus;
    private String startDate;
    private String endDate;
    private String expectedRevenue;
    private String budgetedCost;
    private String actualCost;
    private String expectedResponse;
    private String numSent;
    private String parentCampaign;
    public Campaign(){}

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public void setCampaignType(String campaignType) {
        this.campaignType = campaignType;
    }

    public void setCampaignStatus(String campaignStatus) {
        this.campaignStatus = campaignStatus;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setExpectedRevenue(String expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
    }

    public void setBudgetedCost(String budgetedCost) {
        this.budgetedCost = budgetedCost;
    }

    public void setActualCost(String actualCost) {
        this.actualCost = actualCost;
    }

    public void setExpectedResponse(String expectedResponse) {
        this.expectedResponse = expectedResponse;
    }

    public void setNumSent(String numSent) {
        this.numSent = numSent;
    }

    public void setParentCampaign(String parentCampaign) {
        this.parentCampaign = parentCampaign;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public String getCampaignType() {
        return campaignType;
    }

    public String getCampaignStatus() {
        return campaignStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getExpectedRevenue() {
        return expectedRevenue;
    }

    public String getBudgetedCost() {
        return budgetedCost;
    }

    public String getActualCost() {
        return actualCost;
    }

    public String getExpectedResponse() {
        return expectedResponse;
    }

    public String getNumSent() {
        return numSent;
    }

    public String getParentCampaign() {
        return parentCampaign;
    }

    public Map<CampaignSteps, Object> convertToMap() {
        DecimalFormat decimalFormat = new DecimalFormat("¤#,###.###");
        Map<CampaignSteps, Object> mapCampaign = new HashMap<>();
        mapCampaign.put(CAMPAIGN_NAME,campaignName);
        mapCampaign.put(CAMPAIGN_STATUS, campaignStatus);
        mapCampaign.put(CAMPAIGN_TYPE, campaignType);
        mapCampaign.put(START_DATE, startDate);
        mapCampaign.put(END_DATE, endDate);
        mapCampaign.put(PARENT_CAMPAIGN, parentCampaign);
        //mapCampaign.put(BUDGETED_COST, decimalFormat.format(Integer.valueOf(budgetedCost)));
    //    mapCampaign.put(ACTUAL_COST, actualCost );
     //   mapCampaign.put(EXPECTED_RESPONSE, expectedResponse);
      //  mapCampaign.put(NUM_SENT, numSent);
       // mapCampaign.put(EXPECTED_REVENUE, expectedRevenue);
        Map<CampaignSteps, Object> mapCampaignWhitOutNull = new HashMap<>();
        mapCampaign.entrySet().stream().forEach((step) -> {
            if (!(step.getValue() == null)) {
                mapCampaignWhitOutNull.put(step.getKey(),step.getValue());
            }
        });
        return mapCampaignWhitOutNull;
    }
}
