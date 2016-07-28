package com.salesforce.dev.accounts;

import java.util.Iterator;

import com.salesforce.dev.framework.utils.DataDrivenManager;
import com.salesforce.dev.framework.dto.ViewSalesForce;
import com.salesforce.dev.framework.utils.RandomGenerator;
import com.salesforce.dev.pages.accounts.AccountView;
import com.salesforce.dev.pages.accounts.AccountViewDetail;
import com.salesforce.dev.pages.accounts.AccountsHome;
import com.salesforce.dev.pages.base.NavigationBar;
import com.salesforce.dev.pages.HomePage;
import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by Carlos Orellana on 8/22/2015.
 */
public class CreateAccountViewBasic {
    private static final Logger LOGGER = Logger.getLogger(CreateAccountViewBasic.class.getName());
    private AccountsHome accountsHome;
    private AccountView accountView;
    private HomePage homePage;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private AccountViewDetail accountViewDetail;

    @DataProvider(name = "dataDriven")
    public Iterator<ViewSalesForce[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataView("json/CreateAccountsViewBasic.json");
    }
    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
    }


    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testCreateCampaignView(ViewSalesForce viewSalesForce) {
        String viewName = viewSalesForce.getViewName() + RandomGenerator.getInstance().getRandomString();
        viewSalesForce.setViewName(viewName);
        accountsHome = navigationBar.goToAccountsHome();
        accountView = accountsHome.clickNewViewLnk()
                .setViewName(viewName)
                .setUniqueViewName(viewSalesForce.getUniqueViewName())
                .checkFilterByOwner(viewSalesForce.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForce.getRestrictVisibility());
        accountViewDetail = accountView.clickSaveBtn();
        LOGGER.info("Account was created");
        assertTrue(accountViewDetail.validateNameView(viewSalesForce.getViewName()));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        accountViewDetail.clickDeleteLnk(true);
        LOGGER.info("Account View was deleted");
    }
}
