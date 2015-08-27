package com.salesforce.dev;

import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.LoggerManager;
import com.salesforce.dev.framework.Objects.Campaign;
import com.salesforce.dev.framework.Objects.ViewSalesForce;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Campaigns.CampaignDetail;
import com.salesforce.dev.pages.Campaigns.CampaignForm;
import com.salesforce.dev.pages.Campaigns.CampaignsHome;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Login.Transporter;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Base.SearchLookupBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;

/**
 * Created by Marcelo.Vargas on 6/15/2015.
 */
public class CreateCampaign {

    private String parentCampaign = "CampaignParent";

    private CampaignsHome campaignsHome;
    private CampaignDetail campaignDetail;
    private CampaignForm campaignForm;
    private HomePage homePage;
    private MainPage mainPage;
    private NavigationBar navigationBar;


    private SearchLookupBase searchLookup;
    @DataProvider(name = "dataDriven")
    public Iterator<Campaign[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getCampaign("CreateCampaign.json");
    }
    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        mainPage = Transporter.driverMainPage();
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCampaignsHome();
        campaignForm = campaignsHome.clickNewBtn();
        campaignForm.setCampaignName(parentCampaign);
        campaignForm.checkActiveCheckbox();
        campaignDetail = campaignForm.clickSaveBtn();
        mainPage = campaignDetail.gotoMainPage();
    }

    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testCreateCampaign(Campaign campaign) {
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCampaignsHome();
        campaignForm = campaignsHome.clickNewBtn();
        campaignForm.setCampaignName(campaign.getCampaignName());
        campaignForm.checkActiveCheckbox();
        campaignForm.setTypeSelect(campaign.getCampaignType());
        campaignForm.setStatusSelect(campaign.getCampaignStatus());
        campaignForm.setStartDate(campaign.getStartDate());
        campaignForm.setEndDate(campaign.getEndDate());
        campaignForm.setExpectedRevenue(campaign.getExpectedRevenue());
        campaignForm.setBudgetedCost(campaign.getBudgetedCost());
        campaignForm.setActualCost(campaign.getActualCost());
        campaignForm.setExpectedResponse(campaign.getExpectedResponse());
        campaignForm.setNumSent(campaign.getNumSent());
        searchLookup = campaignForm.clickLookupParentCampaign();
        searchLookup.searchText(parentCampaign);
        campaignForm = searchLookup.goToCampaignForm();

        campaignDetail = campaignForm.clickSaveBtn();

        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Campaign was created");

        Assert.assertTrue(campaignDetail.validateCampaignNameFld(campaign.getCampaignName()));
        Assert.assertTrue(campaignDetail.validateCampaignType(campaign.getCampaignType()));
        Assert.assertTrue(campaignDetail.validateCampaignStatus(campaign.getCampaignStatus()));
        Assert.assertTrue(campaignDetail.validateCampaignStartDate(campaign.getStartDate()));
        Assert.assertTrue(campaignDetail.validateCampaignEndDate(campaign.getEndDate()));
        Assert.assertTrue(campaignDetail.validateCampaignParent(parentCampaign));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        campaignDetail.clickDeleteBtn(true);
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Campaign was deleted");
        mainPage = campaignDetail.gotoMainPage();
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCampaignsHome();
        campaignDetail = campaignsHome.selectRecentItem(parentCampaign);
        campaignDetail.clickDeleteBtn(true);
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Campaign Parent was deleted");
    }
}