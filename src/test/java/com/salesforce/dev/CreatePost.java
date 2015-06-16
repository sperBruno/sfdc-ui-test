package com.salesforce.dev;

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Chatter.ChatterHome;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Monica Pardo on 6/13/2015.
 *
 */
public class CreatePost {

    String post = "Post test";
    String comment = "new comment";

    HomePage homePage;
    MainPage mainPage;
    NavigationBar navigationBar;
    ChatterHome chatterHome;

    @BeforeMethod
    public void setUp(){
        homePage = new HomePage();
        String userNameValue= Environment.getInstance().getPrimaryUser();
        String passwordValue=Environment.getInstance().getPrimaryPassword();
        mainPage = homePage.loginAs(userNameValue, passwordValue);
        navigationBar = mainPage.gotoNavBar();

    }
    @Test
    public void CreatePostAndComment(){

        chatterHome = navigationBar.goToChatterHome();
        chatterHome.clickPost();
        chatterHome.setPost(post);
        chatterHome.clickShareBtn();
        chatterHome.clickCommentForPost(post);
        chatterHome.setComment(comment);
        chatterHome.clickCommentBtn();





    }

    @AfterMethod
    public void tearDown(){
        chatterHome.DeletePost();
    }

}
