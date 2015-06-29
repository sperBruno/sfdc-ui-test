package com.salesforce.dev;

import com.salesforce.dev.pages.Accounts.AccountDetail;
import com.salesforce.dev.pages.Accounts.AccountForm;
import com.salesforce.dev.pages.Accounts.AccountsHome;
import com.salesforce.dev.pages.Base.SearchLookupBase;
import com.salesforce.dev.pages.MainPage;
//import junit.framework.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;

import com.salesforce.dev.pages.Contacts.ContactDetail;
import com.salesforce.dev.pages.Contacts.ContactForm;
import com.salesforce.dev.pages.Contacts.ContactsHome;

/**
 * Created by Marcelo.Vargas on 6/12/2015.
 */
public class CreateContact {

    private String contactRole = "Mr.";
    private String firstName = "Contact";
    private String lastName = "Testing";
    private String accountName = "AccountTest";
    private String title = "Engineer";
    private String department = "Engineering";
    private String birthday = "6/6/1996";
    private String reportsTo = "Avi Green";
    private String leadSource = "Web"; //--None--, Web, Phone Inquiry, Partner Referral, Purchased List, Other
    private String phone = "70777777";
    private String homePhone = "444444";
    private String mobile = "70777777";
    private String otherPhone = "60777777";
    private String fax = "80777777";
    private String email = "test@test.test";
    private String assistant = "123";
    private String assistantPhone = "90777777";

    private String mailingStreet = "Mailing Street";
    private String mailingCity = "Mailing City";
    private String mailingState = "Mailing State";
    private String mailingZip = "Mailing Zip";
    private String mailingCountry = "Mailing Country";

    private String otherStreet = "Other Street";
    private String otherCity = "Other City";
    private String otherState = "Other State";
    private String otherZip = "Other Zip";
    private String otherCountry = "Other Country";

    private String languages = "Spanish";
    private String level = "Secondary"; //--None--, Secondary, Tertiary, Primary

    private String description = "Description";

    private ContactsHome contactsHome;
    private ContactDetail contactDetail;
    private ContactForm contactForm;
    private HomePage homePage;
    private MainPage mainPage;
    private AccountDetail accountDetail;
    private NavigationBar navigationBar;
    private AccountsHome accountsHome;
    private AccountForm accountForm;

    private SearchLookupBase searchLookup;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();

        navigationBar = mainPage.gotoNavBar();
        accountsHome = navigationBar.goToAccountsHome();
        accountForm = accountsHome.clickNewBtn();
        accountForm.setAccountNameFld(accountName);
        accountDetail = accountForm.clickSaveBtn();
        mainPage = accountDetail.gotoMainPage();

    }

    @Test(groups = {"Acceptance"})
    public void testCreateContact() {
        navigationBar = mainPage.gotoNavBar();
        contactsHome = navigationBar.goToContactsHome();
        contactForm = contactsHome.clickNewBtn();
        contactForm.setFirstNameRole(contactRole);
        contactForm.setFirstName(firstName);
        contactForm.setLastName(lastName);

        searchLookup = contactForm.clickLookupAccount();
        searchLookup.searchText(accountName);
        contactForm = searchLookup.goToContactForm();

        contactForm.setTitle(title);
        contactForm.setDepartment(department);
        contactForm.setBirthDate(6,6,2015);

        searchLookup = contactForm.clickLookupReportsTo();
        searchLookup.searchText(reportsTo);
        contactForm = searchLookup.goToContactForm();

        contactForm.setLeadSource(leadSource);
        contactForm.setPhone(phone);
        contactForm.setHomePhone(homePhone);
        contactForm.setMobile(mobile);
        contactForm.setOtherPhone(otherPhone);
        contactForm.setFax(fax);
        contactForm.setEmail(email);
        contactForm.setAssistant(assistant);
        contactForm.setAssistantPhone(assistantPhone);
        contactForm.setMailingStreet(mailingStreet);
        contactForm.setMailingCity(mailingCity);
        contactForm.setMailingState(mailingState);
        contactForm.setMailingZip(mailingZip);
        contactForm.setMailingCountry(mailingCountry);
        contactForm.setOtherStreet(otherStreet);
        contactForm.setOtherCity(otherCity);
        contactForm.setOtherState(otherState);
        contactForm.setOtherZip(otherZip);
        contactForm.setOtherCountry(otherCountry);
        contactForm.setLanguages(languages);
        contactForm.setLevel(level);
        contactDetail = contactForm.clickSaveBtn();

        Assert.assertTrue(contactDetail.validateContactName(contactRole + " " + firstName + " " + lastName));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        contactDetail.clickDeleteBtn(true);
        mainPage = contactDetail.gotoMainPage();
        navigationBar = mainPage.gotoNavBar();
        accountsHome = navigationBar.goToAccountsHome();
        accountDetail = accountsHome.selectRecentItem(accountName);
        accountDetail.clickDeleteBtn(true);
    }
}
