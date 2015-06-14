package com.salesforce.dev.pages.Chatter;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Monica Pardo on 6/13/2015.
 *  * TODO: complete the creation of the comment for the post created 
 */
public class ChatterHome {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(className = "publisherattachtext ")
    WebElement postLink;

    @FindBy(id = "publishereditablearea")
    WebElement postDescField;

    @FindBy(id = "publishersharebutton")
    WebElement shareBtn;

    @FindBy(xpath = "xpath=//div[@id='feedwrapper']/descendant::span[contains(.,'fgfg')]/following::a[contains(.,'Comment')]")
    WebElement commentLink;

    //to do: I need to found the XPATH for this element
    @FindBy(id = "ext-gen9")
    WebElement commentField;
    //to do: I need to found the XPATH for this element
    @FindBy(id = "ext-gen6")
    WebElement commentBtn;
    //to do: I need to found the XPATH for this element
    @FindBy(id = "commentmenu0D71a000000L2WN")
    WebElement commentMenu;
    //to do: I need to found the XPATH for this element
    @FindBy(id = "ext-gen14")
    WebElement deleteCommentOption;
    //to do: I need to found the XPATH for this element
    @FindBy(id = "spillovermenu0D51a000002i4tP")
    WebElement postMenu;

    @FindBy(xpath = "//a[@title='Delete this post']")
    WebElement deletePostOption;

    public ChatterHome(WebDriver driver){
        this.driver=driver;
        this.wait= DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
    public ChatterHome clickPost(){
        wait.until(ExpectedConditions.visibilityOf(postLink));
        postLink.click();
        return this;
    }
    public ChatterHome setPost(String PostDesc){
        wait.until(ExpectedConditions.visibilityOf(postDescField));
        postDescField.clear();
        postDescField.sendKeys(PostDesc);
        return  this;
    }
    public ChatterHome clickShareBtn(){
        shareBtn.click();
        return this;
    }
    public ChatterHome clickCommentForPost(String PostValue){

        driver.findElement(By.xpath("//div[@id='feedwrapper']/descendant::span[contains(.,'" + PostValue +"')]/following::a[contains(.,'Comment')]")).click();
        return this;
    }
    public ChatterHome setComment(String comment){
        wait.until(ExpectedConditions.visibilityOf(commentField));
        commentField.sendKeys(comment);
        return this;

    }
    public ChatterHome clickCommentBtn(){
        commentBtn.click();
        return this;
    }
    public ChatterHome DeleteComment(){
        commentMenu.click();
        deleteCommentOption.click();
        return this;
    }
    public ChatterHome DeletePost(){
        postMenu.click();
        deletePostOption.click();
        return this;
    }
}
