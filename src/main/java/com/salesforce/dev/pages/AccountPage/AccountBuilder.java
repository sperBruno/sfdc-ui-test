package com.salesforce.dev.pages.AccountPage;

import java.util.Date;

/**
 * Created by Walter Mercado on 10/06/2015.
 */
public class AccountBuilder {
    String accountName, parentAccount, accountNumber, accountSite, accountType, accountIndustry;
    String accountRating, accountPhone, accountFax, accountWebsite, accountThicker, accountOwnership,accountSICCode;
    String accountBillingStreet,accountShippingStreet,accountBillingCity,accountShippingCity;
    String accountBillingState,accountShippingState,accountBillingZip,accountShippingZip,accountBillingCountry;
    String accountShippingCountry,accountCustomerPriority,accountSLA, accountSLASerialNumber;
    String accountUpsellOpportunity, accountDescription;
    Integer accountEmployees, accountAnnualRevenue, accountNumberLocations;
    Date accountSLAExpirationDate;
    Boolean accountActive;




    public AccountBuilder(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }


    public AccountBuilder setAccountActive(Boolean accountActive) {
        this.accountActive = accountActive;
        return this;
    }

    public Boolean getAccountActive() {
        return accountActive;
    }

    public AccountBuilder setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public String getParentAccount() {
        return parentAccount;
    }

    public AccountBuilder setParentAccount(String parentAccount) {
        this.parentAccount = parentAccount;
        return this;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public AccountBuilder setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public String getAccountSite() {
        return accountSite;
    }

    public AccountBuilder setAccountSite(String accountSite) {
        this.accountSite = accountSite;
        return this;
    }

    public String getAccountType() {
        return accountType;
    }

    public AccountBuilder setAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    public String getAccountIndustry() {
        return accountIndustry;
    }

    public AccountBuilder setAccountIndustry(String accountIndustry) {
        this.accountIndustry = accountIndustry;
        return this;
    }

    public String getAccountRating() {
        return accountRating;
    }

    public AccountBuilder setAccountRating(String accountRating) {
        this.accountRating = accountRating;
        return this;
    }

    public String getAccountPhone() {
        return accountPhone;
    }

    public AccountBuilder setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
        return this;
    }

    public String getAccountFax() {
        return accountFax;
    }

    public AccountBuilder setAccountFax(String accountFax) {
        this.accountFax = accountFax;
        return this;
    }

    public String getAccountWebsite() {
        return accountWebsite;
    }

    public AccountBuilder setAccountWebsite(String accountWebsite) {
        this.accountWebsite = accountWebsite;
        return this;
    }

    public String getAccountThicker() {
        return accountThicker;
    }

    public AccountBuilder setAccountThicker(String accountThicker) {
        this.accountThicker = accountThicker;
        return this;
    }

    public String getAccountOwnership() {
        return accountOwnership;
    }

    public AccountBuilder setAccountOwnership(String accountOwnership) {
        this.accountOwnership = accountOwnership;
        return this;
    }

    public String getAccountSICCode() {
        return accountSICCode;
    }

    public AccountBuilder setAccountSICCode(String accountSICCode) {
        this.accountSICCode = accountSICCode;
        return this;
    }

    public String getAccountBillingStreet() {
        return accountBillingStreet;
    }

    public AccountBuilder setAccountBillingStreet(String accountBillingStreet) {
        this.accountBillingStreet = accountBillingStreet;
        return this;
    }

    public String getAccountShippingStreet() {
        return accountShippingStreet;
    }

    public AccountBuilder setAccountShippingStreet(String accountShippingStreet) {
        this.accountShippingStreet = accountShippingStreet;
        return this;
    }

    public String getAccountBillingCity() {
        return accountBillingCity;
    }

    public AccountBuilder setAccountBillingCity(String accountBillingCity) {
        this.accountBillingCity = accountBillingCity;
        return this;
    }

    public String getAccountShippingCity() {
        return accountShippingCity;
    }

    public AccountBuilder setAccountShippingCity(String accountShippingCity) {
        this.accountShippingCity = accountShippingCity;
        return this;
    }

    public String getAccountBillingState() {
        return accountBillingState;
    }

    public AccountBuilder setAccountBillingState(String accountBillingState) {
        this.accountBillingState = accountBillingState;
        return this;
    }

    public String getAccountShippingState() {
        return accountShippingState;
    }

    public AccountBuilder setAccountShippingState(String accountShippingState) {
        this.accountShippingState = accountShippingState;
        return this;
    }

    public String getAccountBillingZip() {
        return accountBillingZip;
    }

    public AccountBuilder setAccountBillingZip(String accountBillingZip) {
        this.accountBillingZip = accountBillingZip;
        return this;
    }

    public String getAccountShippingZip() {
        return accountShippingZip;
    }

    public AccountBuilder setAccountShippingZip(String accountShippingZip) {
        this.accountShippingZip = accountShippingZip;
        return this;
    }

    public String getAccountBillingCountry() {
        return accountBillingCountry;
    }

    public AccountBuilder setAccountBillingCountry(String accountBillingCountry) {
        this.accountBillingCountry = accountBillingCountry;
        return this;
    }

    public String getAccountShippingCountry() {
        return accountShippingCountry;
    }

    public AccountBuilder setAccountShippingCountry(String accountShippingCountry) {
        this.accountShippingCountry = accountShippingCountry;
        return this;
    }

    public String getAccountCustomerPriority() {
        return accountCustomerPriority;
    }

    public AccountBuilder setAccountCustomerPriority(String accountCustomerPriority) {
        this.accountCustomerPriority = accountCustomerPriority;
        return this;
    }

    public String getAccountSLA() {
        return accountSLA;
    }

    public AccountBuilder setAccountSLA(String accountSLA) {
        this.accountSLA = accountSLA;
        return this;
    }

    public String getAccountSLASerialNumber() {
        return accountSLASerialNumber;
    }

    public AccountBuilder setAccountSLASerialNumber(String accountSLASerialNumber) {
        this.accountSLASerialNumber = accountSLASerialNumber;
        return this;
    }

    public String getAccountUpsellOpportunity() {
        return accountUpsellOpportunity;
    }

    public AccountBuilder setAccountUpsellOpportunity(String accountUpsellOpportunity) {
        this.accountUpsellOpportunity = accountUpsellOpportunity;
        return this;
    }


    public String getAccountDescription() {
        return accountDescription;
    }

    public AccountBuilder setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
        return this;
    }

    public Integer getAccountEmployees() {
        return accountEmployees;
    }

    public AccountBuilder setAccountEmployees(Integer accountEmployees) {
        this.accountEmployees = accountEmployees;
        return this;
    }

    public Integer getAccountAnnualRevenue() {
        return accountAnnualRevenue;
    }

    public AccountBuilder setAccountAnnualRevenue(Integer accountAnnualRevenue) {
        this.accountAnnualRevenue = accountAnnualRevenue;
        return this;
    }

    public Integer getAccountNumberLocations() {
        return accountNumberLocations;
    }

    public AccountBuilder setAccountNumberLocations(Integer accountNumberLocations) {
        this.accountNumberLocations = accountNumberLocations;
        return this;
    }

    public Date getAccountSLAExpirationDate() {
        return accountSLAExpirationDate;
    }

    public AccountBuilder setAccountSLAExpirationDate(Date accountSLAExpirationDate) {
        this.accountSLAExpirationDate = accountSLAExpirationDate;
        return this;
    }

    public AccountPage build() {
        return new AccountPage(this);
    }




}
