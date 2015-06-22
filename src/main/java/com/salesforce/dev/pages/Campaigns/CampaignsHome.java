package com.salesforce.dev.pages.Campaigns;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.HomeBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Marcelo.Vargas on 13-06-15.
 */
public class CampaignsHome extends HomeBase {

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
    public CampaignDetail selectRecentItem(String campaign){
        super.clickRecentItem(campaign);
        return new CampaignDetail(this.driver);
    }
}