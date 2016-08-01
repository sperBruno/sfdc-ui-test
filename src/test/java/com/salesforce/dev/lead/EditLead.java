package com.salesforce.dev.lead;

import com.salesforce.dev.framework.dto.Lead;
import com.salesforce.dev.framework.utils.JSONMapper;
import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.ObjectGenie;
import com.salesforce.dev.pages.leads.LeadDetail;
import com.salesforce.dev.pages.leads.LeadForm;
import com.salesforce.dev.pages.leads.LeadsHome;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author jimmy vargas on 6/21/2015.
 */
public class EditLead {
    private static final Logger LOGGER = Logger.getLogger(EditLead.class.getName());
    private MainPage mainPage;

    private Lead lead, leadEditEnum;

    @BeforeMethod(groups = {"Acceptance"})
    public void setup() {
        lead = JSONMapper.getLead("CreateLeadBase.json");
        leadEditEnum = JSONMapper.getLead("EditLead.json");

        //Creating a lead
        ObjectGenie.createLead(lead);
    }

    @Test(groups = {"Acceptance"})
    public void testEditLead() {
        mainPage = LoginPage.loginAsPrimaryUser();
        LeadsHome leadsHome = mainPage.gotoNavBar().gotToLeadsHome();
        LeadDetail leadDetail = leadsHome.openLead(lead.lastName);
        LeadForm leadForm = leadDetail.clickEditBtn();

        //editing some fields
        leadForm.setLastName(leadEditEnum.lastName);
        leadForm.setPhone(leadEditEnum.phone);
        leadForm.setWebsite(leadEditEnum.website);
        leadForm.selectLeadStatusByVisibleText(leadEditEnum.leadStatus);
        leadForm.setNumEmployees(leadEditEnum.numEmployees);
        leadForm.selectProductInterestByVisibleText(leadEditEnum.productInterest);
        leadForm.selectPrimaryByVisibleText(leadEditEnum.primary);
        leadForm.setDescription(leadEditEnum.description);
        leadDetail = leadForm.clickSaveBtn();

        //assertions
        Assert.assertEquals(leadDetail.getWebsite(), "http://" + leadEditEnum.website, "The website is not correct");
        leadDetail.validateFields(leadEditEnum);
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        LeadsHome leadsHome = mainPage.gotoNavBar().gotToLeadsHome();
        LeadDetail leadDetail = leadsHome.openLead(leadEditEnum.lastName);
        leadDetail.deleteLead();
        LOGGER.info("Lead was deleted");
    }
}
