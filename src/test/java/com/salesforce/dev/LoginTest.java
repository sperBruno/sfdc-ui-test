package com.salesforce.dev;

import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.TopHeader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.salesforce.dev.framework.utils.Constants.ENVIRONMENT;
import static com.salesforce.dev.framework.utils.Constants.LOGGER_MANAGER;
import static org.testng.Assert.assertEquals;

/**
 * Created by monica on 6/22/2015.
 */
public class LoginTest {

    private static final String LOGIN_TEST = LoginTest.class.getName();

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
        LOGGER_MANAGER.addInfoLog(LOGIN_TEST, "Login on Sales Force");
    }
}