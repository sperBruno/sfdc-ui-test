package com.salesforce.dev;

import com.salesforce.dev.framework.Environment;
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
public class CreateOpportunity {

    String opportunityName = "opNameAUT";
    String stage = "Prospecting";
    String description = "Auto desc";
    String closeDate = "6/6/2015";
    String amount = "10000";
    String orderNumber = "123456";


    HomePage homePage;
    MainPage mainPage;
    NavigationBar navBar;

    @BeforeMethod(groups = {"BVT"})
    public void setUp(){
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();
        navBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"BVT"})
    public void CreateOpportunity(){

        OpportunitiesHome opTab = navBar.goToOpportunitiesHome();
        opTab.clickNewBtn();

        OpportunityForm opForm= new OpportunityBuilder(opportunityName,closeDate,stage)
                .setOpDescription(description)
                .setPrivate(true)
                .setAmount(amount)
                .setOrderNumber(orderNumber)
                .build();
        OpportunityDetail opportunityDetails = opForm.clickSaveBtn();

        System.out.println("Private: "+opportunityDetails.isPrivate());

        //Assertions
        //TODO: still need to implement the assertions

    }

    @AfterMethod(groups = {"BVT"})
    public void tearDown(){
        OpportunitiesHome opHome = navBar.goToOpportunitiesHome();
        OpportunityDetail opDetail = opHome.openOpportunity(opportunityName);
        opDetail.deleteOpportunity();


    }

}
