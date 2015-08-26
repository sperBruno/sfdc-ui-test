package com.salesforce.dev.pages.Opportunities;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.DetailsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Jimmy Vargas on 6/10/2015.
 */
public class OpportunityDetail extends DetailsBase {

    @FindBy(id = "opp1_ileinner")
    @CacheLookup
    WebElement  opOwner;

    @FindBy(id = "opp2_chkbox")
    @CacheLookup
    WebElement privateCheckBox;

    @FindBy(id = "opp3_ileinner")
    @CacheLookup
    WebElement opName;

    @FindBy(id = "opp4_ileinner")
    @CacheLookup
    WebElement accountName;

    @FindBy(id = "opp5_ileinner")
    @CacheLookup
    WebElement type;

    @FindBy(id = "opp6_ileinner")
    @CacheLookup
    WebElement leadSource;

    @FindBy(xpath = "//td[contains(.,'Order Number')]/following::div")
    @CacheLookup
    WebElement orderNumber;

    @FindBy(xpath = "//td[contains(.,'Current Generator')]/following::div")
    @CacheLookup
    WebElement currentGenerator;

    @FindBy(xpath = "//td[contains(.,'Tracking Number')]/following::div")
    @CacheLookup
    WebElement trackingNumber;

    @FindBy(id = "CreatedBy_ileinner")
    @CacheLookup
    WebElement createdBy;

    @FindBy(id = "opp14_ileinner")
    @CacheLookup
    WebElement opDescription;

    @FindBy(id = "opp7_ileinner")
    @CacheLookup
    WebElement amount;

    @FindBy(id = "opp8_ileinner")
    @CacheLookup
    WebElement expectedRevenue;

    @FindBy(id = "opp9_ileinner")
    @CacheLookup
    WebElement closeDate;

    @FindBy(id = "opp10_ileinner")
    @CacheLookup
    WebElement nextStep;

    @FindBy(id = "opp11_ileinner")
    @CacheLookup
    WebElement stage;

    @FindBy(id = "opp12_ileinner")
    @CacheLookup
    WebElement probability;

    @FindBy(id = "opp17_ileinner")
    @CacheLookup
    WebElement primaryCampaignSource;

    @FindBy(xpath = "//td[contains(.,'Main Competitor')]/following::div")
    @CacheLookup
    WebElement mainCompetitors;

    @FindBy(xpath = "//td[contains(.,'Delivery/Installation Status')]/following::div")
    @CacheLookup
    WebElement deliveryInstallationStatus;

    @FindBy(id = "LastModifiedBy_ileinner")
    @CacheLookup
    WebElement lastModifiedBy;


     public OpportunityDetail(WebDriver driver){
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(super.driver,this);
    }

    /**
     * Returns the Opportunity Form
     *
     * @author: Jimmy Vargas
     * @since: 06/13/2015
     * */
    public OpportunityForm clickEditBtn(){
        super.clickEditButton();
        return new OpportunityForm(driver);
    }

    /**
     * Deletes the Opportunity returning to the Opportunities Home
     *
     * @author: Jimmy Vargas
     * @since: 06/13/2015
     * */
    @Override
    protected OpportunitiesHome clickDeleteBtn(boolean confirmDeletion){
        super.clickDeleteButton(confirmDeletion);
        return new OpportunitiesHome(driver);
    }

    /**
     * Deletes the opportunity from its own page
     *
     * @author: Jimmy Vargas
     * @since: 06/13/2015
     * */
    public OpportunitiesHome deleteOpportunity(){
        return clickDeleteBtn(true);
    }

    public String getOpOwner(){
        return opOwner.getText();
    }


    public boolean isPrivate() {
        return privateCheckBox.getAttribute("title").equalsIgnoreCase("Checked");
    }

    public String getOpName(){
        return opName.getText();
    }

    public String getAccountName(){
        return accountName.getText();
    }

    public String getType(){
        return type.getText();
    }

    public String getLeadSource() {
        return leadSource.getText();
    }

    public String getOrderNumber() {
        return orderNumber.getText();
    }

    public String getCurrentGenerator() {
        return currentGenerator.getText();
    }

    public String getTrackingNumber() {
        return trackingNumber.getText();
    }

    public String getCreateBy() {
        return createdBy.getText();
    }

    public String getOpDescription() {
        return opDescription.getText();
    }

    public String getAmount() {
        return amount.getText();
    }

    public String getExpectedRevenue() {
        return expectedRevenue.getText();
    }

    public String getCloseDate() {
        return closeDate.getText();
    }

    public String getNextStep() {
        return nextStep.getText();
    }

    public String getStage() {
        return stage.getText();
    }

    public String getProbability() {
        return probability.getText();
    }

    public String getPrimaryCampaignSource() {
        return primaryCampaignSource.getText();
    }

    public String getMainCompetitors() {
        return mainCompetitors.getText();
    }

    public String getDeliveryInstallationStatus() {
        return deliveryInstallationStatus.getText();
    }

    public String getLastModifiedBy(){
        return lastModifiedBy.getText();
    }


}

