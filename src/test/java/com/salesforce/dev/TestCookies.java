package com.salesforce.dev;

import com.salesforce.dev.framework.LoggerManager;
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

    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();
    }

    @Test(groups = {"BVT"})
    public void testCookies() {
        topHeader = mainPage.gotoTopHeader();

        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Verifying Cookies");

        Assert.assertTrue(topHeader.checkIfCookieIsPresent());
    }

    @AfterMethod(groups = {"BVT"})
    public void tearDown() {
        //something
    }
}
