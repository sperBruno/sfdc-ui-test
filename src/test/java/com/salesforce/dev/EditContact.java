package com.salesforce.dev;

import com.salesforce.dev.framework.LoggerManager;
import com.salesforce.dev.pages.Accounts.AccountDetail;
import com.salesforce.dev.pages.Accounts.AccountForm;
import com.salesforce.dev.pages.Accounts.AccountsHome;
import com.salesforce.dev.pages.Base.SearchLookupBase;
import com.salesforce.dev.pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;

import com.salesforce.dev.pages.Contacts.ContactDetail;
import com.salesforce.dev.pages.Contacts.ContactForm;
import com.salesforce.dev.pages.Contacts.ContactsHome;

/**
 * Created by Marcelo.Vargas on 6/21/2015.
 */
public class EditContact {

    private String lastNameUpdated = "Testing";
    private String contactRole = "Mr.";
    private String firstName = "Marcelo";
    private String lastName = "Vargas";
    private String accountName = "AccountTest";
    private String title = "Engineer";
    private String department = "Engineering";
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
    private MainPage mainPage;private AccountDetail accountDetail;
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

        navigationBar = mainPage.gotoNavBar();
        contactsHome = navigationBar.goToContactsHome();
        contactForm = contactsHome.clickNewBtn();
        contactForm.setLastName(lastName);
        contactDetail = contactForm.clickSaveBtn();

        mainPage = contactDetail.gotoMainPage();
    }

    @Test(groups = {"Acceptance"})
    public void testEditContact() {
        navigationBar = mainPage.gotoNavBar();
        contactsHome = navigationBar.goToContactsHome();

        contactDetail = contactsHome.selectRecentItem(lastName);
        contactForm = contactDetail.clickEditBtn();
        contactForm.setLastName(lastNameUpdated);

        contactForm.setFirstNameRole(contactRole);
        contactForm.setFirstName(firstName);

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
        contactForm.setMailingStreet(mailingStreet);
        contactForm.setMailingCity(mailingCity);
        contactForm.setMailingState(mailingState);
        contactForm.setMailingZip(mailingZip);
        contactForm.setOtherStreet(otherStreet);
        contactForm.setOtherCity(otherCity);
        contactForm.setOtherState(otherState);
        contactForm.setOtherZip(otherZip);
        contactForm.setOtherCountry(otherCountry);
        contactForm.setLanguages(languages);
        contactForm.setLevel(level);
        contactDetail = contactForm.clickSaveBtn();

        //Assert.assertTrue(contactDetail.VerifyContact(lastName), "contact was not Created");
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        contactDetail.clickDeleteBtn(true);
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Contact was deleted");
        mainPage = accountDetail.gotoMainPage();
        navigationBar = mainPage.gotoNavBar();
        accountsHome = navigationBar.goToAccountsHome();
        accountDetail = accountsHome.selectRecentItem(accountName);
        accountDetail.clickDeleteBtn(true);
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Campaign Parent was deleted");
    }
}
