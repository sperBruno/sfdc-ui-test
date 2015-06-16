package com.salesforce.dev;

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Campaigns.CampaignDetail;
import com.salesforce.dev.pages.Campaigns.CampaignForm;
import com.salesforce.dev.pages.Campaigns.CampaignsHome;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Marcelo.Vargas on 6/15/2015.
 */
public class CreateCampaign {
    private CampaignsHome campaignsHome;
    private CampaignDetail campaignDetail;
    private CampaignForm campaignForm;
    private HomePage homePage;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private String lastName="MyLastName";

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage();
        String userNameValue= Environment.getInstance().getPrimaryUser();
        String passwordValue=Environment.getInstance().getPrimaryPassword();
        mainPage = homePage.loginAs(userNameValue,passwordValue);
    }

    @Test
    public void testCreateContact() {
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCamapaignsHome();
        campaignForm = campaignsHome.clickNewBtn();
        campaignForm = campaignForm.setCampaignName(lastName);
        campaignDetail = campaignForm.clickSaveBtn();

        //Assert.assertTrue(contactDetail.VerifyContact(lastName), "contact was not Created");
    }

    @AfterMethod
    public void tearDown() {
        //campaignDetail.DeleteCampaign();

    }
}
