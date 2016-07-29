package com.salesforce.dev.pages.opportunities;

/**
 * Created by Jimmy Vargas on 6/14/2015.
 */
public class OpportunityBuilder {

    protected String opName,accountName,type;
    protected boolean isPrivate;
    protected String leadSource, orderNumber, currentGenerator, trackingNumber;
    protected String opDescription,amount,expectedRevenue;
    //This should be the format for the close data month/day/year e.g 12/25/2015
    protected String closeDate;
    protected String nextStep,stage,probability,primaryCampaignSource,mainCompetidors;
    protected String deliveryInstallationStatus;


    public OpportunityBuilder(String opportunityName, String closeDate,String stage){
        this.opName = opportunityName;
        this.closeDate = closeDate;
        this.stage = stage;
    }

    public OpportunityBuilder setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
        return this;
    }

    public OpportunityBuilder setAccountName(String accountName){
        this.accountName = accountName;
        return this;
    }

    public OpportunityBuilder setType(String type){
        this.type = type;
        return this;
    }

    public OpportunityBuilder setLeadSource(String leadSource) {
        this.leadSource = leadSource;
        return this;
    }

    public OpportunityBuilder setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public OpportunityBuilder setCurrentGenerator(String currentGenerator) {
        this.currentGenerator = currentGenerator;
        return this;
    }

    public OpportunityBuilder setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        return this;
    }

    public OpportunityBuilder setOpDescription(String opDescription) {
        this.opDescription = opDescription;
        return this;
    }

    public OpportunityBuilder setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public OpportunityBuilder setExpectedRevenue(String expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
        return this;
    }

    public OpportunityBuilder setNextStep(String nextStep) {
        this.nextStep = nextStep;
        return this;
    }

    public OpportunityBuilder setProbability(String probability) {
        this.probability = probability;
        return  this;
    }

    public OpportunityBuilder setPrimaryCampaignSource(String primaryCampaignSource) {
        this.primaryCampaignSource = primaryCampaignSource;
        return this;
    }

    public OpportunityBuilder setMainCompetitors(String mainCompetitors) {
        this.mainCompetidors = mainCompetitors;
        return this;
    }

    public OpportunityBuilder setDeliveryInstallationStatus(String deliveryInsallationStatus) {
        this.deliveryInstallationStatus = deliveryInsallationStatus;
        return this;
    }

    public OpportunityForm build(){
        return new OpportunityForm(this);
    }



}
