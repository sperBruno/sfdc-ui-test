package com.salesforce.dev.pages.Campaigns;

import com.salesforce.dev.pages.Base.HomeBase;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Marcelo.Vargas on 13-06-15.
 */
public class CampaignsHome extends HomeBase {

    @FindBy(xpath = "//h1[contains(.,'Campaigns:')]")
    private WebElement campaignSection;

    @Override
    public CampaignForm clickNewBtn(){
        clickNewButton();
        return new CampaignForm();
    }

    @Override
    public CampaignView clickNewViewLnk() {
        clickNewViewLink();
        return new CampaignView();
    }

    @Override
    public CampaignView clickEditViewLnk(String value) {
        editViewLnk(value);
        return new CampaignView();
    }

    @Override
    public CampaignDetail selectRecentItem(String campaign){
        super.clickRecentItem(campaign);
        return new CampaignDetail();
    }

    @Override
    public  CampaignsHome selectRecentViewItem(String value) {
        selectRecentView(value);
        return this;
    }

    public boolean IsUserInCampaignsTab(){
        try{
            WAIT.until(ExpectedConditions.visibilityOf(campaignSection));
            return true;
        }
        catch (WebDriverException e){
            return false;
        }
    }
}