package com.salesforce.dev;

import com.salesforce.dev.framework.JSONMapper;
import com.salesforce.dev.framework.Objects.Opportunity;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Opportunities.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Jimmy Vargas on 6/10/2015.
 */
public class CreateOpportunity {

    HomePage homePage;
    MainPage mainPage;
    NavigationBar navBar;

    Opportunity oppEnum;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp(){
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();
        navBar = mainPage.gotoNavBar();

        oppEnum = JSONMapper.getOpportunity("src\\test\\resources\\CreateOpportunity.json");

    }

    @Test(groups = {"Acceptance"})
    public void testCreateOpportunity(){

        OpportunitiesHome opTab = navBar.goToOpportunitiesHome();
        opTab.clickNewBtn();

        OpportunityForm opForm= new OpportunityBuilder(oppEnum.opportunityName,oppEnum.closeDate,oppEnum.stage)
                .setOpDescription(oppEnum.description)
                .setPrivate(oppEnum.privateChk)
                .setAmount(oppEnum.amount)
                .setOrderNumber(oppEnum.orderNumber)
                .build();
        OpportunityDetail opportunityDetails = opForm.clickSaveBtn();

        System.out.println("Private: "+opportunityDetails.isPrivate());

        //Assertions
        //TODO: still need to implement the assertions

    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown(){
        OpportunitiesHome opHome = navBar.goToOpportunitiesHome();
        OpportunityDetail opDetail = opHome.openOpportunity(oppEnum.opportunityName);
        opDetail.deleteOpportunity();


    }

}
