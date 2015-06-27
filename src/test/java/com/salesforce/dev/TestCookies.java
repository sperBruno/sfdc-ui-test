package com.salesforce.dev;

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.TopHeader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Marcelo.Vargas on 6/24/2015.
 */
public class TestCookies {
    private HomePage homePage;
    private MainPage mainPage;
    private TopHeader topHeader;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();
    }

    @Test(groups = {"Acceptance"})
    public void testCookies() {
        topHeader = mainPage.gotoTopHeader();
        Assert.assertTrue(topHeader.checkIfCookieIsPresent());
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        //something
    }
}
