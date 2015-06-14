package com.salesforce.dev.pages.Opportunities;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jimmy Vargas on 6/10/2015.
 *
 * Todo: still need to complet the class with the remaining fields
 */
public class OpportunityForm {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "opp3")
    WebElement opportunityNameField;

    @FindBy(id = "opp7")
    WebElement amountField;

    @FindBy(id = "opp9")
    WebElement closeDateField;

    @FindBy(id = "opp11")
    WebElement stageCombobox;

    @FindBy(xpath = "//input[@id='opp9']/following::a")
    WebElement todayLink;

    @FindBy(name = "save")
    WebElement saveBtn;

    public OpportunityForm(WebDriver driver){
        this.driver = driver;
        initializer();
    }

    public OpportunityForm(OpportunityBuilder builder){
        initializer();

        //setting the mandatoryFields for an Opportunity;
        this.setOpportunityName(builder.opName);
        this.setCloseDate(builder.closeDate);
        this.setStageByVisibleText(builder.stage);
        this.setAmount(builder.amount);

    }

    private void initializer(){
        if (this.driver==null){
            this.driver = DriverManager.getInstance().getDriver();
        }
        wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(this.driver, this);
    }

    public void setOpportunityName(String opportunityName){
        wait.until(ExpectedConditions.visibilityOf(opportunityNameField));
        opportunityNameField.clear();
        opportunityNameField.sendKeys(opportunityName);
    }

    /**
     * TODO:
     * By the moment it is only click in the link for the date
     * Selecting a specific date still needs to be done
     * */
    public void setCloseDate(String closeDate){
        wait.until(ExpectedConditions.elementToBeClickable(todayLink));
        todayLink.click();
    }

    /**
     * Sets the stage for the opportunity
     *
     * @author: Jimmy Vargas
     * @version: 1.0
     * */
    public void setStageByVisibleText(String stage){
        wait.until(ExpectedConditions.visibilityOf(stageCombobox));
        Select select = new Select(stageCombobox);
        select.selectByVisibleText(stage);

        this.driver.switchTo().defaultContent();

    }
    public void setAmount(String amount){
        wait.until(ExpectedConditions.visibilityOf(amountField));
        amountField.clear();
        amountField.sendKeys(amount);
    }


    public OpportunityDetail clickSaveBtn(){
        wait.until(ExpectedConditions.visibilityOf(saveBtn));
        saveBtn.click();

        return new OpportunityDetail(this.driver);
    }
}
