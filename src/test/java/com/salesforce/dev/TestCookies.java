package com.salesforce.dev;

import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.TopHeader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * This class will be used to test cookies from Salesforce web application.
 *
 * @author Marcelo Vargas.
 * @author Bruno Barrios.
 * @since 6/24/2015.
 */
public class TestCookies {

    private MainPage mainPage;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        mainPage = LoginPage.loginAsPrimaryUser();
    }

    @Test(groups = {"Acceptance"})
    public void testCookies() {
        TopHeader topHeader = mainPage.gotoTopHeader();
        assertTrue(topHeader.checkIfCookieIsPresent(),"Cookies not found");
    }
}
