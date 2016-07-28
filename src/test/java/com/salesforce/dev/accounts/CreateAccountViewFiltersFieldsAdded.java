package com.salesforce.dev.accounts;

import java.util.Iterator;
import java.util.List;

import com.salesforce.dev.framework.utils.DataDrivenManager;
import com.salesforce.dev.framework.dto.FieldToDisplayView;
import com.salesforce.dev.framework.dto.FilterView;
import com.salesforce.dev.framework.dto.ViewSalesForce;
import com.salesforce.dev.framework.utils.RandomGenerator;
import com.salesforce.dev.pages.accounts.AccountView;
import com.salesforce.dev.pages.accounts.AccountViewDetail;
import com.salesforce.dev.pages.accounts.AccountsHome;
import com.salesforce.dev.pages.base.NavigationBar;
import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Carlos Orellana on 8/22/2015.
 */
public class CreateAccountViewFiltersFieldsAdded {
    private AccountsHome accountsHome;
    private AccountView accountView;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private AccountViewDetail accountViewDetail;
    private static final Logger LOGGER = Logger.getLogger(CreateAccountViewFiltersFieldsAdded.class.getName());

    @DataProvider(name = "dataDriven")
    public Iterator<ViewSalesForce[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataView("json/CreateAccountsViewFiltersFieldAdded.json");
    }


    @Test(groups = {"Regression"}, dataProvider = "dataDriven")
    public void testCreateCampaignViewWithFilters(ViewSalesForce viewSalesForce) {
        mainPage = LoginPage.loginAsPrimaryUser();
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
        LOGGER.info("Account view was created");
        Assert.assertTrue(accountViewDetail.validateNameView(viewSalesForce.getViewName()));
        for(FieldToDisplayView fields:fieldToDisplayViews){
            Assert.assertTrue(accountViewDetail.validateFieldDisplayed(fields.getFieldToDisplay()));
        }
    }

    @AfterMethod(groups = {"Regression"})
    public void tearDown() {
        accountViewDetail.clickDeleteLnk(true);
        LOGGER.info("Account View was deleted");
    }
}
