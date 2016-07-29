package com.salesforce.dev.lead;

import java.util.Iterator;

import com.salesforce.dev.framework.utils.DataDrivenManager;
import com.salesforce.dev.framework.dto.ViewSalesForce;
import com.salesforce.dev.pages.base.NavigationBar;
import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.leads.LeadView;
import com.salesforce.dev.pages.leads.LeadViewDetail;
import com.salesforce.dev.pages.leads.LeadsHome;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.objects.LeadGenie;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Ariel Mattos on 07/09/2015.
 */
public class EditLeadsViewBasic {
    private static final Logger LOGGER = Logger.getLogger(EditLeadsViewBasic.class.getName());
    private LeadsHome leadsHome;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private LeadView leadView;
    private String viewName;
    private LeadViewDetail leadViewDetail;

    @DataProvider(name = "dataDriven")
    public Iterator<ViewSalesForce[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataView("json/EditLeadsViewBasic.json");
    }

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        ViewSalesForce viewSalesForce = LeadGenie.getLeadsView("json/CreateLeadsViewBasic.json");
        viewName = viewSalesForce.getViewName();
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        leadsHome = navigationBar.gotToLeadsHome();
        leadView = leadsHome.clickNewViewLnk()
                .setViewName(viewName)
                .setUniqueViewName(viewSalesForce.getUniqueViewName());
        leadViewDetail = leadView.clickSaveBtn();
    }

    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testEditCampaign(ViewSalesForce viewSalesForceUpdate) {
        navigationBar = mainPage.gotoNavBar();
        leadsHome = navigationBar.gotToLeadsHome();
        leadView = leadsHome.clickEditViewLnk(viewName)
                .setViewName(viewSalesForceUpdate.getViewName())
                .setUniqueViewName(viewSalesForceUpdate.getUniqueViewName())
                .checkFilterByOwner(viewSalesForceUpdate.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForceUpdate.getRestrictVisibility());
        leadViewDetail = leadView.clickSaveBtn();
        Assert.assertTrue(leadViewDetail.validateNameView(viewSalesForceUpdate.getViewName()));
        LOGGER.info("leads View has been updated");
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        leadViewDetail.clickDeleteLnk(true);
        LOGGER.info("leads View was deleted");
    }
}
