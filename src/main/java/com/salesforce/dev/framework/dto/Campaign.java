package com.salesforce.dev.framework.dto;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import com.salesforce.dev.pages.campaigns.CampaignSteps;

import static com.salesforce.dev.pages.campaigns.CampaignSteps.CAMPAIGN_NAME;
import static com.salesforce.dev.pages.campaigns.CampaignSteps.CAMPAIGN_STATUS;
import static com.salesforce.dev.pages.campaigns.CampaignSteps.CAMPAIGN_TYPE;
import static com.salesforce.dev.pages.campaigns.CampaignSteps.END_DATE;
import static com.salesforce.dev.pages.campaigns.CampaignSteps.PARENT_CAMPAIGN;
import static com.salesforce.dev.pages.campaigns.CampaignSteps.START_DATE;

/**
 * @author Veronica Prado
 * @since 8/27/2015.
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
