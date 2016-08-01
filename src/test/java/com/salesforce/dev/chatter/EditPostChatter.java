package com.salesforce.dev.chatter;

import java.util.Iterator;

import com.salesforce.dev.framework.dto.Chatter;
import com.salesforce.dev.framework.utils.DataDrivenManager;
import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.base.NavigationBar;
import com.salesforce.dev.pages.chatter.ChatterHome;
import com.salesforce.dev.pages.chatter.EditPost;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Veronica Prado on 9/3/2015.
 * @author Bruno Barrios
 */
public class EditPostChatter {
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private ChatterHome chatterHome;
    private Chatter createChatter;
    private DataDrivenManager dataDrivenManager = new DataDrivenManager();

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        createChatter = getChatter("Chatter.json");
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        chatterHome = navigationBar.goToChatterHome();
        chatterHome.clickPost()
                .setPost(createChatter.getPost())
                .clickShareBtn();
    }

    @Test(groups = {"Acceptance"})
    public void CreatePostAndComment() {
        Chatter chatter = getChatter("EditChatter.json");
        EditPost editPost = chatterHome.editPost(createChatter.getPost());
        editPost.setEditTextBox(chatter.getPost());
        chatterHome = editPost.clickSaveEditBtn();
        Assert.assertTrue(chatterHome.VerifyPostCreated(chatter.getPost()), "Post has not been Updated");
    }

    private Chatter getChatter(String fileJson) {
        Iterator<Chatter[]> chattersData = dataDrivenManager.getChatter(fileJson);
        return chattersData.next()[0];
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        chatterHome.DeletePost();
    }
}
