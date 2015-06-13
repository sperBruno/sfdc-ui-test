package com.salesforce.dev.pages.Contacts;

import com.salesforce.dev.pages.Contacts.*;

/**
 * Created by Marcelo.Vargas on 6/12/2015.
 */
public class ContactBuilder {

    String firstNameRole, firstName, lastName, accountName, title, department, reportsTo, phone, homePhone, mobile, otherPhone, fax, email, assistant, assistantPhone;
    String mailingStreet, mailingCity, mailingState, mailingZip, mailingCountry, otherStreet, otherCity, otherState, otherZip, otherCountry;
    String	languages;
    String description;
    String birthDate;
    String leadSource, level;

    public ContactBuilder(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstNameRole() {
        return firstNameRole;
    }
    public ContactBuilder setFirstNameRole(String firstNameRole) {
        this.firstNameRole = firstNameRole;
        return this;
    }

    public String getFirstName() {
        return lastName;
    }
    public ContactBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }
    public ContactBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAccountName() {
        return accountName;
    }
    public ContactBuilder setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public String getTitle() {
        return title;
    }
    public ContactBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDepartment() {
        return department;
    }
    public ContactBuilder setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }
    public ContactBuilder setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getReportsTo() {
        return reportsTo;
    }
    public ContactBuilder setReportsTo(String reportsTo) {
        this.reportsTo = reportsTo;
        return this;
    }

    public String getPhone() {
        return phone;
    }
    public ContactBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }
    public ContactBuilder setHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public String getMobile() {
        return mobile;
    }
    public ContactBuilder setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getOtherPhone() {
        return otherPhone;
    }
    public ContactBuilder setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
        return this;
    }

    public String getFax() {
        return fax;
    }
    public ContactBuilder setFax(String fax) {
        this.fax = fax;
        return this;
    }

    public String getEmail() {
        return email;
    }
    public ContactBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAssistant() {
        return assistant;
    }
    public ContactBuilder setAssistant(String assistant) {
        this.assistant = assistant;
        return this;
    }

    public String getAssistantPhone() {
        return assistantPhone;
    }
    public ContactBuilder getAssistantPhone(String assistantPhone) {
        this.assistantPhone = assistantPhone;
        return this;
    }

    public String getMailingStreet() {
        return mailingStreet;
    }
    public ContactBuilder setMailingStreet(String mailingStreet) {
        this.mailingStreet = mailingStreet;
        return this;
    }
    public String getMailingCity() {
        return mailingCity;
    }

    public ContactBuilder setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity;
        return this;
    }

    public String getMailingState() {
        return mailingState;
    }
    public ContactBuilder setMailingState(String mailingState) {
        this.mailingState = mailingState;
        return this;
    }

    public String getMailingZip() {
        return mailingZip;
    }
    public ContactBuilder setMailingZip(String mailingZip) {
        this.mailingZip = mailingZip;
        return this;
    }

    public String getMailingCountry() {
        return mailingCountry;
    }
    public ContactBuilder setMailingCountry(String mailingCountry) {
        this.mailingCountry = mailingCountry;
        return this;
    }

    public String setOtherStreet() {
        return otherStreet;
    }
    public ContactBuilder setOtherStreet(String otherStreet) {
        this.otherStreet = otherStreet;
        return this;
    }

    public String getOtherCity() {
        return otherCity;
    }
    public ContactBuilder setOtherCity(String otherCity) {
        this.otherCity = otherCity;
        return this;
    }

    public String getOtherState() {
        return otherState;
    }
    public ContactBuilder setOtherState(String otherState) {
        this.otherState = otherState;
        return this;
    }

    public String getOtherZip() {
        return otherZip;
    }
    public ContactBuilder setOtherZip(String otherZip) {
        this.otherZip = otherZip;
        return this;
    }

    public String getOtherCountry() {
        return otherCountry;
    }
    public ContactBuilder setOtherCountry(String otherCountry) {
        this.otherCountry = otherCountry;
        return this;
    }

    public String getLanguages() {
        return languages;
    }
    public ContactBuilder setLanguages(String languages) {
        this.languages = languages;
        return this;
    }

    public String getDescription() {
        return description;
    }
    public ContactBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLeadSource() {
        return leadSource;
    }
    public ContactBuilder setLeadSource(String leadSource) {
        this.leadSource = leadSource;
        return this;
    }

    public String getLevel() {
        return level;
    }
    public ContactBuilder setLevel(String level) {
        this.level = level;
        return this;
    }

    public ContactForm build() {
        return new ContactForm(this);
    }
}
