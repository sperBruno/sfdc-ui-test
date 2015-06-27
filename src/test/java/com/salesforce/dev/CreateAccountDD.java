package com.salesforce.dev;

/**
 * Created by Walter Mercado on 6/22/2015.
 */

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.framework.Objects.Account;
import com.salesforce.dev.pages.Accounts.AccountDetail;
import com.salesforce.dev.pages.Accounts.AccountForm;
import com.salesforce.dev.pages.Accounts.AccountsHome;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.framework.DataDrivenManager;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Iterator;

/**
 * Created by Walter on 13/06/2015.
 */
public class CreateAccountDD {

    private LoginPage loginPage;

    private HomePage homePage;
    private MainPage mainPage;
    private AccountDetail accountDetail;
    private NavigationBar navigationBar;

    @DataProvider(name = "dataDriven")
    public Iterator<Account[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getAccountsDD();
    }

    @BeforeMethod(groups = {"Regression"})
    public void setUp() {
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();
    }

    @Test(groups = {"Regression"}, dataProvider = "dataDriven")
    public void testCreateAccount(Account account) {

        NavigationBar navigationBar = mainPage.gotoNavBar();
        AccountsHome accountsHome = navigationBar.goToAccountsHome();
        AccountForm accountForm = accountsHome.clickNewBtn();
        accountForm.setAccountNameFld(account.getAccountName());
        accountForm.setAccountDescriptionFld(account.getAccountDesc());

        accountDetail = accountForm.clickSaveBtn();

        Assert.assertTrue(accountDetail.validateAccountNameFld(account.getAccountName()));
        Assert.assertTrue(accountDetail.validateAccountDescriptionFld(account.getAccountDesc()));

    }

    @AfterMethod(groups = {"Regression"})
    public void tearDown() {
        accountDetail.clickDeleteBtn(true);

    }
}
