package com.salesforce.dev.accounts;

/**
 * Created by Walter Mercado on 6/22/2015.
 */

import com.salesforce.dev.framework.dto.Account;
import com.salesforce.dev.pages.accounts.AccountDetail;
import com.salesforce.dev.pages.accounts.AccountForm;
import com.salesforce.dev.pages.accounts.AccountsHome;
import com.salesforce.dev.pages.base.NavigationBar;
import com.salesforce.dev.pages.HomePage;
import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.framework.utils.DataDrivenManager;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.*;


/**
 * Created by Walter on 13/06/2015.
 */
public class CreateAccountDD {

    private MainPage mainPage;
    private HomePage homePage;
    private AccountDetail accountDetail;
    private NavigationBar navigationBar;

    @DataProvider(name = "dataDriven")
    public Iterator<Account[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getAccountsDD();
    }

    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
    }


    @Test(groups = {"Regression"}, dataProvider = "dataDriven")
    public void testCreateAccount(Account account) {
        AccountsHome accountsHome = navigationBar.goToAccountsHome();
        AccountForm accountForm = accountsHome.clickNewBtn()
                .setAccountNameFld(account.getAccountName())
                .setAccountDescriptionFld(account.getAccountDesc());

        accountDetail = accountForm.clickSaveBtn();

        Assert.assertTrue(accountDetail.validateAccountNameFld(account.getAccountName()));
        Assert.assertTrue(accountDetail.validateAccountDescriptionFld(account.getAccountDesc()));

    }

    @AfterMethod(groups = {"Regression"})
    public void tearDown() {
        accountDetail.clickDeleteBtn(true);

    }
}
