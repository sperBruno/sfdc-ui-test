package com.salesforce.dev.login;

import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.TopHeader;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Walter on 13/06/2015.
 * @author Luffy on 22/06/2015.
 * @author Bruno Barrios.
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
