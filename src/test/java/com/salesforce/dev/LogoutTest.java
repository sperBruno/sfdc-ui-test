package com.salesforce.dev;

/**
 * Created by Luffy on 22/06/2015.
 */

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.framework.LoggerManager;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;

import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.TopHeader;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by Walter on 13/06/2015.
 */
public class LogoutTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private MainPage mainPage;
    private TopHeader topHeader;


    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
        homePage = new HomePage();
        mainPage = homePage.getLogin();
    }

    @Test(groups = {"BVT"})
    public void testLogout() {

        topHeader = mainPage.gotoTopHeader();
        topHeader.clickUserNameMenu();
        loginPage = topHeader.clickLogoutOption();

        Assert.assertEquals(loginPage.isLoginButtonPresent(), true);
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Logout from SalesForce");
    }

}

