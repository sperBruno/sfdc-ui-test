package com.salesforce.dev.pages;

import com.salesforce.dev.framework.dto.Lead;
import com.salesforce.dev.framework.dto.Opportunity;
import com.salesforce.dev.pages.Leads.LeadBuilder;
import com.salesforce.dev.pages.Leads.LeadForm;
import com.salesforce.dev.pages.Leads.LeadsHome;
import com.salesforce.dev.pages.Opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.Opportunities.OpportunityBuilder;
import com.salesforce.dev.pages.Opportunities.OpportunityForm;
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
