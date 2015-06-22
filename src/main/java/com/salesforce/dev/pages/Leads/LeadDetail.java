package com.salesforce.dev.pages.Leads;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.DetailsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Jimmy Vargas on 6/15/2015.
 */
public class LeadDetail extends DetailsBase {

    /*Lead Information*/
    @FindBy(id = "lea1_ileinner")
    WebElement owner;

    @FindBy(id = "lea2_ileinner")
    WebElement name;

    @FindBy(id = "lea3_ileinner")
    WebElement company;

    @FindBy(id = "lea4_ileinner")
    WebElement title;

    @FindBy(id = "lea5_ileinner")
    WebElement leadSource;

    @FindBy(id = "lea6_ileinner")
    WebElement industry;

    @FindBy(id = "lea7_ileinner")
    WebElement annualRevenue;

    @FindBy(id = "lea8_ileinner")
    WebElement phone;

    @FindBy(id = "lea9_ileinner")
    WebElement mobile;

    @FindBy(id = "lea10_ileinner")
    WebElement fax;

    @FindBy(id = "lea11_ileinner")
    WebElement email;

    @FindBy(id = "lea12_ileinner")
    WebElement website;

    @FindBy(id = "lea13_ileinner")
    WebElement leadStatus;

    @FindBy(id = "lea14_ileinner")
    WebElement rating;

    @FindBy(id = "lea15_ileinner")
    WebElement numEmployees;

    /*Address Information*/
    @FindBy(id = "lea16_ileinner")
    WebElement address;

    /*additional information*/
    @FindBy(xpath = "//td[contains(.,'Product Interest')]/following::div")
    WebElement productInterest;

    @FindBy(xpath = "//td[contains(.,'SIC Code')]/following::div")
    WebElement SICcode;

    @FindBy(xpath = "//td[contains(.,'Number of Locations')]/following::div")
    WebElement numLocations;

    @FindBy(xpath = "//td[contains(.,'Current Generator')]/following::div")
    WebElement currentGenerators;

    @FindBy(xpath = "//td[contains(.,'Primary')]/following::div")
    WebElement primary;

    /*Others*/
    @FindBy(id = "lea17_ileinner")
    WebElement description;

    @FindBy(id = "lea20")
    WebElement campaign;

    @FindBy(id = "CreatedBy_ileinner")
    WebElement createdBy;

    @FindBy(id = "LastModifiedBy_ileinner")
    WebElement lastModifiedBy;

    public LeadDetail(WebDriver driver){
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(super.driver, this);

    }

    /*Lead Information*/
    public String getOwner(){
        return owner.getText();
    }

    public String getName(){
        return name.getText();
    }

    public String getCmpany(){
        return company.getText();
    }

    public String getTitle(){
        return title.getText();
    }

    public String getLeadSource(){
        return  leadSource.getText();
    }

    public String getIndustry(){
        return industry.getText();
    }

    public String getAnnualRevenue(){
        return annualRevenue.getText();
    }

    public String getPhone(){
        return phone.getText();
    }

    public String getMobile(){
        return mobile.getText();
    }

    public String getFax(){
        return fax.getText();
    }

    public String getEmail(){
        return email.getText();
    }

    public String getWebsite(){
        return website.getText();
    }

    public String getLeadStatus(){
        return leadStatus.getText();
    }

    public String getRating(){
        return rating.getText();
    }

    public String getNumEmployees(){
        return numEmployees.getText();
    }

    /*Address Information*/
    public String getAddress(){
        return address.getText();
    }

    /*additional information*/
    public String getProductInterest(){
        return productInterest.getText();
    }

    public String getSICcode(){
        return SICcode.getText();
    }

    public String getNumLocations(){
        return numLocations.getText();
    }

    public String getCurrentGenerators(){
        return currentGenerators.getText();
    }

    public String getPrimary(){
        return primary.getText();
    }

    /*Others*/
    public String getDescription(){
        return description.getText();
    }

    //todo:incomplete
    public String getCampaign(){
        return campaign.getText();
    }

    public String getCreatedBy(){
        return createdBy.getText();
    }

    public String getLastModifiedBy(){
        return lastModifiedBy.getText();
    }

    public LeadForm clickEditBtn(){
        super.clickEditButton();
        return new LeadForm(this.driver);
    }


    public LeadsHome deleteLead(){
        return clickDeleteBtn(true);

    }

    @Override
    protected LeadsHome clickDeleteBtn(boolean confirmDeletion) {
        super.clickDeleteButton(true);
        return new LeadsHome(this.driver);
    }
}
