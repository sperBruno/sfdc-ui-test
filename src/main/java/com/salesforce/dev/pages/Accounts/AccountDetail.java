package com.salesforce.dev.pages.Accounts;

import java.util.HashMap;
import java.util.Map;

import com.salesforce.dev.pages.Base.DetailsBase;
import com.salesforce.dev.pages.MainPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.pages.Accounts.AccountSteps.*;

/**
 * Created by Walter on 10/06/2015.
 */
public class AccountDetail extends DetailsBase {

    @FindBy(id = "acc2_ilecell")
    private WebElement accountNameFld;

    @FindBy(id = "acc5_ileinner")
    private WebElement accountNumberFld;

    @FindBy(id = "acc23_ileinner")
    private WebElement accountSiteFld;

    @FindBy(id = "acc6_ileinner")
    private WebElement accountTypeFld;

    @FindBy(id = "acc7_ileinner")
    private WebElement accountIndustryFld;

    @FindBy(id = "acc8_ileinner")
    private WebElement accountAnnualRevenueFld;

    @FindBy(id = "acc17_ileinner")
    private WebElement accountBillingAddressFld;

    @FindBy(xpath = "//td[contains(.,'Customer Priority')]/following::div")
    private WebElement accountCustomPriorityFld;

    @FindBy(xpath = "//td[contains(.,'SLA Expiration Date')]/following::div")
    private WebElement accountSLAExpirationDateFld;

    @FindBy(xpath = "//td[contains(.,'Number of Locations')]/following::div")
    private WebElement accountNumberOfLocationsFld;

    @FindBy(xpath = "//td[contains(.,'Active')]/following::div")
    private WebElement accountActiveFld;

    @FindBy(id = "acc20_ileinner")
    private WebElement accountDescriptionFld;

    @FindBy(id = "acc9_ilecell")
    private WebElement accountRatingFld;

    @FindBy(id = "acc10_ileinner")
    private WebElement accountPhoneFld;

    @FindBy(id = "acc11_ilecell")
    private WebElement accountFaxFld;

    @FindBy(id = "acc12_ilecell")
    private WebElement accountWebsiteFld;

    @FindBy(id = "acc13_ilecell")
    private WebElement accountTickerSymbolFld;

    @FindBy(id = "acc14_ileinner")
    private WebElement accountOwnershipFld;

    @FindBy(id = "acc15_ileinner")
    private WebElement accountEmployeesFld;

    @FindBy(id = "acc16_ileinner")
    private WebElement accountSICCodeFld;

    @FindBy(id = "acc18_ileinner")
    private WebElement accountShippingAddressFld;

    @FindBy(xpath = "//td[contains(.,'SLA')]/following::div")
    private WebElement accountSLAFld;

    @FindBy(xpath = "//td[contains(.,'SLA Serial Number')]/following::div")
    private WebElement accountSerialNumberFld;

    @FindBy(xpath = "//td[contains(.,'Upsell Opportunity')]/following::div")
    private WebElement accountUpSellOpportunityFld;

    @Override
    public AccountForm clickEditBtn() {
        clickEditButton();
        return new AccountForm();
    }

    @Override
    public AccountsHome clickDeleteBtn(boolean confirmDeletion) {
        clickDeletedAccButton(true);
        return new AccountsHome();

    }

    public MainPage gotoMainPage() {
        return new MainPage();
    }

    public String validateAccountNameFld() {
        String realValue = accountNameFld.getText().substring(0, accountNameFld.getText().length() - 17);
        return realValue;
    }

    public String validateAccountNumberFld() {
        return accountNumberFld.getText();
    }

    public String validateAccountSiteFld() {
        return accountSiteFld.getText();
    }

    public String validateAccountTypeFld() {
        return accountTypeFld.getText();
    }

    public String validateAccountIndustryFld() {
        return accountIndustryFld.getText();
    }

    public String validateAccountAnnualRevenueFld() {
        String realValue = accountAnnualRevenueFld.getText().replaceAll("[-+.^:,]", "");
        return realValue.substring(1);
    }

    public String validateAccountBillingAddressFld() {
        return accountBillingAddressFld.getText();
    }

