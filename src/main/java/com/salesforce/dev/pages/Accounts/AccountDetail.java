package com.salesforce.dev.pages.Accounts;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.DetailsBase;

import com.salesforce.dev.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    private WebElement accountUpsellOportunityFld;


    public AccountDetail(WebDriver driver) {
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(super.driver, this);
    }

    @Override
    public AccountForm clickEditBtn() {
        clickEditButton();
        return new AccountForm(driver);
    }

    @Override
    public AccountsHome clickDeleteBtn(boolean confirmDeletion) {
        clickDeletedAccButton(true);
        return new AccountsHome(driver);

    }

    public MainPage gotoMainPage(){
        return new MainPage(driver);
    }

    public Boolean validateAccountNameFld(String value) {
        String realValue = accountNameFld.getText().substring(0, accountNameFld.getText().length() - 17);
        return realValue.equals(value);
    }

    public Boolean validateAccountNumberFld(String value) {
        return accountNumberFld.getText().equals(value);
    }

    public Boolean validateAccountSiteFld(String value) {
        return accountSiteFld.getText().equals(value);
    }

    public Boolean validateAccountTypeFld(String value) {
        return accountTypeFld.getText().equals(value);
    }

    public Boolean validateAccountIndustryFld(String value) {
        return accountIndustryFld.getText().equals(value);
    }

    public Boolean validateAccountAnnualRevenueFld(Integer value) {
        String realValue = accountAnnualRevenueFld.getText().replaceAll("[-+.^:,]", "");

        return realValue.substring(1).toString().equals(value.toString());
    }

    public Boolean validateAccountBillingAddressFld(String value) {
        return accountBillingAddressFld.getText().equals(value);
    }

    public Boolean validateAccountCustomPriorityFld(String value) {
        return accountCustomPriorityFld.getText().equals(value);
    }

    public Boolean validateAccountSLAExpirationDateFld(String value) {
        return accountSLAExpirationDateFld.getText().equals(value);
    }

    public Boolean validateAccountNumberOfLocationsFld(Integer value) {
        return accountNumberOfLocationsFld.getText().equals(value.toString());
    }

    public Boolean validateAccountActiveFld(String value) {
        return accountActiveFld.getText().equals(value);
    }

    public Boolean validateAccountDescriptionFld(String value) {
        return accountDescriptionFld.getText().equals(value);
    }

    public Boolean validateAccountRatingFld(String value) {
        return accountRatingFld.getText().equals(value);
    }

    public Boolean validateAccountPhoneFld(String value) {
        return accountPhoneFld.getText().equals(value);
    }

    public Boolean validateAccountFaxFld(String value) {
        return accountFaxFld.getText().equals(value);
    }

    public Boolean validateAccountWebsiteFld(String value) {
        return accountWebsiteFld.getText().equals(value);
    }

    public Boolean validateAccountTickerSymbolFld(String value) {
        return accountTickerSymbolFld.getText().equals(value);
    }

    public Boolean validateAccountOwnershipFld(String value) {
        return accountOwnershipFld.getText().equals(value);
    }

    public Boolean validateAccountEmployeesFld(Integer value) {
        String realValue = accountEmployeesFld.getText().replaceAll("[-+.^:,]", "");
        return realValue.equals(value.toString());
    }

    public Boolean validateAccountSICCodeFld(String value) {
        return accountSICCodeFld.getText().equals(value);
    }

    public Boolean validateAccountShippingAddressFld(String value) {
        return accountShippingAddressFld.getText().equals(value);
    }

    public Boolean validateAccountSLAFld(String value) {
        return accountSLAFld.getText().equals(value);
    }

    public Boolean validateAccountSerialNumberFld(String value) {
        return accountSerialNumberFld.getText().equals(value);
    }

    public Boolean validateAccountUpSellOpportunityFld(String value) {
        return accountUpsellOportunityFld.getText().equals(value);
    }

}
