package com.salesforce.dev.pages.chatter;

import com.salesforce.dev.framework.selenium.CommonOperation;
import com.salesforce.dev.pages.base.AbstractBasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.salesforce.dev.framework.selenium.CommonOperation.clickWebElement;
import static com.salesforce.dev.framework.selenium.CommonOperation.setWebElement;

/**
 * Created by Monica Pardo on 6/13/2015.
 * *
 */
public class ChatterHome extends AbstractBasePage {

    @FindBy(id = "publisherAttachTextPost")
    WebElement postLink;

    @FindBy(css = ".chatterPublisherRTE.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders.placeholder")
    WebElement postDescField;

    @FindBy(id = "publishersharebutton")
    WebElement shareBtn;

    @FindBy(xpath = "//textarea[@title='Write a comment...']")
    WebElement commentField;

    @FindBy(xpath = "//input[@title='Comment']")
    WebElement commentBtn;

    @FindBy(xpath = "//a[@title='More Actions']")
    WebElement postMenu;

    @FindBy(xpath = "//a[@title='Delete this post']")
    WebElement deletePostOption;

    @FindBy(xpath = "//a[@title='Edit this post']")
    WebElement editPostOption;

    @FindBy(className = "publisherattachtext ")
    WebElement postSection;

    @FindBy(id = "quickActionFeedBodyInput")
    WebElement editPostTextArea;

    @FindBy(name = "quickActionSubmitButton")
    WebElement saveEditBtn;
    @FindBy(id = "quickActionContainer")
    private WebElement editContainer;
    @FindBy(className = "cke_wysiwyg_frame cke_reset")
    private WebElement editFrame;
    @FindBy(css = ".cke_wysiwyg_frame.cke_reset")
    private WebElement richTextEditorFrame;

    public ChatterHome clickPost() {
        clickWebElement(postLink);
        return this;
    }

    public ChatterHome setPost(String postDesc) {
        driver.switchTo().frame(richTextEditorFrame);
        wait.until(ExpectedConditions.visibilityOf(postDescField));
        setWebElement(postDescField, postDesc);
        driver.switchTo().defaultContent();
        return this;
    }

    public EditPost editPost(String postName) {
        clickWebElement(driver.findElement(By.xpath("//div[@id='feedwrapper']/descendant::span[contains(.,'" + postName + "')]/following::a[contains(@title,'More Actions')]")));
        clickWebElement(editPostOption);
        return new EditPost();
    }

    public ChatterHome clickShareBtn() {
        shareBtn.click();
        return this;
    }

    public ChatterHome clickCommentForPost(String PostValue) {
        driver.findElement(By.xpath("//div[@id='feedwrapper']/descendant::span[contains(.,'" + PostValue + "')]/following::a[contains(.,'Comment')]")).click();
        return this;
    }

    public ChatterHome setComment(String comment) {
        wait.until(ExpectedConditions.visibilityOf(commentField));
        commentField.sendKeys(comment);
        return this;

    }

    public ChatterHome clickCommentBtn() {
        commentBtn.click();
        return this;
    }

    public ChatterHome DeletePost() {
        postMenu.click();
        deletePostOption.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();
        return this;
    }

    public boolean VerifyPostCreated(String post) {
        try {
            WebElement postValuePage = driver.findElement(By.xpath("//div[@id='feedwrapper']/descendant::span[contains(.,'" + post + "')]"));
            wait.until(ExpectedConditions.visibilityOf(postValuePage));
            return true;
        } catch (WebDriverException e) {
            return false;
        }

    }

    public boolean VerifyCommentCreated(String comment) {
        try {

            WebElement commentValuePage = driver.findElement(By.xpath("//div[@class='feeditemcommentbody']/descendant::span[contains(.,'" + comment + "')]"));
            wait.until(ExpectedConditions.visibilityOf(commentValuePage));
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    public boolean IsUserInChatterTab() {
        return CommonOperation.isWebElementVisible(postSection);
    }

}
