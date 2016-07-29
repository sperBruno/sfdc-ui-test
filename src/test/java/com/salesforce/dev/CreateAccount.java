package com.salesforce.dev;

import java.util.Map;

import com.salesforce.dev.framework.JSONMapper;
import com.salesforce.dev.framework.Objects.Account;
import com.salesforce.dev.pages.Accounts.AccountDetail;
import com.salesforce.dev.pages.Accounts.AccountForm;
import com.salesforce.dev.pages.Accounts.AccountSteps;
import com.salesforce.dev.pages.Accounts.AccountsHome;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Walter on 13/06/2015.
 */
public class CreateAccount {

    private MainPage mainPage;
    private AccountDetail accountDetail;
    private HomePage homePage;
    private NavigationBar navigationBar;
    private Account account = JSONMapper.getAccountBase();
    private LoginPage loginPage;

    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
        mainPage = loginPage.loginAsPrimaryUser();
    }

    @Test(groups = {"Acceptance"})
    public void testCreateAccount() {
        NavigationBar navigationBar = mainPage.gotoNavBar();
        AccountsHome accountsHome = navigationBar.goToAccountsHome();
        AccountForm accountForm = accountsHome.clickNewBtn();
        Map<AccountSteps, Object> mapAccount =account.convertToMap();
        mapAccount.keySet().stream().forEach((step) -> {
            accountForm.getStrategyStepMap(mapAccount).get(step).executeStep();
        });

        accountDetail = accountForm.clickSaveBtn();
        Map<AccountSteps, Object> mapExpected = accountDetail.getAssertionMap();

        mapAccount.keySet().stream().forEach((step) -> {
            assertEquals(String.valueOf(mapExpected.get(step)), String.valueOf(mapAccount.get(step)));
        });
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        accountDetail.clickDeleteBtn(true);

    }
}
