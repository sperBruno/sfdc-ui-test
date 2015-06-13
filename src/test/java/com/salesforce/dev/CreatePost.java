package com.salesforce.dev;

import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Chatter.ChatterHome;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.Opportunities.OpportunityDetails;
import com.salesforce.dev.pages.Opportunities.OpportunityForm;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Monica Pardo on 6/13/2015.
 * TODO: complete the creation of the comment for the post created
 */
public class CreatePost {
    String account = "moni.pz@gmail.com";
    String password = "moni123P";

    String post = "Post test";



    HomePage homePage;
    MainPage mainPage;
    NavigationBar navBar;
    ChatterHome chatterHome;

    @BeforeMethod
    public void setUp(){
        homePage = new HomePage();
        mainPage = homePage.loginAs(account,password);
        navBar = mainPage.gotoNavBar();

    }
    @Test
    public void CreateOpportunity(){

        chatterHome = navBar.goToChatterHome();
        chatterHome.clickPost();
        chatterHome.setPost(post);
        chatterHome.clickShareBtn();
        chatterHome.clickCommentForPost(post);



    }

    @AfterMethod
    public void tearDown(){

    }

}
