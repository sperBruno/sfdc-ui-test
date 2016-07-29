package com.salesforce.dev.chatter;

import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.base.NavigationBar;
import com.salesforce.dev.pages.chatter.ChatterHome;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by Monica Pardo on 6/13/2015.
 */
public class CreatePost {

    private NavigationBar navigationBar;
    private ChatterHome chatterHome;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"Acceptance"})
    public void CreatePostAndComment() {
        final String post = "Post test";
        final String comment = "new comment";
        chatterHome = navigationBar.goToChatterHome()
                .clickPost()
                .setPost(post)
                .clickShareBtn()
                .clickCommentForPost(post)
                .setComment(comment)
                .clickCommentBtn();
        assertTrue(chatterHome.VerifyPostCreated(post), "Post Was not Created");
        assertTrue(chatterHome.VerifyCommentCreated(comment), "Comment Was not Created");
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        chatterHome.DeletePost();
    }
}
