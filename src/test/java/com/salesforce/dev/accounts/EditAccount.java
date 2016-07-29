package com.salesforce.dev.accounts;

import com.salesforce.dev.framework.dto.Account;
import com.salesforce.dev.framework.utils.JSONMapper;
import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.accounts.AccountDetail;
import com.salesforce.dev.pages.accounts.AccountForm;
import com.salesforce.dev.pages.accounts.AccountsHome;
import com.salesforce.dev.pages.base.NavigationBar;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by Walter on 13/06/2015.
 */
public class EditAccount {

    private AccountDetail accountDetail;
    private NavigationBar navigationBar;
    private AccountsHome accountsHome;
    private AccountForm accountForm;
    private Account account = JSONMapper.getAccountBase();
    private String accountName = "AccountName";

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        accountsHome = navigationBar.goToAccountsHome();
        accountForm = accountsHome.clickNewBtn();
        accountForm.setAccountNameFld(accountName);
        accountDetail = accountForm.clickSaveBtn();
        mainPage = accountDetail.gotoMainPage();
        navigationBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"Acceptance"})
    public void testEditAccount() {
        accountsHome = navigationBar.goToAccountsHome();
        accountDetail = accountsHome.selectRecentItem(accountName);
        accountForm = accountDetail.clickEditBtn()
                .setAccountNameFld(account.getAccountName())
                .setAccountRatingFld(account.getRating())
                .setAccountOwnershipFld(account.getOwnership())
                .setAccountPhoneFld(account.getPhone())
                .setAccountFaxFld(account.getFax())
                .setAccountNumberFld(account.getNumber())
                .setAccountWebsiteFld(account.getWebsite())
                .setAccountSiteFld(account.getAccountSite())
                .setAccountThickerFld(account.getTickerSymbol())
                .setAccountTypeFld(account.getType())
                .setAccountIndustryFld(account.getIndustry())
                .setAccountEmployeesFld(account.getEmployees())
                .setAccountAnnualRevenueFld(account.getAnnualRevenue())
                .setAccountSICCodeFld(account.getSicCode())
                .setAccountBillingStreetFld(account.getBillingAddress())
                .setAccountShippingStreetFld(account.getShippingAddress())
                .setAccountCustomerPriorityFld(account.getCustomerPriority())
                .setAccountSLAFld(account.getSla())
                //.setAccountUpsellOpportunityFld(account.getUpSellOpportunity()) //JsonMapper error not loading
                .setAccountActiveFld(account.getActive())
                .setAccountSLAExpirationDateFld(account.getSlaExpirationDate())
                .setAccountSLASerialNumberFld(account.getSlaSerialNumber())
                .setAccountNumberLocationsFld(account.getNumberOfLocations())
                .setAccountDescriptionFld(account.getAccountDesc());
        accountDetail = accountForm.clickSaveBtn();

        assertTrue(accountDetail.validateAccountNameFld(account.getAccountName()));
        assertTrue(accountDetail.validateAccountRatingFld(account.getRating()));
        assertTrue(accountDetail.validateAccountOwnershipFld(account.getOwnership()));
        assertTrue(accountDetail.validateAccountPhoneFld(account.getPhone()));
        assertTrue(accountDetail.validateAccountFaxFld(account.getFax()));
        assertTrue(accountDetail.validateAccountNumberFld(account.getNumber()));
        assertTrue(accountDetail.validateAccountWebsiteFld(account.getWebsite()));
        assertTrue(accountDetail.validateAccountSiteFld(account.getAccountSite()));
        assertTrue(accountDetail.validateAccountTickerSymbolFld(account.getTickerSymbol()));
        assertTrue(accountDetail.validateAccountTypeFld(account.getType()));
        assertTrue(accountDetail.validateAccountIndustryFld(account.getIndustry()));
        assertTrue(accountDetail.validateAccountEmployeesFld(account.getEmployees()));
        assertTrue(accountDetail.validateAccountAnnualRevenueFld(account.getAnnualRevenue()));
        assertTrue(accountDetail.validateAccountSICCodeFld(account.getSicCode()));
        assertTrue(accountDetail.validateAccountBillingAddressFld(account.getBillingAddress()));
        assertTrue(accountDetail.validateAccountShippingAddressFld(account.getShippingAddress()));
        assertTrue(accountDetail.validateAccountCustomPriorityFld(account.getCustomerPriority()));
        assertTrue(accountDetail.validateAccountSLAFld(account.getSla()));
        assertTrue(accountDetail.validateAccountActiveFld(account.getActive()));
        assertTrue(accountDetail.validateAccountSLAExpirationDateFld(account.getSlaExpirationDate()));
        assertTrue(accountDetail.validateAccountSerialNumberFld(account.getSlaSerialNumber()));
        assertTrue(accountDetail.validateAccountNumberOfLocationsFld(account.getNumberOfLocations()));
        assertTrue(accountDetail.validateAccountDescriptionFld(account.getAccountDesc()));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        accountDetail.clickDeleteBtn(true);
    }
}
