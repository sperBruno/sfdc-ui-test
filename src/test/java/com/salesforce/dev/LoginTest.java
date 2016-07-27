package com.salesforce.dev;

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.framework.LoggerManager;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.TopHeader;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by monica on 6/22/2015.
 */
public class LoginTest {
    HomePage homePage;
    MainPage mainPage;
    LoginPage loginPage;
    TopHeader topHeader;

    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
        homePage = new HomePage();
        loginPage = homePage.clickLoginBtn();
    }

    @Test(groups = {"BVT"})
    public void testLogin() {
        mainPage = loginPage.loginAs(Environment.getInstance().getPrimaryUser(), Environment.getInstance().getPrimaryPassword());
        topHeader = mainPage.gotoTopHeader();
        Assert.assertEquals(topHeader.getUserName(), Environment.getInstance().getDisplayName());
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Login on Sales Force");
    }

}