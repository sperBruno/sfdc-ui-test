package com.salesforce.dev.oportunity;

import com.salesforce.dev.framework.dto.Opportunity;
import com.salesforce.dev.framework.utils.JSONMapper;
import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.ObjectGenie;
import com.salesforce.dev.pages.base.NavigationBar;
import com.salesforce.dev.pages.opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.opportunities.OpportunityDetail;
import com.salesforce.dev.pages.opportunities.OpportunityForm;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by jimmy vargas on 6/20/2015.
 */
public class EditOpportunity {

    private MainPage mainPage;
    private NavigationBar navBar;
    private Opportunity oppEnum, oppEditEnum;

    @BeforeMethod(groups = {"Acceptance"})
    public void setup() {
        mainPage = LoginPage.loginAsPrimaryUser();
        navBar = mainPage.gotoNavBar();

        oppEnum = JSONMapper.getOpportunity("json/CreateOpportunityBase.json");
        oppEditEnum = JSONMapper.getOpportunity("json/EditOpportunity.json");

        // creating the opportunity base
        ObjectGenie.createOpportunity(oppEnum);
    }

    @Test(groups = {"Acceptance"})
    public void testEditOpportunity() {
        OpportunitiesHome opTab = navBar.goToOpportunitiesHome ();
        OpportunityDetail opDetail = opTab.openOpportunity (oppEnum.opportunityName);
        OpportunityForm opForm = opDetail.clickEditBtn ();
        opForm.setOpportunityName (oppEditEnum.opportunityName);
        opForm.setCloseDate (oppEditEnum.closeDate);
        opForm.selectStageByVisibleText (oppEditEnum.stage);
        opForm.setPrivateCheckBox (oppEditEnum.privateChk);
        opForm.selectTypeByVisibleText (oppEditEnum.type);
        opForm.selectLeadSourceByVisibleText (oppEditEnum.leadSource);
        opForm.setNextStep (oppEditEnum.nextStep);
        opForm.setAmount (oppEditEnum.amount);
        opForm.setProbability (oppEditEnum.probability);
        opForm.setOrderNumber (oppEditEnum.orderNumber);
        opForm.setTrackingNumber (oppEditEnum.trackingNumber);
        opForm.setMainCompetitors (oppEditEnum.mainCompetitors);
        opForm.selectDeliveryStatusByVisibleText (oppEditEnum.deliveryStatus);
        opForm.setDescription (oppEditEnum.description);
        OpportunityDetail oppDetail = opForm.clickSaveBtn ();

        oppDetail.validateFields (oppEditEnum);
    }
    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        OpportunitiesHome opHome = mainPage.gotoNavBar().goToOpportunitiesHome();
        OpportunityDetail opDetail = opHome.openOpportunity(oppEditEnum.opportunityName);
        opDetail.deleteOpportunity();

    }

}
