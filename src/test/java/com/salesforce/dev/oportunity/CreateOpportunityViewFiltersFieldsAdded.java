package com.salesforce.dev.oportunity;

import java.util.Iterator;
import java.util.List;

import com.salesforce.dev.framework.dto.FieldToDisplayView;
import com.salesforce.dev.framework.dto.FilterView;
import com.salesforce.dev.framework.dto.ViewSalesForce;
import com.salesforce.dev.framework.utils.DataDrivenManager;
import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.base.NavigationBar;
import com.salesforce.dev.pages.opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.opportunities.OpportunityView;
import com.salesforce.dev.pages.opportunities.OpportunityViewDetail;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Carlos Orellana on 8/22/2015.
 */
public class CreateOpportunityViewFiltersFieldsAdded {
    private static final Logger LOGGER = Logger.getLogger(CreateOpportunityViewFiltersFieldsAdded.class.getName());
    private NavigationBar navigationBar;
    private OpportunityViewDetail opportunityViewDetail;

    @DataProvider(name = "dataDriven")
    public Iterator<ViewSalesForce[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataView("CreateOpportunityViewFiltersFieldAdded.json");
    }

    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"Regression"}, dataProvider = "dataDriven")
    public void testCreateOpportunityViewWithFilters(ViewSalesForce viewSalesForce) {
        OpportunitiesHome opportunitiesHome = navigationBar.goToOpportunitiesHome();
        OpportunityView opportunityView = opportunitiesHome.clickNewViewLnk()
                .setViewName(viewSalesForce.getViewName())
                .setUniqueViewName(viewSalesForce.getUniqueViewName())
                .checkFilterByOwner(viewSalesForce.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForce.getRestrictVisibility());

        List<FilterView> additionalField = viewSalesForce.getAdditionalFields();
        int count = 1;
        for (FilterView addFilter : additionalField) {
            opportunityView = opportunityView.addAdditionalFiltersByField(count, addFilter.getFieldFilter(), addFilter.getOperatorFilter(), addFilter.getValueFilter());
            count++;
        }

        List<FieldToDisplayView> fieldToDisplayViews = viewSalesForce.getFieldsDisplay();
        for (FieldToDisplayView fields : fieldToDisplayViews) {
            opportunityView = opportunityView.addNewFieldToDisplay(fields.getFieldToDisplay());
        }
        opportunityViewDetail = opportunityView.clickSaveBtn();

        assertTrue(opportunityViewDetail.validateNameView(viewSalesForce.getViewName()));
    }

    @AfterMethod(groups = {"Regression"})
    public void tearDown() {
        opportunityViewDetail.clickDeleteLnk(true);
        LOGGER.info("Opportunity View was deleted");
    }
}
