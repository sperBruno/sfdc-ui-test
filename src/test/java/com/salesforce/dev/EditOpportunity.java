package com.salesforce.dev;

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
 * Created by jimmy vargas on 6/20/2015.
 */
public class EditOpportunity {

    HomePage homePage;
    MainPage mainPage;

    String opportunityName = "Opportunity Edit";
    String closeDate = "Today";
    String stage = "Needs Analysis";

    @BeforeMethod(groups = {"BVT"})
    public void setup(){
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();

        //Creating an opportunity
        OpportunitiesHome opHome = mainPage.gotoNavBar().goToOpportunitiesHome();
        opHome.clickNewBtn();

        OpportunityForm opForm = new OpportunityBuilder(opportunityName,closeDate,stage)
                .build();
        OpportunityDetail opDetail = opForm.clickSaveBtn();

        //Todo: verify the opportunity has been created right

    }

    @Test(groups = {"BVT"})
    public void editOpportunity(){
        OpportunitiesHome opHome = mainPage.gotoNavBar().goToOpportunitiesHome();
        OpportunityDetail opDetail= opHome.openOpportunity(opportunityName);
        OpportunityForm opForm = opDetail.clickEditBtn();

        //todo:editing some fields

        opForm.clickSaveBtn();

        //todo: assertions

    }

    @AfterMethod(groups = {"BVT"})
    public void tearDown(){
        OpportunitiesHome opHome = mainPage.gotoNavBar().goToOpportunitiesHome();
        OpportunityDetail opDetail = opHome.openOpportunity(opportunityName);
        opDetail.deleteOpportunity();

    }

}
