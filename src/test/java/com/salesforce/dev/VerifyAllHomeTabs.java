package com.salesforce.dev;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.accounts.AccountsHome;
import com.salesforce.dev.pages.base.NavigationBar;
import com.salesforce.dev.pages.campaigns.CampaignsHome;
import com.salesforce.dev.pages.cases.CasesHome;
import com.salesforce.dev.pages.chatter.ChatterHome;
import com.salesforce.dev.pages.contacts.ContactsHome;
import com.salesforce.dev.pages.contracts.ContractsHome;
import com.salesforce.dev.pages.dashboards.DashboardsHome;
import com.salesforce.dev.pages.forecasts.ForecastsHome;
import com.salesforce.dev.pages.leads.LeadsHome;
import com.salesforce.dev.pages.opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.orders.OrdersHome;
import com.salesforce.dev.pages.product.ProductsHome;
import com.salesforce.dev.pages.reports.ReportsHome;
import com.salesforce.dev.pages.solutions.SolutionsHome;

import static org.testng.Assert.assertTrue;

/**
 * This class will test all tabs pages from Salesforce.
 *
 * @author Monica Pardo on 6/24/2015.
 * @author Bruno Barrios.
 */
public class VerifyAllHomeTabs {

    private NavigationBar navigationBar;

    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"BVT"})
    public void testVerifyAllHomeTabs() {
        ChatterHome chatterHome = navigationBar.goToChatterHome();
        assertTrue(chatterHome.IsUserInChatterTab(), "Chatter page not displayed");

        CampaignsHome campaignsHome = navigationBar.goToCampaignsHome();
        assertTrue(campaignsHome.IsUserInCampaignsTab(), "Campaings page not displayed");

        LeadsHome leadsHome = navigationBar.gotToLeadsHome();
        assertTrue(leadsHome.IsUserInLeadsTab(), "lead page not displayed");

        AccountsHome accountsHome = navigationBar.goToAccountsHome();
        assertTrue(accountsHome.IsUserInAccountsTab(), "Accounts page not displayed");

        ContactsHome contactsHome = navigationBar.goToContactsHome();
        assertTrue(contactsHome.IsUserInContactsTab(), "Contacts page not displayed");

        OpportunitiesHome opportunitiesHome = navigationBar.goToOpportunitiesHome();
        assertTrue(opportunitiesHome.IsUserInOpportunitiesTab(), "Opportunities page not displayed");

        ForecastsHome forecastsHome = navigationBar.goToForesCastsHome();
        assertTrue(forecastsHome.IsUserInForecastsTab(), "Forecasts page not displayed");

        ContractsHome contractsHome = navigationBar.goToContractsHome();
        assertTrue(contractsHome.IsUserInContractsTab(), "Contracts page not displayed");

        OrdersHome ordersHome = navigationBar.goToOrdersHome();
        assertTrue(ordersHome.IsUserInOrdersTab(), "Orders page not displayed");

        CasesHome casesHome = navigationBar.goToCasesHome();
        assertTrue(casesHome.IsUserInCasesTab(), "Cases page not displayed");

        SolutionsHome solutionsHome = navigationBar.goToSolutionsHome();
        assertTrue(solutionsHome.IsUserInSolutionsTab(), "Solutions page not displayed");

        ProductsHome productsHome = navigationBar.goToProductsHome();
        assertTrue(productsHome.IsUserInProductsTab(), "Products page not displayed");

        ReportsHome reportsHome = navigationBar.goToReportsHome();
        assertTrue(reportsHome.IsUserInReportsTab(), "Reports page not displayed");

        DashboardsHome dashboardsHome = navigationBar.goToDashboardsHome();
        assertTrue(dashboardsHome.IsUserInDashboardsTab(), "Dashboard page not displayed");
    }
}
