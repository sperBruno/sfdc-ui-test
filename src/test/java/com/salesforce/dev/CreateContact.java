package com.salesforce.dev;

import com.salesforce.dev.pages.SearchLookup.SearchLookupBase;
import com.salesforce.dev.pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;

import com.salesforce.dev.pages.Contacts.ContactDetail;
import com.salesforce.dev.pages.Contacts.ContactForm;
import com.salesforce.dev.pages.Contacts.ContactsHome;

/**
 * Created by Marcelo.Vargas on 6/12/2015.
 */
public class CreateContact {
    private ContactsHome contactsHome;
    private ContactDetail contactDetail;
    private ContactForm contactForm;
    private HomePage homePage;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private String lastName="MyLastName2";
    private SearchLookupBase searchLookup;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage();
        String userNameValue= Environment.getInstance().getPrimaryUser();
        String passwordValue=Environment.getInstance().getPrimaryPassword();
        mainPage = homePage.loginAs(userNameValue,passwordValue);
    }

    @Test
    public void testCreateContact() {
        navigationBar = mainPage.gotoNavBar();
        contactsHome = navigationBar.goToContactsHome();
        contactForm = contactsHome.clickNewBtn();
        contactForm = contactForm.setLastName(lastName);
        searchLookup =  contactForm.clickLookupAccount();
        contactForm = searchLookup.clickLookup("test");
        contactForm.setTitle("MY TEST");
        contactDetail = contactForm.clickSaveBtn();


        //Assert.assertTrue(contactDetail.VerifyContact(lastName), "contact was not Created");
    }

    @AfterMethod
    public void tearDown() {
        //contactDetail.DeleteContact();

    }
}
