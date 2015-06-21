package com.salesforce.dev;

import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Leads.LeadBuilder;
import com.salesforce.dev.pages.Leads.LeadDetail;
import com.salesforce.dev.pages.Leads.LeadForm;
import com.salesforce.dev.pages.Leads.LeadsHome;
import com.salesforce.dev.pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by jimmy vargas on 6/21/2015.
 */
public class EditLead {
    HomePage homePage;
    MainPage mainPage;

    String lastName = "Lead Edit";
    String company = "ACME";
    String leadStatus = "Working - Contacted";

    @BeforeMethod(groups = {"BVT"})
    public void setup(){
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();

        //Creating an opportunity
        LeadsHome opHome = mainPage.gotoNavBar().gotToLeadsHome();
        opHome.clickNewBtn();

        LeadForm leadForm = new LeadBuilder(lastName,company,leadStatus)
                .build();
        LeadDetail opDetail = leadForm.clickSaveBtn();

        //Todo: verify the opportunity has been created right

    }

    @Test(groups = {"BVT"})
    public void editLead(){
        LeadsHome leadsHome = mainPage.gotoNavBar().gotToLeadsHome();
        LeadDetail leadDetail= leadsHome.openLead(lastName);
        LeadForm leadForm = leadDetail.clickEditBtn();

        //todo:editing some fields

        leadForm.clickSaveBtn();

        //todo: assertions

    }

    @AfterMethod(groups = {"BVT"})
    public void tearDown(){
        LeadsHome leadsHome = mainPage.gotoNavBar().gotToLeadsHome();
        LeadDetail leadDetail= leadsHome.openLead(lastName);
        leadDetail.deleteLead();

    }
}
