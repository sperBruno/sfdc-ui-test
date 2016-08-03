package com.salesforce.dev.login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.TopHeader;

import static org.junit.Assert.assertTrue;

/**
 * This class will be used to test the logout option of Salesforce web application
 *
 * @author Walter.
 * @author Luffy.
 * @author Bruno Barrios.
 * @since 13/06/2015.
 */
public class LogoutTest {

    private MainPage mainPage;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        mainPage = LoginPage.loginAsPrimaryUser();
    }

    @Test(groups = {"Acceptance"})
    public void testLogout() {
        TopHeader topHeader = mainPage.gotoTopHeader();
        topHeader.clickUserNameMenu();
        LoginPage loginPage = topHeader.clickLogoutOption();
        assertTrue(loginPage.isLoginButtonPresent());
    }
}
