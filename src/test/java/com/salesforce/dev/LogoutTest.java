package com.salesforce.dev;

/**
 * Created by Luffy on 22/06/2015.
 */

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;

import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.TopHeader;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by Walter on 13/06/2015.
 */
public class LogoutTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private MainPage mainPage;


    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();
    }

    @Test(groups = {"BVT"})
    public void testCreateAccount() {
        TopHeader topHeader = mainPage.gotoTopHeader();
        String displayName= Environment.getInstance().getDisplayName();

        Assert.assertEquals(topHeader.isUserMenuPresent(),true);
        Assert.assertEquals(topHeader.getUserName(),displayName);
        topHeader.clickUserNameMenu();
        LoginPage loginPage = topHeader.clickLogoutOption();

        Assert.assertEquals(loginPage.isLoginButtonPresent(),true);

    }

}

