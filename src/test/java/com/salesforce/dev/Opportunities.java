package com.salesforce.dev;

import com.salesforce.dev.pages.*;
import com.salesforce.dev.pages.Opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.Opportunities.OpportunityDetails;
import com.salesforce.dev.pages.Opportunities.OpportunityForm;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Jimmy Vargas on 6/10/2015.
 */
public class Opportunities {

    String account = "gordines007@hotmail.com";
    String password = "control123!@#";

    String opportunityName = "opNameAUT";
    String stage = "Prospecting";


    HomePage homePage;
    LoginPage loginPage;
    MainPage mainPage;

    @BeforeMethod
    public void setUp(){
        homePage = new HomePage();
        mainPage = homePage.loginAs(account,password);

    }
    @Test
    public void CreateOpportunity(){

        OpportunitiesHome opTab = mainPage.gotoOpportunitiesHome();
        //opTab.selectViewByVisibleText("New This Week");

        //small piece for all test case
        OpportunityForm newOpPage = (OpportunityForm)opTab.clickNewBtn();

        newOpPage.setOpportunityName(opportunityName);
        newOpPage.setCloseDate();
        newOpPage.setStageByVisibleText(stage);
        OpportunityDetails opportunityPage = newOpPage.clickSaveBtn();



    }

    @AfterMethod
    public void tearDown(){

    }

}
