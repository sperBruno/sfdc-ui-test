package com.salesforce.dev;

import com.salesforce.dev.pages.base.NavigationBar;
import com.salesforce.dev.pages.Chatter.ChatterHome;
import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Monica Pardo on 6/13/2015.
 */
public class CreatePost {

    private NavigationBar navigationBar;
    private ChatterHome chatterHome;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp(){
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"Acceptance"})
    public void CreatePostAndComment() {
        chatterHome = navigationBar.goToChatterHome();
        chatterHome.clickPost();
        String post = "Post test";
        chatterHome.setPost(post);
        chatterHome.clickShareBtn();
        Assert.assertTrue(chatterHome.VerifyPostCreated(post), "Post Was not Created");
        chatterHome.clickCommentForPost(post);
        String comment = "new comment";
        chatterHome.setComment(comment);
        chatterHome.clickCommentBtn();
        Assert.assertTrue(chatterHome.VerifyCommentCreated(comment), "Comment Was not Created");
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        chatterHome.DeletePost();
    }
}
