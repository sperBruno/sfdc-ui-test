package com.salesforce.dev;

import com.salesforce.dev.framework.JSONMapper;
import com.salesforce.dev.framework.Objects.Lead;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Leads.*;
import com.salesforce.dev.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Jimmy Vargas on 6/15/2015.
 */
public class CreateLead {
    HomePage homePage;
    MainPage mainPage;
    NavigationBar navBar;

    Lead lead;


    @BeforeMethod(groups = {"BVT"})
    public void setUp(){

        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();
        navBar = mainPage.gotoNavBar();

        lead = JSONMapper.getLead("src\\test\\resources\\CreateLead.json");
    }

    @Test(groups = {"BVT"})
    public void createLead(){
        LeadsHome leadsHome = navBar.gotToLeadsHome();
        leadsHome.clickNewBtn();

        LeadForm leadForm = new LeadBuilder(lead.lastName, lead.company, lead.leadStatus)
                .setTitle(lead.title)
                .setDescription(lead.description)
                .build();
        LeadDetail leadDetail = leadForm.clickSaveBtn();
        //todo: Assertions
        Assert.assertTrue(leadDetail.getName().contains(lead.lastName),"The actual name doesn't contain the lastname" + lead.lastName);
        Assert.assertEquals(leadDetail.getCompany(), lead.company, "The company are not equal");
        Assert.assertEquals(leadDetail.getLeadStatus(), lead.leadStatus,"The lead is not correct");

    }

    @AfterMethod(groups={"BVT"})
    public void tearDown(){
        LeadsHome leadsHome = mainPage.gotoNavBar().gotToLeadsHome();
        LeadDetail leadDetail = leadsHome.openLead(lead.lastName);
        leadDetail.deleteLead();

    }
}
