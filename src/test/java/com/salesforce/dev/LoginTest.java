package com.salesforce.dev;

import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.TopHeader;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.salesforce.dev.framework.utils.Constants.ENVIRONMENT;
import static org.testng.Assert.assertEquals;

/**
 * Created by monica on 6/22/2015.
 */
public class LoginTest {

    private static final Logger LOGGER = Logger.getLogger(LoginTest.class.getName());

    private LoginPage loginPage;

    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
        HomePage homePage = new HomePage();
        loginPage = homePage.clickLoginBtn();
    }

    @Test(groups = {"BVT"})
    public void testLogin() {
        MainPage mainPage = loginPage.loginAsPrimaryUser();
        TopHeader topHeader = mainPage.gotoTopHeader();
        assertEquals(topHeader.getUserName(), ENVIRONMENT.getDisplayName());
        LOGGER.info("Login on Sales Force");
    }
}