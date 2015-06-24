package com.salesforce.dev;

import com.salesforce.dev.framework.Environment;
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

    LeadEnum leadEnum;

    String lastName = "JVLastName";
    String company = "JVCompany";
    String leadStatus = "Working - Contacted";

    @BeforeMethod(groups = {"BVT"})
    public void setUp(){

        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();
        navBar = mainPage.gotoNavBar();

        leadEnum = new LeadEnum("src\\test\\resources\\CreateLead.json");
    }

    @Test(groups = {"BVT"})
    public void createLead(){
        LeadsHome leadsHome = navBar.gotToLeadsHome();
        leadsHome.clickNewBtn();

        LeadForm leadForm = new LeadBuilder(leadEnum.lastName,leadEnum.company,leadEnum.leadStatus)
                .setTitle(leadEnum.title)
                .setDescription(leadEnum.description)
                .build();
        LeadDetail leadDetail = leadForm.clickSaveBtn();
        //todo: Assertions
        Assert.assertTrue(leadDetail.getName().contains(leadEnum.lastName),"The actual name doesn't contain the lastname" + leadEnum.lastName);
        Assert.assertEquals(leadDetail.getCompany(), leadEnum.company, "The company are not equal");
        Assert.assertEquals(leadDetail.getLeadStatus(),leadEnum.leadStatus,"The lead is not correct");

    }

    @AfterMethod(groups={"BVT"})
    public void tearDown(){
        LeadsHome leadsHome = mainPage.gotoNavBar().gotToLeadsHome();
        LeadDetail leadDetail = leadsHome.openLead(leadEnum.lastName);
        leadDetail.deleteLead();

    }
}
