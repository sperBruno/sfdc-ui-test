package com.salesforce.dev;

/**
 * Created by Luffy on 22/06/2015.
 */

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.TopHeader;

/**
 * Created by Walter on 13/06/2015.
 */
public class LogoutTest {
    private static final Logger LOGGER = Logger.getLogger(LogoutTest.class.getName());
    private MainPage mainPage;


    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
        HomePage homePage = new HomePage();
        mainPage = homePage.clickLoginBtn().loginAsPrimaryUser();
    }

    @Test(groups = {"BVT"})
    public void testLogout() {

        TopHeader topHeader = mainPage.gotoTopHeader();
        topHeader.clickUserNameMenu();
        LoginPage loginPage = topHeader.clickLogoutOption();

        Assert.assertEquals(loginPage.isLoginButtonPresent(), true);
        LOGGER.info("Logout from SalesForce");
    }

}
