package com.salesforce.dev.pages.AccountPage;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Walter Mercado on 10/06/2015.
 */
public class AccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private String accountName, parentAccount, accountNumber, accountSite, accountType, accountIndustry;
    private String accountRating, accountPhone, accountFax, accountWebsite, accountThicker, accountOwnership,accountSICCode;
    private String accountBillingStreet,accountShippingStreet,accountBillingCity,accountShippingCity;
    private String accountBillingState,accountShippingState,accountBillingZip,accountShippingZip,accountBillingCountry;
    private String accountShippingCountry,accountCustomerPriority,accountSLA, accountSLASerialNumber;
    private String accountUpsellOpportunity, accountDescription;
    private Boolean accountActive;
    private Integer accountEmployees, accountAnnualRevenue, accountNumberLocations;
    private Date accountSLAExpirationDate;

    //Account Information

    @FindBy(name = "acc2")
    private WebElement accountNameFld;

    @FindBy(id = "acc3")
    private WebElement parentAccountFld;

    @FindBy(id = "acc5")
    private WebElement accountNumberFld;

    @FindBy(id = "acc23")
    private WebElement accountSiteFld;

    @FindBy(id = "acc6")
    private WebElement accountTypeFld;

    @FindBy(id = "acc7")
    private WebElement accountIndustryFld;

    @FindBy(id = "acc8")
    private WebElement accountAnnualRevenueFld;

    @FindBy(id = "acc9")
    private WebElement accountRatingFld;

    @FindBy(id = "acc10")
    private WebElement accountPhoneFld;

    @FindBy(id = "acc11")
    private WebElement accountFaxFld;

    @FindBy(id = "acc12")
    private WebElement accountWebsiteFld;

    @FindBy(id = "acc13")
    private WebElement accountThickerFld;

    @FindBy(id = "acc14")
    private WebElement accountOwnershipFld;

    @FindBy(id = "acc15")
    private WebElement accountEmployeesFld;

    @FindBy(id = "acc16")
    private WebElement accountSICCodeFld;

    //AddressAddress Information

    @FindBy(id = "acc17street")
    private WebElement accountBillingStreetFld;

    @FindBy(id = "acc17city")
    private WebElement accountBillingCityFld;

    @FindBy(id = "acc17state")
    private WebElement accountBillingStateFld;

    @FindBy(id = "acc17zip")
    private WebElement accountBillingZipFld;

    @FindBy(id = "acc17country")
    private WebElement accountBillingCountryFld;

    @FindBy(id = "acc18street")
    private WebElement accountShippingStreetFld;

    @FindBy(id = "acc18city")
    private WebElement accountShippingCityFld;

    @FindBy(id = "acc18state")
    private WebElement accountShippingStateFld;

    @FindBy(id = "acc18zip")
    private WebElement accountShippingZipFld;

    @FindBy(id = "acc18country")
    private WebElement accountShippingCountryFld;

    // Additional Information

    @FindBy(id = "00N1a0000058Wdm")
    private WebElement accountCustomerPriorityFld;

    @FindBy(id = "00N1a0000058Wdp")
    private WebElement accountSLAExpirationDateFld;

    @FindBy(id = "00N1a0000058Wdn")
    private WebElement accountNumberLocationsFld;

    @FindBy(id = "00N1a0000058Wdl")
    private WebElement accountActiveFld;

    @FindBy(id = "00N1a0000058Wdo")
    private WebElement accountSLAFld;

    @FindBy(id = "00N1a0000058Wdq")
    private WebElement accountSLASerialNumberFld;

    @FindBy(id = "00N1a0000058Wdr")
    private WebElement accountUpsellOpportunityFld;

    //Description Information

    @FindBy(name = "acc20")
    private WebElement accountDescriptionFld;

    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveBtn;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        try {
            wait.withTimeout(10, TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(saveBtn));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(15, TimeUnit.SECONDS);
        }
    }

    public AccountPage(AccountBuilder builder) {

        this.driver = DriverManager.getInstance().getDriver();
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);

        this.accountName = builder.getAccountName();
        this.parentAccount = builder.getParentAccount();
        this.accountNumber = builder.getAccountNumber();
        this.accountSite = builder.getAccountSite();
        this.accountType = builder.getAccountType();
        this.accountIndustry = builder.getAccountIndustry();
        this.accountRating = builder.getAccountRating();
        this.accountPhone = builder.getAccountPhone();
        this.accountFax = builder.getAccountFax();
        this.accountWebsite = builder.getAccountWebsite();
        this.accountThicker = builder.getAccountThicker();
        this.accountOwnership = builder.getAccountOwnership();
        this.accountSICCode = builder.getAccountSICCode();
        this.accountBillingStreet = builder.getAccountBillingStreet();
        this.accountShippingStreet = builder.getAccountShippingStreet();
        this.accountBillingCity = builder.getAccountBillingCity();
        this.accountShippingCity = builder.getAccountShippingCity();
        this.accountBillingState = builder.getAccountBillingState();
        this.accountShippingState = builder.getAccountShippingState();
        this.accountBillingZip = builder.getAccountBillingZip();
        this.accountShippingZip = builder.getAccountShippingZip();
        this.accountBillingCountry = builder.getAccountBillingCountry();
        this.accountShippingCountry = builder.getAccountShippingCountry();
        this.accountCustomerPriority = builder.getAccountCustomerPriority();
        this.accountSLA = builder.getAccountSLA();
        this.accountSLASerialNumber = builder.getAccountSLASerialNumber();
        this.accountUpsellOpportunity = builder.getAccountUpsellOpportunity();
        this.accountActive = builder.getAccountActive();
        this.accountDescription = builder.getAccountDescription();
        this.accountEmployees = builder.getAccountEmployees();
        this.accountAnnualRevenue = builder.getAccountAnnualRevenue();
        this.accountNumberLocations = builder.getAccountNumberLocations();
        this.accountSLAExpirationDate = builder.getAccountSLAExpirationDate();

    }

    public AccountDetail saveAccount() {
        if(accountName!= null) {
            setAccountNameFld(accountName);
        }
        if(parentAccount != null) {
            setAccountNumberFld(parentAccount); // toreview
        }
        if(accountNumber != null) {
            setAccountNumberFld(accountNumber);
        }
        if(accountSite != null ) {
            setAccountSiteFld(accountSite);
        }
        if(accountType != null) {
            setAccountTypeFld(accountType);
        }
        if(accountIndustry!= null) {
            setAccountIndustryFld(accountIndustry);
        }
        if(accountRating!= null) {
            setAccountRatingFld(accountRating);
        }
        if(accountPhone!= null) {
            setAccountPhoneFld(accountPhone);
        }
        if(accountFax!= null) {
            setAccountFaxFld(accountFax);
        }
        if(accountWebsite!= null) {
            setAccountWebsiteFld(accountWebsite);
        }
        if(accountThicker!= null) {
            setAccountThickerFld(accountThicker);
        }
        if(accountOwnership!= null) {
            setAccountOwnershipFld(accountOwnership);
        }
        if(accountSICCode!= null) {
            setAccountSICCodeFld(accountSICCode);
        }
        if(accountBillingStreet!= null) {
            setAccountBillingStreetFld(accountBillingStreet);
        }
        if(accountShippingStreet!= null) {
            setAccountShippingStreetFld(accountShippingStreet);
        }
        if(accountBillingCity!= null) {
            setAccountBillingCityFld(accountBillingCity);
        }
        if(accountShippingCity!= null) {
            setAccountShippingCityFld(accountShippingCity);
        }
        if(accountBillingState!= null) {
            setAccountBillingStateFld(accountBillingState);
        }
        if(accountShippingState!= null) {
            setAccountShippingStateFld(accountShippingState);
        }
        if(accountBillingZip!= null) {
            setAccountBillingZipFld(accountBillingZip);
        }
        if(accountShippingZip!= null) {
            setAccountShippingZipFld(accountShippingZip);
        }
        if(accountBillingCountry!= null) {
            setAccountBillingCountryFld(accountBillingCountry);
        }
        if(accountShippingCountry!= null) {
            setAccountShippingCountryFld(accountShippingCountry);
        }
        if(accountCustomerPriority!= null) {
            setAccountCustomerPriorityFld(accountCustomerPriority);
        }
        if(accountSLA!= null) {
            setAccountSLAFld(accountSLA);
        }
        if(accountSLASerialNumber!= null) {
            setAccountSLASerialNumberFld(accountSLASerialNumber);
        }
        if(accountUpsellOpportunity!= null) {
            setAccountUpsellOpportunityFld(accountUpsellOpportunity);
        }
        if(accountDescription!= null) {
            setAccountDescriptionFld(accountDescription);
        }
        /*if(!accountActive) {
            setAccountActiveFld();
        }*/

        if(accountEmployees!= null) {
            setAccountEmployeesFld(accountEmployees.toString());
        }
        if(accountAnnualRevenue!= null) {
            setAccountAnnualRevenueFld(accountAnnualRevenue.toString());
        }
        if(accountNumberLocations!= null) {
            setAccountNumberLocationsFld(accountNumberLocations.toString());
        }
        if(accountSLAExpirationDate!= null) {
            setAccountSLAExpirationDateFld(accountSLAExpirationDate.toString());
        }
        return clickSaveBtn();
    }

    public AccountDetail clickSaveBtn() {
        saveBtn.click();
        return new AccountDetail(driver);
    }

    public void setDriver(WebDriver driver) {
       this.driver = driver;
    }

    public void setAccountNameFld(String accountName) {
        accountNameFld.clear();
        accountNameFld.sendKeys(accountName);
    }

    public void setAccountNumberFld(String accountNumber) {
        accountNumberFld.clear();
        accountNumberFld.sendKeys(accountNumber);
    }

    public void setAccountSiteFld(String accountSite) {
        accountSiteFld.clear();
        accountSiteFld.sendKeys(accountSite);
    }

    public void setAccountTypeFld(String accountType) {
        accountTypeFld.clear();
        accountTypeFld.sendKeys(accountType);
    }

    public void setAccountIndustryFld(String accountIndustry) {
        accountIndustryFld.clear();
        accountIndustryFld.sendKeys(accountIndustry);
    }

    public void setAccountAnnualRevenueFld(String accountAnnualRevenue) {
        accountAnnualRevenueFld.clear();
        accountAnnualRevenueFld.sendKeys(accountAnnualRevenue);
    }

    public void setAccountRatingFld(String accountRating) {
        accountRatingFld.clear();
        accountRatingFld.sendKeys(accountRating);
    }

    public void setAccountPhoneFld(String accountPhone) {
        accountPhoneFld.clear();
        accountPhoneFld.sendKeys(accountPhone);
    }

    public void setAccountFaxFld(String accountFax) {
        accountFaxFld.clear();
        accountFaxFld.sendKeys(accountFax);
    }

    public void setAccountWebsiteFld(String accountWebsite) {
        accountWebsiteFld.clear();
        accountWebsiteFld.sendKeys(accountWebsite);
    }

    public void setAccountThickerFld(String accountThicker) {
        accountThickerFld.clear();
        accountThickerFld.sendKeys(accountThicker);
    }

    public void setAccountOwnershipFld(String accountOwnership) {
        accountOwnershipFld.clear();
        accountOwnershipFld.sendKeys(accountOwnership);
    }

    public void setAccountEmployeesFld(String accountEmployees) {
        accountEmployeesFld.clear();
        accountEmployeesFld.sendKeys(accountEmployees);
    }

    public void setAccountSICCodeFld(String accountSICCode) {
        accountSICCodeFld.clear();
        accountSICCodeFld.sendKeys(accountSICCode);
    }

    public void setAccountBillingStreetFld(String accountBillingStreet) {
        accountBillingStreetFld.clear();
        accountBillingStreetFld.sendKeys(accountBillingStreet);
    }

    public void setAccountBillingCityFld(String accountBillingCity) {
        accountBillingCityFld.clear();
        accountBillingCityFld.sendKeys(accountBillingCity);
    }

    public void setAccountBillingStateFld(String accountBillingState) {
        accountBillingStateFld.clear();
        accountBillingStateFld.sendKeys(accountBillingState);
    }

    public void setAccountBillingZipFld(String accountBillingZip) {
        accountBillingZipFld.clear();
        accountBillingZipFld.sendKeys(accountBillingZip);
    }

    public void setAccountBillingCountryFld(String accountBillingCountry) {
        accountBillingCountryFld.clear();
        accountBillingCountryFld.sendKeys(accountBillingCountry);
    }

    public void setAccountShippingStreetFld(String accountShippingStreet) {
        accountShippingStreetFld.clear();
        accountShippingStreetFld.sendKeys(accountShippingStreet);
    }

    public void setAccountShippingCityFld(String accountShippingCity) {
        accountShippingCityFld.clear();
        accountShippingCityFld.sendKeys(accountShippingCity);
    }

    public void setAccountShippingStateFld(String accountShippingState) {
        accountShippingStateFld.clear();
        accountShippingStateFld.sendKeys(accountShippingState);
    }

    public void setAccountShippingZipFld(String accountShippingZip) {
        accountShippingZipFld.clear();
        accountShippingZipFld.sendKeys(accountShippingZip);
    }

    public void setAccountShippingCountryFld(String accountShippingCountry) {
        accountShippingCountryFld.clear();
        accountShippingCountryFld.sendKeys(accountShippingCountry);
    }

    public void setAccountCustomerPriorityFld(String accountCustomerPriority) {
        accountCustomerPriorityFld.clear();
        accountCustomerPriorityFld.sendKeys(accountCustomerPriority);
    }

    public void setAccountSLAExpirationDateFld(String accountSLAExpirationDate) {
        accountSLAExpirationDateFld.clear();
        accountSLAExpirationDateFld.sendKeys(accountSLAExpirationDate);
    }

    public void setAccountNumberLocationsFld(String accountNumberLocations) {
        accountNumberLocationsFld.clear();
        accountNumberLocationsFld.sendKeys(accountNumberLocations);
    }

    public void setAccountActiveFld() {
        accountActiveFld.clear();
        accountActiveFld.click();
    }

    public void setAccountSLAFld(String accountSLA) {
        accountSLAFld.clear();
        accountSLAFld.sendKeys(accountSLA);
    }

    public void setAccountSLASerialNumberFld(String accountSLASerialNumber) {
        accountSLASerialNumberFld.clear();
        accountSLASerialNumberFld.sendKeys(accountSLASerialNumber);
    }

    public void setAccountUpsellOpportunityFld(String accountUpsellOpportunity) {
        accountUpsellOpportunityFld.clear();
        accountUpsellOpportunityFld.sendKeys(accountUpsellOpportunity);
    }

    public void setAccountDescriptionFld(String accountDescription) {
        accountDescriptionFld.clear();
        accountDescriptionFld.sendKeys(accountDescription);
    }

}
