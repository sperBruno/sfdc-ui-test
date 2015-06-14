package com.salesforce.dev.pages.Opportunities;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.DetailsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jimmy Vargas on 6/10/2015.
 */
public class OpportunityDetail extends DetailsBase {

    @FindBy(id = "opp1_ileinner")
    WebElement  opOwner;

    @FindBy(id = "opp2_ileinner")
    WebElement privateCheckBox;

    @FindBy(id = "opp3_ileinner")
    WebElement opName;

    @FindBy(id = "opp4_ileinner")
    WebElement accountName;

    @FindBy(id = "opp5_ileinner")
    WebElement type;

    @FindBy(id = "opp6_ileinner")
    WebElement leadSource;

    @FindBy(id = "00N1a0000056xtc_ileinner") //TODO: change to xpath?
    WebElement orderNumber;

    @FindBy(id ="00N1a0000056xtZ_ileinner") //TODO: change to xpath?
    WebElement currentGenerator;

    @FindBy(id = "00N1a0000056xtd_ileinner") //TODO: change to xpath?
    WebElement trackingNumber;

    @FindBy(id = "CreatedBy_ileinner")
    WebElement createdBy;

    @FindBy(id = "opp14_ileinner")
    WebElement opDescription;

    /* Pending
    @FindBy()
    WebElement customLinks;
    */

    @FindBy(id = "opp7_ileinner")
    WebElement amount;

    @FindBy(id = "opp8_ileinner")
    WebElement expectedRevenue;

    @FindBy(id = "opp9_ileinner")
    WebElement closeDate;

    @FindBy(id = "opp10_ileinner")
    WebElement nextStep;

    @FindBy(id = "opp11_ileinner")
    WebElement stage;

    @FindBy(id = "opp12_ileinner")
    WebElement probability;

    @FindBy(id = "opp17_ileinner")
    WebElement primaryCampaignSource;

    @FindBy(id = "00N1a0000056xtb_ileinner")//TODO: change to xpath?
    WebElement mainCompetidors;

    @FindBy(id = "00N1a0000056xta_ileinner")//TODO: change to xpath?
    WebElement deliveryInstallationStatus;

    @FindBy(id = "LastModifiedBy_ileinner")
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
    public Object clickEditBtn(){
        super.clickEditButton();
        return new OpportunityForm(driver);
    }

    /**
     * Deletes the Opportunity returning to the Opportunities Home
     *
     * @author: Jimmy Vargas
     * @since: 06/13/2015
     * */
    public OpportunitiesHome clickDeleteBtn(boolean confirmDeletion){
        super.clickDeletedButton(confirmDeletion);
        return new OpportunitiesHome(driver);
    }

    /**
     * Deletes the opportunity from its own page
     *
     * @author: Jimmy Vargas
     * @since: 06/13/2015
     * */
    public OpportunitiesHome deleteOpportunity(){
        return (OpportunitiesHome)clickDeleteBtn(true);
    }

    public String getOpOwner(){
        return opOwner.getText();
    }

    //todo: still need to implement this
    public boolean isPrivate() {
     //   WebElement privateCheckBox;
     return false;
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

    public String getCurrenGenerator() {
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

    /* Pending
    @FindBy()
    WebElement customLinks;
    */

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

    public String getMainCompetidors() {
        return mainCompetidors.getText();
    }

    public String getDeliveryInstallationStatus() {
        return deliveryInstallationStatus.getText();
    }

    public String getLastModifiedBy(){
        return lastModifiedBy.getText();
    }


}

