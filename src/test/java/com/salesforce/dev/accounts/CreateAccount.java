package com.salesforce.dev.accounts;

import java.util.Map;

import com.salesforce.dev.framework.dto.Account;
import com.salesforce.dev.framework.utils.JSONMapper;
import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.accounts.AccountDetail;
import com.salesforce.dev.pages.accounts.AccountForm;
import com.salesforce.dev.pages.accounts.AccountSteps;
import com.salesforce.dev.pages.accounts.AccountsHome;
import com.salesforce.dev.pages.base.NavigationBar;
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
    private Account account = JSONMapper.getAccountBase();

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        mainPage = LoginPage.loginAsPrimaryUser();
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
