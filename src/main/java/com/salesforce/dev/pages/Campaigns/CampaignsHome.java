package com.salesforce.dev.pages.Campaigns;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.HomeBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Marcelo.Vargas on 13-06-15.
 */
public class CampaignsHome extends HomeBase {
    @FindBy(xpath = "//h1[contains(.,'Campaigns:')]")
    WebElement campaignSection;

    public CampaignsHome(WebDriver driver) {
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    @Override
    public CampaignForm clickNewBtn(){
        clickNewButton();
        return new CampaignForm(this.driver);
    }

    @Override
    public CampaignView clickNewViewLnk() {
        clickNewViewLink();
        return new CampaignView(this.driver);
    }

    @Override
    public CampaignView clickEditViewLnk(String value) {
        editViewLnk(value);
        return new CampaignView(this.driver);
    }


    @Override
    public CampaignDetail selectRecentItem(String campaign){
        super.clickRecentItem(campaign);
        return new CampaignDetail(this.driver);
    }
    public boolean IsUserInCampaignsTab(){
        try{

            wait.until(ExpectedConditions.visibilityOf(campaignSection));
            return true;
        }
        catch (WebDriverException e){
            return false;
        }
    }
}