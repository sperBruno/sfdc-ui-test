package com.salesforce.dev.campaign;

import com.salesforce.dev.framework.utils.DataDrivenManager;
import com.salesforce.dev.framework.dto.FieldToDisplayView;
import com.salesforce.dev.framework.dto.FilterView;
import com.salesforce.dev.framework.dto.ViewSalesForce;
import com.salesforce.dev.pages.base.NavigationBar;
import com.salesforce.dev.pages.campaigns.CampaignView;
import com.salesforce.dev.pages.campaigns.CampaignViewDetail;
import com.salesforce.dev.pages.campaigns.CampaignsHome;
import com.salesforce.dev.pages.HomePage;
import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by veronica on 8/21/2015.
 */
public class CreateCampaignViewFiltersFieldsAdded {

    private static final Logger LOGGER = Logger.getLogger(CreateCampaignViewFiltersFieldsAdded.class.getName());

    private CampaignsHome campaignsHome;

    private CampaignView campaignView;

    private HomePage homePage;

    private MainPage mainPage;

    private NavigationBar navigationBar;

    private CampaignViewDetail campaignViewDetail;

    @DataProvider(name = "dataDriven")
    public Iterator<ViewSalesForce[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataView("CreateCampaignViewFiltersFieldAdded.json");
    }

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {

        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"Regression"}, dataProvider = "dataDriven")
    public void testCreateCampaignViewWithFilters(ViewSalesForce viewSalesForce) {
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCampaignsHome();
        campaignView = campaignsHome.clickNewViewLnk()
                .setViewName(viewSalesForce.getViewName())
                .setUniqueViewName(viewSalesForce.getUniqueViewName())
                .checkFilterByOwner(viewSalesForce.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForce.getRestrictVisibility());
        List<FilterView> additionalField = viewSalesForce.getAdditionalFields();
        int count = 1;
        for (FilterView addFilter : additionalField) {
            campaignView = campaignView.addAdditionalFiltersByField(count, addFilter.getFieldFilter(),
                    addFilter.getOperatorFilter(), addFilter.getValueFilter());
            count++;
        }
        List<FieldToDisplayView> fieldToDisplayViews = viewSalesForce.getFieldsDisplay();
        for (FieldToDisplayView fields : fieldToDisplayViews) {
            campaignView = campaignView.addNewFieldToDisplay(fields.getFieldToDisplay());
        }
        campaignViewDetail = campaignView.clickSaveBtn();
        LOGGER.info("Campaign view was created");
        assertTrue(campaignViewDetail.validateNameView(viewSalesForce.getViewName()));
        //validateFieldsAdded
        for (FieldToDisplayView fields : fieldToDisplayViews) {
            Assert.assertTrue(campaignViewDetail.validateFieldDisplayed(fields.getFieldToDisplay()));
        }
    }

    @AfterMethod(groups = {"Regression"})
    public void tearDown() {
        campaignViewDetail.clickDeleteLnk(true);
        LOGGER.info("Campaign View was deleted");
    }
}
