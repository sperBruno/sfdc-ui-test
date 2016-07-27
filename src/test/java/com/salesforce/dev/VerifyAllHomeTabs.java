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
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.Leads.LeadsHome;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.Orders.OrdersHome;
import com.salesforce.dev.pages.Reports.ReportsHome;
import com.salesforce.dev.pages.Solutions.SolutionsHome;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Monica Pardo on 6/24/2015.
 */
public class VerifyAllHomeTabs {

    private MainPage mainPage;

    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
        mainPage = LoginPage.getLogin();
    }

    @Test(groups = {"BVT"})
    public void testVerifyAllHomeTabs() {
        NavigationBar navigationBar=mainPage.gotoNavBar();
        ChatterHome chatterHome=navigationBar.goToChatterHome();
                assertTrue(chatterHome.IsUserInChatterTab());
        CampaignsHome campaignsHome=navigationBar.goToCampaignsHome();
                assertEquals(campaignsHome.IsUserInCampaignsTab(),true);
        LeadsHome leadsHome=navigationBar.gotToLeadsHome();
                assertEquals(leadsHome.IsUserInLeadsTab(),true);
        AccountsHome accountsHome=navigationBar.goToAccountsHome();
                assertEquals(accountsHome.IsUserInAccountsTab(),true);
        ContactsHome contactsHome=navigationBar.goToContactsHome();
                assertEquals(contactsHome.IsUserInContactsTab(),true);
        OpportunitiesHome opportunitiesHome=navigationBar.goToOpportunitiesHome();
                 assertEquals(opportunitiesHome.IsUserInOpportunitiesTab(),true);
        ForecastsHome forecastsHome=navigationBar.goToForescastsHome();
                assertEquals(forecastsHome.IsUserInForecastsTab(),true);
        ContractsHome contractsHome=navigationBar.goToContractsHome();
                assertEquals(contractsHome.IsUserInContractsTab(),true);
        OrdersHome ordersHome=navigationBar.goToOrdersHome();
                assertEquals(ordersHome.IsUserInOrdersTab(),true);
        CasesHome casesHome=navigationBar.goToCasesHome();
                assertEquals(casesHome.IsUserInCasesTab(),true);
       SolutionsHome solutionsHome=navigationBar.goToSolutionsHome();
                assertEquals(solutionsHome.IsUserInSolutionsTab(),true);
        ReportsHome reportsHome=navigationBar.goToReportsHome();
                assertEquals(reportsHome.IsUserInReportsTab(),true);
       DashboardsHome dashboardsHome=navigationBar.goToDashboardsHome();
                assertEquals(dashboardsHome.IsUserInDashboardsTab(),true);


    }
}
