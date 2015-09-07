package com.salesforce.dev;

import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.LoggerManager;
import com.salesforce.dev.framework.Objects.FieldToDisplayView;
import com.salesforce.dev.framework.Objects.FilterView;
import com.salesforce.dev.framework.Objects.ViewSalesForce;
import com.salesforce.dev.framework.RandomGenerator;
import com.salesforce.dev.pages.Accounts.AccountDetail;
import com.salesforce.dev.pages.Accounts.AccountView;
import com.salesforce.dev.pages.Accounts.AccountViewDetail;
import com.salesforce.dev.pages.Accounts.AccountsHome;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Campaigns.CampaignDetail;
import com.salesforce.dev.pages.Campaigns.CampaignView;
import com.salesforce.dev.pages.Campaigns.CampaignViewDetail;
import com.salesforce.dev.pages.Campaigns.CampaignsHome;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Login.Transporter;
import com.salesforce.dev.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Carlos Orellana on 8/22/2015.
 */
public class CreateAccountViewFiltersFieldsAdded {
    private AccountsHome accountsHome;
    private AccountView accountView;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private AccountViewDetail accountViewDetail;

    @DataProvider(name = "dataDriven")
    public Iterator<ViewSalesForce[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataView("CreateAccountsViewFiltersFieldAdded.json");
    }


    @Test(groups = {"Regression"}, dataProvider = "dataDriven")
    public void testCreateCampaignViewWithFilters(ViewSalesForce viewSalesForce) {
        mainPage = Transporter.driverMainPage();
        navigationBar = mainPage.gotoNavBar();
        accountsHome = navigationBar.goToAccountsHome();
        accountView = accountsHome.clickNewViewLnk()
                .setViewName(viewSalesForce.getViewName() + RandomGenerator.getInstance().getRandomString())
                .setUniqueViewName(viewSalesForce.getUniqueViewName())
                .checkFilterByOwner(viewSalesForce.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForce.getRestrictVisibility());
        List <FilterView> additionalField = viewSalesForce.getAdditionalFields();
        int count = 1;
        for(FilterView addFilter: additionalField){
            accountView = accountView.addAdditionalFiltersByField(count,addFilter.getFieldFilter(),
                    addFilter.getOperatorFilter(),addFilter.getValueFilter());
            count++;
        }
        List <FieldToDisplayView> fieldToDisplayViews = viewSalesForce.getFieldsDisplay();
        for(FieldToDisplayView fields:fieldToDisplayViews)
            accountView = accountView.addNewFieldToDisplay(fields.getFieldToDisplay());
        accountViewDetail = accountView.clickSaveBtn();
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Account view was created");
        Assert.assertTrue(accountViewDetail.validateNameView(viewSalesForce.getViewName()));
        for(FieldToDisplayView fields:fieldToDisplayViews){
            Assert.assertTrue(accountViewDetail.validateFieldDisplayed(fields.getFieldToDisplay()));
        }
    }

    @AfterMethod(groups = {"Regression"})
    public void tearDown() {
        accountViewDetail.clickDeleteLnk(true);
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Account View was deleted");
    }
}
