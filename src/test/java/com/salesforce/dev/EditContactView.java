package com.salesforce.dev;

import java.util.Iterator;

import com.salesforce.dev.framework.utils.DataDrivenManager;
import com.salesforce.dev.framework.dto.ViewSalesForce;
import com.salesforce.dev.framework.utils.RandomGenerator;
import com.salesforce.dev.pages.base.NavigationBar;
import com.salesforce.dev.pages.Contacts.ContactView;
import com.salesforce.dev.pages.Contacts.ContactViewDetail;
import com.salesforce.dev.pages.Contacts.ContactsHome;
import com.salesforce.dev.pages.HomePage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Objects.CampaignGenie;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by alex on 06/09/2015.
 */

public class EditContactView {
    private static final Logger LOGGER = Logger.getLogger(EditContactView.class.getName());
    private ContactsHome contactsHome;
    private ContactViewDetail contactViewDetail;
    private HomePage homePage;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private DataDrivenManager dataDriveManager = new DataDrivenManager();
    private ContactView contactView;
    private String nameView;

    @DataProvider(name = "dataDriven")
    public Iterator<ViewSalesForce[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataView("json/EditContactView.json");
    }

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        ViewSalesForce viewSalesForce = CampaignGenie.getCampaignView("json/CreateContactView.json");
        nameView = viewSalesForce.getViewName();
        homePage = new HomePage();
        mainPage = homePage.clickLoginBtn().loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        contactsHome = navigationBar.goToContactsHome();
        contactView = contactsHome.clickNewViewLnk()
                .setViewName(viewSalesForce.getViewName())
                .setUniqueViewName(viewSalesForce.getUniqueViewName());
        contactViewDetail = contactView.clickSaveBtn();
    }


    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testEditContact(ViewSalesForce viewSalesForceUpdate) {
        homePage = new HomePage();
        mainPage = homePage.clickLoginBtn().loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        contactsHome = navigationBar.goToContactsHome();
        String fieldToUpdate = "View Name";
        String newValue = "viewUpdatedContact" + RandomGenerator.getInstance().getRandomString();
        contactView = contactsHome.clickEditViewLnk(nameView)
                .setViewName(viewSalesForceUpdate.getViewName())
                .setUniqueViewName(viewSalesForceUpdate.getUniqueViewName())
                .checkFilterByOwnerAll()
                .checkFilterByOwnerMy()
                .selectRestrictVisibility(viewSalesForceUpdate.getRestrictVisibility());
        contactViewDetail = contactView.clickSaveBtn();
        Assert.assertFalse(contactViewDetail.validateNameView("anyname"));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        contactViewDetail.clickDeleteLnk(true);
        LOGGER.info("Contact was deleted");
        mainPage = contactViewDetail.gotoMainPage();
        navigationBar = mainPage.gotoNavBar();
        contactsHome = navigationBar.goToContactsHome();
        contactViewDetail.clickDeleteLnk(true);
        LOGGER.info("Contact Parent was deleted");
    }
}
