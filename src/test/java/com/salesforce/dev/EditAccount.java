package com.salesforce.dev;

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.Accounts.AccountDetail;
import com.salesforce.dev.pages.Accounts.AccountForm;
import com.salesforce.dev.pages.Accounts.AccountsHome;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Walter on 13/06/2015.
 */
public class EditAccount {

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
    public void testEditAccount() {
        NavigationBar navigationBar = mainPage.gotoNavBar();
        AccountsHome accountsHome = navigationBar.clickAccountTab();
        AccountDetail accountDetail = accountsHome.selectRecentItem(accountName);
        AccountForm accountForm = accountDetail.clickEditBtn();
        accountForm.setAccountNumberFld(accountName+"update");
        accountForm.setAccountDescriptionFld(accountDesc+"update");
        accountDetail = accountForm.clickSaveBtn();
       // Assert.assertTrue(accountDetail.VerifyProduct(productName), "product Was not Created");

    }

    @AfterMethod
    public void tearDown() {
        //productDetails.DeleteProduct();

    }
}
