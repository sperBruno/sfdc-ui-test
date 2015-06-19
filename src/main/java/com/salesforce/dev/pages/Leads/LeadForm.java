package com.salesforce.dev.pages.Leads;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.FormBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by Jimmy Vargas on 6/15/2015.
 */
public class LeadForm extends FormBase {

    @FindBy(id = "name_lastlea2")
    WebElement lastName;

    @FindBy(id = "lea3")
    WebElement company;

    @FindBy(id = "lea4")
    WebElement title;

    @FindBy(id = "lea13")
    WebElement leadStatus;


    public LeadForm(WebDriver driver){
        super.driver = driver;
        super.initializer();
    }

    public LeadForm(LeadBuilder builder){
        super.initializer();

        //setting the mandatory fields
        this.setLastName(builder.lastName);
        this.setCompany(builder.company);
        this.setLeadStatusByVisibleText(builder.leadStatus);


    }

    public void setLastName(String lastName){
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }

    public void setCompany(String company){
        this.company.clear();
        this.company.sendKeys(company);
    }

    public void setTitle(String title){
        this.title.clear();
        this.title.sendKeys(title);
    }

    public void setLeadStatusByVisibleText(String leadStatus){
        Select leadStatusComboBox = new Select(this.leadStatus);
        try {
            leadStatusComboBox.selectByVisibleText(leadStatus);
        }
        catch(WebDriverException e){
            throw new WebDriverException("The leadStatus "+leadStatus+" couldn't be selected");
        }
    }

    public LeadDetail clickSaveBtn(){
        super.clickSaveButton();
        return new LeadDetail(super.driver);
    }

    public LeadForm clickSaveNewBtn(){
        super.clickSaveNewButton();
        return new LeadForm(super.driver);
    }

    public LeadsHome clickCancelBtn(){
        super.clickCancelButton();
        return new LeadsHome(super.driver);
    }

}
