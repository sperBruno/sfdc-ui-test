package com.salesforce.dev.login;

import org.testng.annotations.Test;

import com.salesforce.dev.framework.soap.UserInformation;
import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.TopHeader;

import static org.testng.Assert.assertEquals;

/**
 * This class will be used to test the login into SalesForce web application.
 *
 * @author Monica.
 * @author Bruno Barrios.
 * @since 6/22/2015
 */
public class LoginTest {

    @Test(groups = {"Smoke"})
    public void testLogin1() {
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        TopHeader topHeader = mainPage.gotoTopHeader();
        String expectedUser = UserInformation.getUserFullName();
        String actualUser = topHeader.getUserName();
        assertEquals(expectedUser, actualUser, actualUser + "is logged");
    }
}
