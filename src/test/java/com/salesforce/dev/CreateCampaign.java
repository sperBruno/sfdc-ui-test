package com.salesforce.dev;

import java.util.Iterator;
import java.util.Map;

import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.Objects.Campaign;
import com.salesforce.dev.pages.Accounts.AccountSteps;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Base.SearchLookupBase;
import com.salesforce.dev.pages.Campaigns.CampaignDetail;
import com.salesforce.dev.pages.Campaigns.CampaignForm;
import com.salesforce.dev.pages.Campaigns.CampaignSteps;
import com.salesforce.dev.pages.Campaigns.CampaignsHome;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.Login.Transporter;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Objects.CampaignGenie;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Marcelo.Vargas on 6/15/2015.
 */
public class CreateCampaign {

    private String parentCampaign = "CampaignParent";
    private CampaignsHome campaignsHome;
    private CampaignDetail campaignDetail;
    private CampaignForm campaignForm;
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
        parentCampaign = CampaignGenie.getCampaign().getParentCampaign();
        CampaignGenie.createParentCampaign(parentCampaign);
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testCreateCampaign(Campaign campaign) {
        campaignsHome = navigationBar.goToCampaignsHome();
        campaignForm = campaignsHome.clickNewBtn()
                .setEndDate(campaign.getEndDate())
                .setStartDate(campaign.getStartDate())
                .setCampaignName(campaign.getCampaignName())
                .checkActiveCheckbox()
                .setTypeSelect(campaign.getCampaignType())
                .setStatusSelect(campaign.getCampaignStatus())
                .setExpectedRevenue(campaign.getExpectedRevenue())
                .setBudgetedCost(campaign.getBudgetedCost())
                .setActualCost(campaign.getActualCost())
                .setExpectedResponse(campaign.getExpectedResponse())
                .setNumSent(campaign.getNumSent());
        searchLookup = campaignForm.clickLookupParentCampaign();
        searchLookup.searchText(parentCampaign);
        campaignForm = searchLookup.goToCampaignForm();
        campaignDetail = campaignForm.clickSaveBtn();
        Map<CampaignSteps, Object> mapCampaign = campaign.convertToMap();
        Map<CampaignSteps, Object> mapExpected = campaignDetail.getAssertionMap();
        mapCampaign.keySet().stream().forEach((step) -> {
            assertEquals(String.valueOf(mapExpected.get(step)), String.valueOf(mapCampaign.get(step)));
        });
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        campaignDetail.clickDeleteBtn(true);
    }
}