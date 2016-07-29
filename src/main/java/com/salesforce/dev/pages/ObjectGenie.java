package com.salesforce.dev.pages;

import com.salesforce.dev.framework.dto.Lead;
import com.salesforce.dev.framework.dto.Opportunity;
import com.salesforce.dev.pages.leads.LeadBuilder;
import com.salesforce.dev.pages.leads.LeadForm;
import com.salesforce.dev.pages.leads.LeadsHome;
import com.salesforce.dev.pages.opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.opportunities.OpportunityBuilder;
import com.salesforce.dev.pages.opportunities.OpportunityForm;
import com.salesforce.dev.pages.base.NavigationBar;

/**
 * Created by jimmy vargas on 6/23/2015.
 */
public class ObjectGenie {

    public static void createOpportunity(Opportunity oppEnum) {

        HomePage homePage = new HomePage();
        MainPage mainPage = homePage.clickLoginBtn().loginAsPrimaryUser();
        NavigationBar navBar = mainPage.gotoNavBar();

        OpportunitiesHome opTab = navBar.goToOpportunitiesHome();
        opTab.clickNewBtn();

        OpportunityForm opForm = new OpportunityBuilder(oppEnum.opportunityName, oppEnum.closeDate, oppEnum.stage)
                .setOpDescription(oppEnum.description)
                .setOrderNumber(oppEnum.orderNumber)
                .build();
        opForm.clickSaveBtn();

    }

    public static void createLead(Lead lead) {
        MainPage mainPage;
        mainPage = LoginPage.loginAsPrimaryUser();
        NavigationBar navBar = mainPage.gotoNavBar();

        LeadsHome leadsHome = navBar.gotToLeadsHome();
        leadsHome.clickNewBtn();

        LeadForm leadForm = new LeadBuilder(lead.lastName, lead.company, lead.leadStatus)
                .build();
        leadForm.clickSaveBtn();

    }
}
