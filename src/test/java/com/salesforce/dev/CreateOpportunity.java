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

    String account;
    String password;

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
        account= Environment.getInstance().getPrimaryUser();
        password = Environment.getInstance().getPrimaryPassword();

        homePage = new HomePage();
        mainPage = homePage.loginAs(account, password);
        navBar = mainPage.gotoNavBar();

        System.out.println("SETUP create opportunity");


    }
    @Test(groups = {"BVT"})
    public void CreateOpportunity(){ /*TODO: this test cases it is not finished it is only using for creatung the clases and methods*/

        OpportunitiesHome opTab = navBar.goToOpportunitiesHome();
        opTab.clickNewBtn();

        OpportunityForm opForm= new OpportunityBuilder(opportunityName,closeDate,stage)
                .setOpDescription(description)
                .setAmount(amount)
                .setOrderNumber(orderNumber)
                .build();
        OpportunityDetail opportunityDetails = opForm.clickSaveBtn();

        System.out.println("Op Owner" + opportunityDetails.getOpOwner());


        //verifying the oppotunity created
        //String opportunityDetails = opportunityPage.getOwner();
        //String opportunityDetails = opportunityPage.getName();


    }

    @AfterMethod(groups = {"BVT"})
    public void tearDown(){
        OpportunitiesHome opHome = navBar.goToOpportunitiesHome();
        OpportunityDetail opDetail = opHome.openOpportunity(opportunityName);
        opDetail.deleteOpportunity();


    }

}
