package com.salesforce.dev.pages.Opportunities;

import com.salesforce.dev.pages.Base.*;
import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jimmy Vargas on 6/10/2015.
 */
public class OpportunitiesHome extends TabPage{

    public OpportunitiesHome(WebDriver driver){
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(super.driver,this);
    }

     public OpportunityForm clickNewBtn(){
        super.wait.until(ExpectedConditions.visibilityOf(newBtn));
        newBtn.click();

        return new OpportunityForm(this.driver);
    }

    public OpportunityDetails selectRecentItem(String opportunity){
        super.clickRecentItem(opportunity);
        return new OpportunityDetails(this.driver);
    }







}

