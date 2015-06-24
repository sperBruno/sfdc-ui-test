package com.salesforce.dev;

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

    LeadEnum leadEnum,leadEditEnum;

    @BeforeMethod(groups = {"BVT"})
    public void setup(){
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();

        leadEnum = new LeadEnum("src\\test\\resources\\CreateLeadBase.json");
        leadEditEnum = new LeadEnum("src\\test\\resources\\EditLead.json");

        //Creating a lead
        Common.createLead(leadEnum);
        /*
        LeadsHome opHome = mainPage.gotoNavBar().gotToLeadsHome();
        opHome.clickNewBtn();

        LeadForm leadForm = new LeadBuilder(lastName,company,leadStatus)
                .build();
        LeadDetail opDetail = leadForm.clickSaveBtn();

        //Todo: verify the opportunity has been created right
        */
    }

    @Test(groups = {"BVT"})
    public void editLead(){
        LeadsHome leadsHome = mainPage.gotoNavBar().gotToLeadsHome();
        LeadDetail leadDetail= leadsHome.openLead(leadEnum.lastName);
        LeadForm leadForm = leadDetail.clickEditBtn();

        //todo:editing some fields
        leadForm.setLastName(leadEditEnum.lastName);
        leadForm.selectLeadStatusByVisibleText(leadEditEnum.leadStatus);
        leadForm.clickSaveBtn();

        //todo: assertions
        Assert.assertTrue(leadDetail.getName().contains(leadEditEnum.lastName), "The actual name doesn't contain the lastname" + leadEnum.lastName);
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
