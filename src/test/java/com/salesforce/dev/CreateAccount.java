package com.salesforce.dev;

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.AccountPage.AccountDetail;
import com.salesforce.dev.pages.AccountPage.AccountForm;
import com.salesforce.dev.pages.AccountPage.AccountsHome;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Walter Mercado on 13/06/2015.
 */
public class CreateAccount {

    private LoginPage loginPage;

    private HomePage homePage;
    private MainPage mainPage;
    private AccountDetail accountDetail;
    private NavigationBar navigationBar;
    private String accountName ="AccountName1";
    private String accountDesc ="Account Desc";



    @BeforeMethod
    public void setUp() {
        homePage = new HomePage();
        String userNameValue= Environment.getInstance().getPrimaryUser();
        String passwordValue=Environment.getInstance().getPrimaryPassword();
        mainPage = homePage.loginAs(userNameValue,passwordValue);

    }

    @Test
    public void testCreateProduct() {
        NavigationBar navigationBar = mainPage.gotoNavBar();
        AccountsHome accountsHome = navigationBar.clickAccountTab();
        AccountForm accountForm = accountsHome.clickNewBtn();
        accountForm.setAccountNumberFld(accountName);
        accountForm.setAccountDescriptionFld(accountDesc);
        accountDetail = accountForm.clickSaveBtn();
       // Assert.assertTrue(accountDetail.VerifyProduct(productName), "product Was not Created");

    }

    @AfterMethod
    public void tearDown() {
        //productDetails.DeleteProduct();

    }
}
