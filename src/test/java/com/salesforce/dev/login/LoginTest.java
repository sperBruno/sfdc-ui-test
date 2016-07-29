package com.salesforce.dev.login;

import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.objects.UserInformation;
import com.salesforce.dev.pages.TopHeader;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by monica on 6/22/2015.
 */
public class LoginTest {

    private static final Logger LOGGER = Logger.getLogger(LoginTest.class.getName());

    private MainPage mainPage;

    @Test(groups = {"BVT"})
    public void testLogin1() {
        mainPage = LoginPage.loginAsPrimaryUser();
        TopHeader topHeader = mainPage.gotoTopHeader();
        assertEquals(topHeader.getUserName(), UserInformation.getUserFullName());
        LOGGER.info("Login on Sales Force");
    }


}