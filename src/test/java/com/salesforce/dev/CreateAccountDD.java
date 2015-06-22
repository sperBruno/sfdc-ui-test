package com.salesforce.dev;

/**
 * Created by Walter Mercado on 6/22/2015.
 */

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.Accounts.AccountDetail;
import com.salesforce.dev.pages.Accounts.AccountForm;
import com.salesforce.dev.pages.Accounts.AccountsHome;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.utils.DataDrivenManager;
import org.testng.Assert;
import org.testng.annotations.*;

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
    public Object[][] getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataDrivenAccount();
    }

    @BeforeClass
    public void setUp() {
        homePage = new HomePage();
        String userNameValue= Environment.getInstance().getPrimaryUser();
        String passwordValue=Environment.getInstance().getPrimaryPassword();
        mainPage = homePage.loginAs(userNameValue,passwordValue);

    }

    @Test(groups = {"Regression"}, dataProvider = "dataDriven")
    public void testCreateAccount(String accountName,String description) {
        NavigationBar navigationBar = mainPage.gotoNavBar();
        AccountsHome accountsHome = navigationBar.goToAccountsHome();
        AccountForm accountForm = accountsHome.clickNewBtn();
        accountForm.setAccountNameFld(accountName);
        accountForm.setAccountDescriptionFld(description);

        accountDetail = accountForm.clickSaveBtn();

        Assert.assertTrue(accountDetail.validateAccountNameFld(accountName));
        Assert.assertTrue(accountDetail.validateAccountDescriptionFld(description));

    }

    @AfterMethod(groups = {"Regression"})
    public void tearDown() {
        accountDetail.clickDeleteBtn(true);

    }
}
