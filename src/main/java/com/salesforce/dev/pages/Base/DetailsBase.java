package com.salesforce.dev.pages.Base;

import com.salesforce.dev.framework.LoggerManager;
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
        try {
            wait.until(ExpectedConditions.visibilityOf(editBtn));
            editBtn.click();
            LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                    "Edit button was clicked");
        }
        catch(WebDriverException e){
            LoggerManager.getInstance().addFatalLog(this.getClass().getName(),
                    "The SaveNew button couldn't be found",
                    e.fillInStackTrace());
        }
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
            LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                    "Delete Button was clicked");
        }
        catch(WebDriverException e){
            LoggerManager.getInstance().addFatalLog(this.getClass().getName(),
                    "The Delete button couldn't be found",
                    e.fillInStackTrace());
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
            LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                    "Delete Button was clicked");
        }
        catch(WebDriverException e){
            LoggerManager.getInstance().addFatalLog(this.getClass().getName(),
                    "The Delete button couldn't be found",
                    e.fillInStackTrace());
        }
    }

    /**
     * Clicks clone button
     *
     * @author: Jimmy Vargas
     * @since: 6/13/2015
     */
    protected void clickCloneButton() {
        try{
            wait.until(ExpectedConditions.visibilityOf(cloneBtn));
            cloneBtn.click();
            LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                    "Clone Button was clicked");
        }
        catch(WebDriverException e){
            LoggerManager.getInstance().addFatalLog(this.getClass().getName(),
                    "The Clone button couldn't be found",
                    e.fillInStackTrace());
        }
    }

    /**
     * Returns the corresponding form
     *
     * @author: Jimmy Vargas
     * @since: 6/13/2015
     * */
    protected abstract Object clickEditBtn();

    /**
     * Returns to the Details when the confirmation is false and return to home when the confirmation is true
     *
     * @author: Jimmy Vargas
     * @since: 6/13/2015
     * */
    protected abstract Object clickDeleteBtn(boolean confirmDeletion);


}
