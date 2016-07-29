package com.salesforce.dev.pages.leads;

import com.salesforce.dev.pages.base.DetailsBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Jimmy Vargas on 6/15/2015.
 */
public class LeadDetail extends DetailsBase {

    @FindBy(id = "lea8_ileinner")
    @CacheLookup
    WebElement phone;
    @FindBy(id = "lea10_ileinner")
    @CacheLookup
    WebElement fax;
    /*Lead Information*/
    @FindBy(id = "lea1_ileinner")
    @CacheLookup
    private WebElement owner;
    @FindBy(id = "lea2_ileinner")
    @CacheLookup
    private WebElement name;
    @FindBy(id = "lea3_ileinner")
    @CacheLookup
    private WebElement company;
    @FindBy(id = "lea4_ileinner")
    @CacheLookup
    private WebElement title;
    @FindBy(id = "lea5_ileinner")
    @CacheLookup
    private WebElement leadSource;
    @FindBy(id = "lea6_ileinner")
    @CacheLookup
    private WebElement industry;
    @FindBy(id = "lea7_ileinner")
    @CacheLookup
    private WebElement annualRevenue;
    @FindBy(id = "lea9_ileinner")
    @CacheLookup
    private WebElement mobile;
    @FindBy(id = "lea11_ileinner")
    @CacheLookup
    private WebElement email;

    @FindBy(id = "lea12_ileinner")
    @CacheLookup
    private WebElement website;

    @FindBy(id = "lea13_ileinner")
    @CacheLookup
    private WebElement leadStatus;

    @FindBy(id = "lea14_ileinner")
    @CacheLookup
    private WebElement rating;

    @FindBy(id = "lea15_ileinner")
    @CacheLookup
    private WebElement numEmployees;

    /*Address Information*/
    @FindBy(id = "lea16_ileinner")
    @CacheLookup
    private WebElement address;

    /*additional information*/
    @FindBy(id = "00N50000006d6vR_ileinner")
    @CacheLookup
    private WebElement productInterest;

    @FindBy(xpath = "//td[contains(.,'SIC Code')]/following::div")
    @CacheLookup
    private WebElement SICcode;

    @FindBy(xpath = "//td[contains(.,'Number of Locations')]/following::div")
    @CacheLookup
    private WebElement numLocations;

    @FindBy(xpath = "//td[contains(.,'Current Generator')]/following::div")
    @CacheLookup
    private WebElement currentGenerators;

    @FindBy(id = "00N50000006d6vQ_ileinner")
    @CacheLookup
    private WebElement primary;

    /*Others*/
    @FindBy(id = "lea17_ileinner")
    @CacheLookup
    private WebElement description;

    @FindBy(id = "lea20")
    @CacheLookup
    private WebElement campaign;

    @FindBy(id = "CreatedBy_ileinner")
    @CacheLookup
    private WebElement createdBy;

    @FindBy(id = "LastModifiedBy_ileinner")
    @CacheLookup
    private WebElement lastModifiedBy;


    /*Lead Information*/
    public String getOwner() {
        return owner.getText();
    }

    public String getName() {
        return name.getText();
    }

    public String getCompany() {
        return company.getText();
    }

    public String getTitle() {
        return title.getText();
    }

    public String getLeadSource() {
        return leadSource.getText();
    }

    public String getIndustry() {
        return industry.getText();
    }

    public String getAnnualRevenue() {
        return annualRevenue.getText();
    }

    public String getPhone() {
        return phone.getText();
    }

    public String getMobile() {
        return mobile.getText();
    }

    public String getFax() {
        return fax.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getWebsite() {
        return website.getText();
    }

    public String getLeadStatus() {
        return leadStatus.getText();
    }

    public String getRating() {
        return rating.getText();
    }

    public String getNumEmployees() {
        return numEmployees.getText();
    }

    /*Address Information*/
    public String getAddress() {
        return address.getText();
    }

    /*additional information*/
    public String getProductInterest() {
        return productInterest.getText();
    }

    public String getSICcode() {
        return SICcode.getText();
    }

    public String getNumLocations() {
        return numLocations.getText();
    }

    public String getCurrentGenerators() {
        return currentGenerators.getText();
    }

    public String getPrimary() {
        return primary.getText();
    }

    /*Others*/
    public String getDescription() {
        return description.getText();
    }

    public String getCampaign() {
        return campaign.getText();
    }

    public String getCreatedBy() {
        return createdBy.getText();
    }

    public String getLastModifiedBy() {
        return lastModifiedBy.getText();
    }

    public LeadForm clickEditBtn() {
        super.clickEditButton();
        return new LeadForm();
    }


    public LeadsHome deleteLead() {
        return clickDeleteBtn(true);

    }

    @Override
    protected LeadsHome clickDeleteBtn(boolean confirmDeletion) {
        super.clickDeleteButton(true);
        return new LeadsHome();
    }
}
