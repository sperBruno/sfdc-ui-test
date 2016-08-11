package com.salesforce.dev.lead;

import com.salesforce.dev.framework.dto.ViewSalesForce;
import com.salesforce.dev.framework.utils.JSONMapper;
import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.base.NavigationBar;
import com.salesforce.dev.pages.leads.LeadView;
import com.salesforce.dev.pages.leads.LeadViewDetail;
import com.salesforce.dev.pages.leads.LeadsHome;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * This class will be used to test basic view of the creation of leads.
 *
 * @author Ariel Mattos.
 * @since 06/09/2015.
 */
public class CreateLeadsViewBasic {

    private MainPage mainPage;

    private NavigationBar navBar;

    private LeadsHome leadsHome;

    private LeadView leadView;

    private LeadViewDetail leadViewDetail;

    private ViewSalesForce viewSalesForce;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        viewSalesForce = JSONMapper.getGeneric(ViewSalesForce.class,"CreateLeadsViewBasic.json");
        mainPage = LoginPage.loginAsPrimaryUser();
        navBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"Acceptance"})
    public void testCreateLeadView( ) {
        leadsHome = navBar.gotToLeadsHome();
        leadView = leadsHome.clickNewViewLnk()
                .setViewName(viewSalesForce.getViewName())
                .setUniqueViewName(viewSalesForce.getUniqueViewName())
                .checkFilterByOwner(viewSalesForce.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForce.getRestrictVisibility());
        leadViewDetail = leadView.clickSaveBtn();
        Assert.assertTrue(leadViewDetail.validateNameView(viewSalesForce.getViewName()),
                "View name does not match " + viewSalesForce.getViewName());
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        leadViewDetail.clickDeleteLnk();
    }
}
