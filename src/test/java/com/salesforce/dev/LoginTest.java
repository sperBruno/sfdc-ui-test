package com.salesforce.dev;

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.TopHeader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by monica on 6/22/2015.
 */
public class LoginTest {
    HomePage homePage;
    MainPage mainPage;
    LoginPage loginPage;
    TopHeader topHeader;
    NavigationBar navigationBar;


    @BeforeMethod(groups = {"Regression"})
    public void setUp(){
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();
        topHeader = mainPage.gotoTopHeader();
        topHeader.clickUserNameMenu();
        loginPage=topHeader.clickLogoutOption();
    }
    @Test(groups = {"BVT"})
    public void Login(){
        String account = Environment.getInstance().getPrimaryUser();
        String password = Environment.getInstance().getPrimaryPassword();
        String displayName=Environment.getInstance().getDisplayName();
        loginPage.setUserName(account);
        loginPage.setPassword(password);
        mainPage=loginPage.clickLoginBtn();
        topHeader=mainPage.gotoTopHeader();
        Assert.assertEquals(topHeader.getUserName(),displayName);

    }

}