    public String validateAccountCustomPriorityFld() {
        return accountCustomPriorityFld.getText();
    }

    public String validateAccountSLAExpirationDateFld() {
        return accountSLAExpirationDateFld.getText();
    }

    public String validateAccountNumberOfLocationsFld() {
        return accountNumberOfLocationsFld.getText();
    }

    public String validateAccountActiveFld() {
        return accountActiveFld.getText();
    }

    public String validateAccountDescriptionFld() {
        return accountDescriptionFld.getText();
    }

    public String validateAccountRatingFld() {
        return accountRatingFld.getText();
    }

    public String validateAccountPhoneFld() {
        return accountPhoneFld.getText();
    }

    public String validateAccountFaxFld() {
        return accountFaxFld.getText();
    }

    public String validateAccountWebsiteFld() {
        return accountWebsiteFld.getText();
    }

    public String validateAccountTickerSymbolFld() {
        return accountTickerSymbolFld.getText();
    }

    public String validateAccountOwnershipFld() {
        return accountOwnershipFld.getText();
    }

    public String validateAccountEmployeesFld() {
        String realValue = accountEmployeesFld.getText().replaceAll("[-+.^:,]", "");
        return realValue;
    }

    public String validateAccountSICCodeFld() {
        return accountSICCodeFld.getText();
    }

    public String validateAccountShippingAddressFld() {
        return accountShippingAddressFld.getText();
    }

    public String validateAccountSLAFld() {
        return accountSLAFld.getText();
    }

    public String validateAccountSerialNumberFld() {
        return accountSerialNumberFld.getText();
    }

    public String validateAccountUpSellOpportunityFld() {
        return accountUpSellOpportunityFld.getText();
    }

    public Map<AccountSteps, Object> getAssertionMap() {
        Map<AccountSteps, Object> assertionMap = new HashMap<>();
        assertionMap.put(ACCOUNT_NAME, validateAccountNameFld());
        assertionMap.put(ACCOUNT_RATING, validateAccountRatingFld());
        assertionMap.put(ACCOUNT_OWNER_SHIP, validateAccountOwnershipFld());
        assertionMap.put(ACCOUNT_PHONE, validateAccountPhoneFld());
        assertionMap.put(ACCOUNT_FAX, validateAccountFaxFld());
        assertionMap.put(ACCOUNT_NUMBER, validateAccountNumberFld());
        assertionMap.put(ACCOUNT_WEBSITE, validateAccountWebsiteFld());
        assertionMap.put(ACCOUNT_SITE, validateAccountSiteFld());
        assertionMap.put(ACCOUNT_THICKER, validateAccountTickerSymbolFld());
        assertionMap.put(ACCOUNT_TYPE, validateAccountTypeFld());
        assertionMap.put(ACCOUNT_INDUSTRY, validateAccountIndustryFld());
        assertionMap.put(ACCOUNT_EMPLOYEES, validateAccountEmployeesFld());
        assertionMap.put(ACCOUNT_ANNUAL_REVENUE, validateAccountAnnualRevenueFld());
        assertionMap.put(ACCOUNT_SICCODE, validateAccountSICCodeFld());
        assertionMap.put(ACCOUNT_BILLING_STREET, validateAccountBillingAddressFld());
        assertionMap.put(ACCOUNT_SHIPPING_STREET, validateAccountShippingAddressFld());
        assertionMap.put(ACCOUNT_CUSTOMER_PRIORITY, validateAccountCustomPriorityFld());
        assertionMap.put(ACCOUNT_SLA, validateAccountSLAFld());
        assertionMap.put(ACCOUNT_ACTIVE, validateAccountActiveFld());
        assertionMap.put(ACCOUNT_SLA_EXPIRATION_DATE, validateAccountSLAExpirationDateFld());
        assertionMap.put(ACCOUNT_SLASERIAL_NUMBER, validateAccountSerialNumberFld());
        assertionMap.put(ACCOUNT_NUMBER_LOCATIONS, validateAccountNumberOfLocationsFld());
        assertionMap.put(ACCOUNT_DESCRIPTION, validateAccountDescriptionFld());
        return assertionMap;
    }
}
