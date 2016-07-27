package com.salesforce.dev;
import com.salesforce.dev.framework.Objects.FieldToDisplayView;
import com.salesforce.dev.framework.Objects.FilterView;
import com.salesforce.dev.framework.RamdonGenerator;
import com.salesforce.dev.pages.Campaigns.CampaignForm;
import com.salesforce.dev.pages.Campaigns.CampaignView;
import com.salesforce.dev.pages.Campaigns.CampaignViewDetail;
import com.salesforce.dev.pages.Campaigns.CampaignsHome;
import com.salesforce.dev.pages.Contacts.ContactViewDetail;
import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.LoggerManager;
import com.salesforce.dev.framework.Objects.ViewSalesForce;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Contacts.ContactView;
import com.salesforce.dev.pages.Contacts.ContactsHome;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Alexander Apaza on 6/12/2015.
 */
public class CreateContactView {
    private ContactsHome contactHome;
    private ContactView contactView;
    private HomePage homePage;
    private ContactViewDetail contactViewDetail;

    private CampaignsHome campaignsHome;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private CampaignView campaignView;
    private String campaignName;
    private CampaignViewDetail campaignViewDetail;
    private CampaignForm campaignForm;

    @DataProvider(name = "dataDriven")
    public Iterator<ViewSalesForce[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataView("CreateContactView.json");
    }

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        campaignName = "Camp" + RamdonGenerator.getInstance().getRamdonString();
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCampaignsHome();
        campaignForm = campaignsHome.clickNewBtn();
        campaignForm.setCampaignName(campaignName);
        campaignForm.checkActiveCheckbox();
        campaignForm.clickSaveBtn();
    }


    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testCreateContactView(ViewSalesForce viewSalesForce){
        contactHome = navigationBar.goToContactsHome();
        contactView = contactHome.clickNewViewLnk()
                .setViewName(viewSalesForce.getViewName())
                .setUniqueViewName(viewSalesForce.getUniqueViewName())
                .checkFilterByOwnerAll()
                .checkFilterByOwnerMy()
                .setFilterByCampaign(campaignName)
                .selectRestrictVisibility(viewSalesForce.getRestrictVisibility());

        List <FilterView> additionalField = viewSalesForce.getAdditionalFields();
        int count = 1;
        for(FilterView addFilter: additionalField){
            contactView = contactView.addAdditionalFiltersByField(count,addFilter.getFieldFilter(),
                    addFilter.getOperatorFilter(),addFilter.getValueFilter());
            count++;
        }
        List <FieldToDisplayView> fieldToDisplayViews = viewSalesForce.getFieldsDisplay();
        for(FieldToDisplayView fields:fieldToDisplayViews)
            contactView = contactView.addNewFieldToDisplay(fields.getFieldToDisplay());

        contactViewDetail = contactView.clickSaveBtn();
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),"Contact was created");
        Assert.assertFalse(contactViewDetail.validateNameView("AnyName"));

    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        contactViewDetail.clickDeleteLnk(true);
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Contact View was deleted");
    }
}
