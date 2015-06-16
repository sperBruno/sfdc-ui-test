package com.salesforce.dev;

import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.Opportunities.OpportunityBuilder;
import com.salesforce.dev.pages.Opportunities.OpportunityDetail;
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
    MainPage mainPage;
    NavigationBar navBar;

    @BeforeMethod
    public void setUp(){
        homePage = new HomePage();
        mainPage = homePage.loginAs(account,password);
        navBar = mainPage.gotoNavBar();

    }
    @Test
    public void CreateOpportunity(){ /*TODO: this test cases it is not finished it is only using for creatung the clases and methods*/

        OpportunitiesHome opTab = navBar.goToOpportunitiesHome();
        //opTab.selectViewByVisibleText("New This Week");
        OpportunityForm newOpPage = opTab.clickNewBtn();

        /*
        //small piece for all test case


        newOpPage.setOpportunityName(opportunityName);
        newOpPage.setCloseDate();
        newOpPage.setStageByVisibleText(stage);*/
        //Applying Builder
        OpportunityForm opForm= new OpportunityBuilder(opportunityName,"today",stage)
                .setOpDescription("Testing builder")
                .setAmount("1000")
                .build();

        OpportunityDetail opportunityDetails = opForm.clickSaveBtn();

        System.out.println("Op Owner" + opportunityDetails.getOpOwner());

        //deleting the opportunity
        opportunityDetails.deleteOpportunity();


        //verifying the oppotunity created
        //String opportunityDetails = opportunityPage.getOwner();
        //String opportunityDetails = opportunityPage.getName();


    }

    @AfterMethod
    public void tearDown(){

    }

}
