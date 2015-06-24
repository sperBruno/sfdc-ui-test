package com.salesforce.dev.pages;

import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Leads.LeadEnum;
import com.salesforce.dev.pages.Leads.LeadsHome;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Opportunities.*;

/**
 * Created by jimmy vargas on 6/23/2015.
 */
public class Common {

    public static void createOpportunity(OpportunityEnum oppEnum){

        HomePage homePage = new HomePage();
        MainPage mainPage = homePage.loginAsPrimaryUser();
        NavigationBar navBar = mainPage.gotoNavBar();

        OpportunitiesHome opTab = navBar.goToOpportunitiesHome();
        opTab.clickNewBtn();

        OpportunityForm opForm= new OpportunityBuilder(oppEnum.opportunityName,oppEnum.closeDate,oppEnum.stage)
                .setOpDescription(oppEnum.description)
                .setOrderNumber(oppEnum.orderNumber)
                .build();
        opForm.clickSaveBtn();

    }
    public static void createLead(LeadEnum leadEnum){

        HomePage homePage = new HomePage();
        MainPage mainPage = homePage.loginAsPrimaryUser();
        NavigationBar navBar = mainPage.gotoNavBar();

        LeadsHome leadsHome = navBar.gotToLeadsHome();
        leadsHome.clickNewBtn();

        OpportunityForm opForm= new OpportunityBuilder(leadEnum.lastName,leadEnum.company,leadEnum.leadStatus)
                .build();
        opForm.clickSaveBtn();

    }

}
