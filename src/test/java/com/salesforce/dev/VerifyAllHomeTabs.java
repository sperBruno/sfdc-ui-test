package com.salesforce.dev;

import com.salesforce.dev.pages.Accounts.AccountsHome;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Campaigns.CampaignsHome;
import com.salesforce.dev.pages.Cases.CasesHome;
import com.salesforce.dev.pages.Chatter.ChatterHome;
import com.salesforce.dev.pages.Contacts.ContactsHome;
import com.salesforce.dev.pages.Contracts.ContractsHome;
import com.salesforce.dev.pages.Dashboards.DashboardsHome;
import com.salesforce.dev.pages.Forecasts.ForecastsHome;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Leads.LeadsHome;
import com.salesforce.dev.pages.Login.Transporter;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.Orders.OrdersHome;
import com.salesforce.dev.pages.Product.ProductsHome;
import com.salesforce.dev.pages.Reports.ReportsHome;
import com.salesforce.dev.pages.Solutions.SolutionsHome;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Monica Pardo on 6/24/2015.
 */
public class VerifyAllHomeTabs {

    private HomePage homePage;
    private MainPage mainPage;


    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
        mainPage = Transporter.driverMainPage();
    }

    @Test(groups = {"BVT"})
    public void testVerifyAllHomeTabs() {
        NavigationBar navigationBar=mainPage.gotoNavBar();
        ChatterHome chatterHome=navigationBar.goToChatterHome();
                Assert.assertEquals(chatterHome.IsUserInChatterTab(),true);
        CampaignsHome campaignsHome=navigationBar.goToCampaignsHome();
                Assert.assertEquals(campaignsHome.IsUserInCampaignsTab(),true);
        LeadsHome leadsHome=navigationBar.gotToLeadsHome();
                Assert.assertEquals(leadsHome.IsUserInLeadsTab(),true);
        AccountsHome accountsHome=navigationBar.goToAccountsHome();
                Assert.assertEquals(accountsHome.IsUserInAccountsTab(),true);
        ContactsHome contactsHome=navigationBar.goToContactsHome();
                Assert.assertEquals(contactsHome.IsUserInContactsTab(),true);
        OpportunitiesHome opportunitiesHome=navigationBar.goToOpportunitiesHome();
                 Assert.assertEquals(opportunitiesHome.IsUserInOpportunitiesTab(),true);
        ForecastsHome forecastsHome=navigationBar.goToForescastsHome();
                Assert.assertEquals(forecastsHome.IsUserInForecastsTab(),true);
        ContractsHome contractsHome=navigationBar.goToContractsHome();
                Assert.assertEquals(contractsHome.IsUserInContractsTab(),true);
        OrdersHome ordersHome=navigationBar.goToOrdersHome();
                Assert.assertEquals(ordersHome.IsUserInOrdersTab(),true);
        CasesHome casesHome=navigationBar.goToCasesHome();
                Assert.assertEquals(casesHome.IsUserInCasesTab(),true);
       SolutionsHome solutionsHome=navigationBar.goToSolutionsHome();
                Assert.assertEquals(solutionsHome.IsUserInSolutionsTab(),true);
        ReportsHome reportsHome=navigationBar.goToReportsHome();
                Assert.assertEquals(reportsHome.IsUserInReportsTab(),true);
       DashboardsHome dashboardsHome=navigationBar.goToDashboardsHome();
                Assert.assertEquals(dashboardsHome.IsUserInDashboardsTab(),true);


    }
}
