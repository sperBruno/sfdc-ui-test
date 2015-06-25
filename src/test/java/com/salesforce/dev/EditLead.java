package com.salesforce.dev;

import com.salesforce.dev.framework.JSONMapper;
import com.salesforce.dev.framework.Objects.Lead;
import com.salesforce.dev.pages.Common;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Leads.*;
import com.salesforce.dev.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by jimmy vargas on 6/21/2015.
 */
public class EditLead {
    HomePage homePage;
    MainPage mainPage;

    Lead lead,leadEditEnum;

    @BeforeMethod(groups = {"BVT"})
    public void setup(){
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();

        lead = JSONMapper.getLead("src\\test\\resources\\CreateLeadBase.json");
        leadEditEnum = JSONMapper.getLead("src\\test\\resources\\EditLead.json");

        //Creating a lead
        Common.createLead(lead);

    }

    @Test(groups = {"BVT"})
    public void editLead(){
        LeadsHome leadsHome = mainPage.gotoNavBar().gotToLeadsHome();
        LeadDetail leadDetail= leadsHome.openLead(lead.lastName);
        LeadForm leadForm = leadDetail.clickEditBtn();

        //todo:editing some fields
        leadForm.setLastName(leadEditEnum.lastName);
        leadForm.selectLeadStatusByVisibleText(leadEditEnum.leadStatus);
        leadForm.clickSaveBtn();

        //todo: assertions
        Assert.assertTrue(leadDetail.getName().contains(leadEditEnum.lastName), "The actual name doesn't contain the lastname" + lead.lastName);
        Assert.assertEquals(leadDetail.getCompany(), leadEditEnum.company, "The company are not equal");
        Assert.assertEquals(leadDetail.getLeadStatus(), leadEditEnum.leadStatus, "The lead is not correct");

    }

    @AfterMethod(groups = {"BVT"})
    public void tearDown(){
        LeadsHome leadsHome = mainPage.gotoNavBar().gotToLeadsHome();
        LeadDetail leadDetail= leadsHome.openLead(leadEditEnum.lastName);
        leadDetail.deleteLead();

    }
}
