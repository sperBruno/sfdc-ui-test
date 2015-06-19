package com.salesforce.dev.pages.Base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jimmy Vargas on 6/13/2015.
 *
 * This class will contain the common objects for the Details pages
 *
 * @author: Jimmy Vargas
 * @since: 6/13/2015
 */
public abstract class DetailsBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name = "edit")
    WebElement editBtn;

    @FindBy(name = "del")
    WebElement deleteBtn;

    @FindBy(name = "delete")
    WebElement deleteAccBtn;

    @FindBy(name = "clone")
    WebElement cloneBtn;

    /**
     * Clicks the Edit button
     *
     * @author: Jimmy Vargas
     * @since: 6/13/2015
     */
    protected void clickEditButton() {
        wait.until(ExpectedConditions.visibilityOf(editBtn));
        editBtn.click();
    }

    /**
     * Clicks delete button
     *
     * @author: Jimmy Vargas
     * @since: 6/13/2015
     */
    protected void clickDeleteButton(boolean confirmDeletion) {
        wait.until(ExpectedConditions.visibilityOf(deleteBtn));
        deleteBtn.click();
        Alert alert;

        try{
            alert = driver.switchTo().alert();

            if (confirmDeletion){
                alert.accept();
            }
            alert.dismiss();
        }
        catch(WebDriverException e){
            System.out.println("Delete Object: " + e.getMessage());
        }
        finally{
            driver.switchTo().defaultContent();
        }
    }

    /**
     * Clicks delete button
     *
     * @author: Walter
     *
     */
    protected void clickDeletedAccButton(boolean confirmDeletion) {
        wait.until(ExpectedConditions.visibilityOf(deleteAccBtn));
        deleteAccBtn.click();
        Alert alert;

        try{
            alert = driver.switchTo().alert();

            if (confirmDeletion){
                alert.accept();
            }
            alert.dismiss();
        }
        catch(WebDriverException e){
            System.out.println("Delete Object: " + e.getMessage());
        }
        finally{
            driver.switchTo().defaultContent();
        }
    }

    /**
     * Clicks clone button
     *
     * @author: Jimmy Vargas
     * @since: 6/13/2015
     */
    protected void clickCloneButton() {
        wait.until(ExpectedConditions.visibilityOf(cloneBtn));
        cloneBtn.click();
    }

    /**
     * Returns the corresponding form
     *
     * @author: Jimmy Vargas
     * @since: 6/13/2015
     * */
    abstract protected Object clickEditBtn();

    /**
     * Returns to the Details when the confirmation is false and return to home when the confirmation is true
     *
     * @author: Jimmy Vargas
     * @since: 6/13/2015
     * */
    abstract protected Object clickDeleteBtn(boolean confirmDeletion);


}
