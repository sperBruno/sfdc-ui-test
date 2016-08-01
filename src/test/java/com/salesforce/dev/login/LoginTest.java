package com.salesforce.dev.login;

import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.TopHeader;
import com.salesforce.dev.pages.objects.UserInformation;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author monica on 6/22/2015.
 * @author Bruno Barrios
 */
public class LoginTest {

    @Test(groups = {"BVT"})
    public void testLogin1() {
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        TopHeader topHeader = mainPage.gotoTopHeader();
        String expectedUser = UserInformation.getUserFullName();
        String actualUser = topHeader.getUserName();
        assertEquals(expectedUser, actualUser, actualUser + "is logged");
    }


}