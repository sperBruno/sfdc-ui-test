package com.salesforce.dev;

import com.salesforce.dev.framework.JSONMapper;
import com.salesforce.dev.framework.Objects.Opportunity;
import com.salesforce.dev.pages.Common;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Opportunities.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by jimmy vargas on 6/20/2015.
 */
public class EditOpportunity {

    HomePage homePage;
    MainPage mainPage;

    Opportunity oppEnum,oppEditEnum;

    @BeforeMethod(groups = {"BVT"})
    public void setup(){
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();


        oppEnum = JSONMapper.getOpportunity("src\\test\\resources\\CreateOpportunityBase.json");
        oppEditEnum = JSONMapper.getOpportunity("src\\test\\resources\\EditOpportunity.json");

        // creating the opportunity base
        Common.createOpportunity(oppEnum);


        //Todo: verify the opportunity has been created right

    }

    @Test(groups = {"BVT"})
    public void editOpportunity(){

        OpportunitiesHome opHome = mainPage.gotoNavBar().goToOpportunitiesHome();
        OpportunityDetail opDetail= opHome.openOpportunity(oppEnum.opportunityName);

        OpportunityForm opForm = opDetail.clickEditBtn();
            opForm.setOpportunityName(oppEditEnum.opportunityName);
            opForm.setCloseDate(oppEditEnum.closeDate);
            opForm.selectStageByVisibleText(oppEditEnum.stage);
        //todo:editing some fields

        OpportunityDetail oppDetail = opForm.clickSaveBtn();

        //todo: assertions
        Assert.assertEquals(oppDetail.getOpName(),oppEditEnum.opportunityName,"The opportunity name is not equal");
        //Assert.assertEquals(oppDetail.getCloseDate(),oppEditEnum.closeDate,"The close date it is no equal");
        Assert.assertEquals(oppDetail.getStage(),oppEditEnum.stage,"The stage is not equal");
    }

    @AfterMethod(groups = {"BVT"})
    public void tearDown(){
        OpportunitiesHome opHome = mainPage.gotoNavBar().goToOpportunitiesHome();
        OpportunityDetail opDetail = opHome.openOpportunity(oppEditEnum.opportunityName);
        opDetail.deleteOpportunity();

    }

}
