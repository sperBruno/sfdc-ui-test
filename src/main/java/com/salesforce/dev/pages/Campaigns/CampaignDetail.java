package com.salesforce.dev.pages.campaigns;

import com.salesforce.dev.pages.base.DetailsBase;
import com.salesforce.dev.pages.MainPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.selenium.CommonOperation.getTextWebElement;

/**
 * Created by Marcelo.Vargas on 13-06-15.
 */
public class CampaignDetail extends DetailsBase{

    @FindBy(id = "cpn1_ileinner")
    private WebElement campaignName;

    @FindBy(id = "cpn2_ileinner")
    private WebElement campaignType;

    @FindBy(id = "cpn3_ileinner")
    private WebElement campaignStatus;

    @FindBy(id = "cpn5_ileinner")
    private WebElement campaignStartDate;

    @FindBy(id = "cpn6_ileinner")
    private WebElement campaignEndDate;

    @FindBy(id = "cpn8_ileinner")
    private WebElement campaignExpectedRevenue;

    @FindBy(id = "cpn9_ileinner")
    private WebElement campaignBudgetedCost;

    @FindBy(id = "cpn10_ileinner")
    private WebElement campaignActualCost;

    @FindBy(id = "cpn11_ileinner")
    private WebElement campaignExpectedResponse;

    @FindBy(id = "cpn13_ileinner")
    private WebElement campaignNumSent;

    @FindBy(id = "Parent_ileinner")
    private WebElement campaignParent;

    @Override
    public CampaignForm clickEditBtn(){
        clickEditButton();
        return new CampaignForm();
    }

    @Override
    public CampaignsHome clickDeleteBtn(boolean confirmDeletion){
        clickDeleteButton(confirmDeletion);
        return new CampaignsHome();
    }

    public MainPage gotoMainPage(){
        return new MainPage();
    }

    public Boolean validateCampaignNameFld(String value) {
        String realValue = getTextWebElement(campaignName).substring(0, campaignName.getText().length() - 17);
        return realValue.equals(value);
    }

    public Boolean validateCampaignType(String value) {
        return getTextWebElement(campaignType).equals(value);
    }

    public Boolean validateCampaignStatus(String value) {
        return getTextWebElement(campaignStatus).equals(value);
    }

    public Boolean validateCampaignStartDate(String value) {
        return getTextWebElement(campaignStartDate).equals(value);
    }

    public Boolean validateCampaignEndDate(String value) {
        return getTextWebElement(campaignEndDate).equals(value);
    }

    public Boolean validateCampaignExpectedRevenue(String value) {
        return getTextWebElement(campaignExpectedRevenue).equals("¤" + value);
    }

    public Boolean validateCampaignBudgetedCost(String value) {
        return getTextWebElement(campaignBudgetedCost).equals("¤" + value);
    }

    public Boolean validateCampaignActualCost(String value) {

        return getTextWebElement(campaignActualCost).equals("¤" + value);
    }

    public Boolean validateCampaignExpectedResponse(String value) {
        return getTextWebElement(campaignExpectedResponse).equals(value);
    }

    public Boolean validateCampaignNumSent(String value) {
        return getTextWebElement(campaignNumSent).equals(value);
    }

    public Boolean validateCampaignParent(String value) {
        return getTextWebElement(campaignParent).equals(value);
    }
}
