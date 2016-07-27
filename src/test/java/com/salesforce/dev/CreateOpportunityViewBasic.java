package com.salesforce.dev;

import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.LoggerManager;
import com.salesforce.dev.framework.Objects.ViewSalesForce;
import com.salesforce.dev.framework.RandomGenerator;
import com.salesforce.dev.pages.Accounts.AccountView;
import com.salesforce.dev.pages.Accounts.AccountViewDetail;
import com.salesforce.dev.pages.Accounts.AccountsHome;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Login.Transporter;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.Opportunities.OpportunityView;
import com.salesforce.dev.pages.Opportunities.OpportunityViewDetail;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;

/**
 * Created by Carlos Orellana on 8/22/2015.
 */
public class CreateOpportunityViewBasic {
    private OpportunitiesHome opportunitiesHome;
    private OpportunityView opportunityView;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private OpportunityViewDetail opportunityViewDetail;
    private HomePage homePage;

    @DataProvider(name = "dataDriven")
    public Iterator<ViewSalesForce[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataView("CreateOpportunityViewBasic.json");
    }
    
    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
     
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testCreateCampaignView(ViewSalesForce viewSalesForce) {
//        mainPage = Transporter.driverMainPage();
//        navigationBar = mainPage.gotoNavBar();
        OpportunitiesHome opportunitiesHome = navigationBar.goToOpportunitiesHome();
        opportunityView = opportunitiesHome.clickNewViewLnk()
                .setViewName(viewSalesForce.getViewName())
                .setUniqueViewName(viewSalesForce.getUniqueViewName())
                .checkFilterByOwner(viewSalesForce.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForce.getRestrictVisibility());
        opportunityViewDetail = opportunityView.clickSaveBtn();
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Opportunity was created");
        System.out.println(opportunityViewDetail.validateNameView(viewSalesForce.getViewName()));
        Assert.assertTrue(opportunityViewDetail.validateNameView(viewSalesForce.getViewName()));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        opportunityViewDetail.clickDeleteLnk(true);
            LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                    "Opportunity View was deleted");
    }
}
