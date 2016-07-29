package com.salesforce.dev;

import com.salesforce.dev.pages.accounts.AccountsHome;
import com.salesforce.dev.pages.base.NavigationBar;
import com.salesforce.dev.pages.campaigns.CampaignsHome;
import com.salesforce.dev.pages.cases.CasesHome;
import com.salesforce.dev.pages.chatter.ChatterHome;
import com.salesforce.dev.pages.contacts.ContactsHome;
import com.salesforce.dev.pages.contracts.ContractsHome;
import com.salesforce.dev.pages.dashboards.DashboardsHome;
import com.salesforce.dev.pages.forecasts.ForecastsHome;
import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.leads.LeadsHome;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.orders.OrdersHome;
import com.salesforce.dev.pages.product.ProductsHome;
import com.salesforce.dev.pages.reports.ReportsHome;
import com.salesforce.dev.pages.solutions.SolutionsHome;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Monica Pardo on 6/24/2015.
 */
public class VerifyAllHomeTabs {

    private static final Logger LOGGER = Logger.getLogger(VerifyAllHomeTabs.class.getName());

    private MainPage mainPage;

    private NavigationBar navigationBar;

    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"BVT"})
    public void testVerifyAllHomeTabs() {
        ChatterHome chatterHome = navigationBar.goToChatterHome();
        assertTrue(chatterHome.IsUserInChatterTab());

        CampaignsHome campaignsHome = navigationBar.goToCampaignsHome();
        assertTrue(campaignsHome.IsUserInCampaignsTab());

        LeadsHome leadsHome = navigationBar.gotToLeadsHome();
        assertTrue(leadsHome.IsUserInLeadsTab());

        AccountsHome accountsHome = navigationBar.goToAccountsHome();
        assertTrue(accountsHome.IsUserInAccountsTab());

        ContactsHome contactsHome = navigationBar.goToContactsHome();
        assertTrue(contactsHome.IsUserInContactsTab());

        OpportunitiesHome opportunitiesHome = navigationBar.goToOpportunitiesHome();
        assertTrue(opportunitiesHome.IsUserInOpportunitiesTab());

        ForecastsHome forecastsHome = navigationBar.goToForesCastsHome();
        assertTrue(forecastsHome.IsUserInForecastsTab());

        ContractsHome contractsHome = navigationBar.goToContractsHome();
        assertTrue(contractsHome.IsUserInContractsTab());

        OrdersHome ordersHome = navigationBar.goToOrdersHome();
        assertTrue(ordersHome.IsUserInOrdersTab());

        CasesHome casesHome = navigationBar.goToCasesHome();
        assertTrue(casesHome.IsUserInCasesTab());

        SolutionsHome solutionsHome = navigationBar.goToSolutionsHome();
        assertTrue(solutionsHome.IsUserInSolutionsTab());

        ProductsHome productsHome = navigationBar.goToProductsHome();
        assertTrue(productsHome.IsUserInProductsTab());

        ReportsHome reportsHome = navigationBar.goToReportsHome();
        assertTrue(reportsHome.IsUserInReportsTab());

        DashboardsHome dashboardsHome = navigationBar.goToDashboardsHome();
        assertTrue(dashboardsHome.IsUserInDashboardsTab());
        LOGGER.info("Verifying all Home Tabs");
    }
}
