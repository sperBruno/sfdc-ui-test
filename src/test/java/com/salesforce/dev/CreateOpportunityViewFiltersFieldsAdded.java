package com.salesforce.dev;

import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.LoggerManager;
import com.salesforce.dev.framework.Objects.FieldToDisplayView;
import com.salesforce.dev.framework.Objects.FilterView;
import com.salesforce.dev.framework.Objects.ViewSalesForce;
import com.salesforce.dev.framework.RandomGenerator;
import com.salesforce.dev.pages.Accounts.AccountView;
import com.salesforce.dev.pages.Accounts.AccountViewDetail;
import com.salesforce.dev.pages.Accounts.AccountsHome;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Login.Transporter;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.Opportunities.OpportunityView;
import com.salesforce.dev.pages.Opportunities.OpportunityViewDetail;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Carlos Orellana on 8/22/2015.
 */
public class CreateOpportunityViewFiltersFieldsAdded {
    private OpportunitiesHome opportunitiesHome;
    private OpportunityView opportunityView;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private OpportunityViewDetail opportunityViewDetail;

    @DataProvider(name = "dataDriven")
    public Iterator<ViewSalesForce[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataView("CreateOpportunityViewFiltersFieldAdded.json");
    }


    @Test(groups = {"Regression"}, dataProvider = "dataDriven")
    public void testCreateCampaignViewWithFilters(ViewSalesForce viewSalesForce) {
        mainPage = Transporter.driverMainPage();
        navigationBar = mainPage.gotoNavBar();
        opportunitiesHome = navigationBar.goToOpportunitiesHome();
        opportunityView = opportunitiesHome.clickNewViewLnk()
                .setViewName(viewSalesForce.getViewName() + RandomGenerator.getInstance().getRandomString())
                .setUniqueViewName(viewSalesForce.getUniqueViewName())
                .checkFilterByOwner(viewSalesForce.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForce.getRestrictVisibility());
        List <FilterView> additionalField = viewSalesForce.getAdditionalFields();
        int count = 1;
        for(FilterView addFilter: additionalField){
            opportunityView = opportunityView.addAdditionalFiltersByField(count,addFilter.getFieldFilter(),
                    addFilter.getOperatorFilter(),addFilter.getValueFilter());
            count++;
        }
        List <FieldToDisplayView> fieldToDisplayViews = viewSalesForce.getFieldsDisplay();
        for(FieldToDisplayView fields:fieldToDisplayViews)
            opportunityView = opportunityView.addNewFieldToDisplay(fields.getFieldToDisplay());
        opportunityViewDetail = opportunityView.clickSaveBtn();
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Opportunity view was created");
        Assert.assertTrue(opportunityViewDetail.validateNameView(viewSalesForce.getViewName()));
        for(FieldToDisplayView fields:fieldToDisplayViews){
            Assert.assertTrue(opportunityViewDetail.validateFieldDisplayed(fields.getFieldToDisplay()));
        }
    }

    @AfterMethod(groups = {"Regression"})
    public void tearDown() {
        opportunityViewDetail.clickDeleteLnk(true);
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Opportunity View was deleted");
    }
}
