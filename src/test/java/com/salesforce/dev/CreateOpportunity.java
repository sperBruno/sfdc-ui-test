package com.salesforce.dev;

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.framework.JSONReader;
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

    OpportunityEnum oppEnum;

    @BeforeMethod(groups = {"BVT"})
    public void setUp(){
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();
        navBar = mainPage.gotoNavBar();

        System.out.println("reading from json");
        //JSONReader jr = new JSONReader("D:\\GitHub\\CarlosSeleniumProjectFork\\SFDC-Team1\\src\\test\\resources\\CreateOpportunityBase.json");
        oppEnum = new OpportunityEnum("src\\test\\resources\\CreateOpportunityBase.json");

    }

    @Test(groups = {"BVT"})
    public void CreateOpportunity(){

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

    @AfterMethod(groups = {"BVT"})
    public void tearDown(){
        OpportunitiesHome opHome = navBar.goToOpportunitiesHome();
        OpportunityDetail opDetail = opHome.openOpportunity(oppEnum.opportunityName);
        opDetail.deleteOpportunity();


    }

}
