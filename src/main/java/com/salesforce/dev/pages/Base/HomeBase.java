package com.salesforce.dev.pages.Base;

import com.salesforce.dev.framework.LoggerManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jimmy Vargas on 6/11/2015.
 */
public abstract class HomeBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(id = "fcf")
    protected WebElement viewCombobox;

    @FindBy(name = "new")
    protected WebElement newBtn;

    @FindBy(linkText = "Create New View")
    protected WebElement newViewLnk;

    @FindBy(linkText = "Edit")
    protected WebElement editViewLnk;


    /**
     * Method clicks the New button in the home page for each different category
     *
     * @author: Jimmy
     */
    protected abstract Object clickNewBtn();

    /**
     * Method clicks the New Link in the home page for each different category
     *
     * @author: veronica
     */
    protected abstract Object clickNewViewLnk();

    /**
     * Method clicks the NEdit view in the home page for each different category
     *
     * @author: veronica
     */
    protected abstract Object clickEditViewLnk(String value);

    /**
     * Method that encapsulates the the operations waiting for the elemeent and the action
     *
     * @author: Jimmy
     */
    protected void clickNewButton() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(newBtn));
            newBtn.click();
            LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                    "New button was clicked");
        }
        catch(WebDriverException e){
            LoggerManager.getInstance().addFatalLog(this.getClass().getName(),
                    "The New button couldn't be found",
                    e.fillInStackTrace());
        }
    }

    /**
     * Method that encapsulates the the operations waiting for the elemeent and the action
     *
     * @author: veronica
     */
    protected void clickNewViewLink() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(newViewLnk));
            newViewLnk.click();
            LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                    "New View Link was clicked");
        }
        catch(WebDriverException e){
            LoggerManager.getInstance().addFatalLog(this.getClass().getName(),
                    "The New View Link couldn't be found",
                    e.fillInStackTrace());
        }
    }

    protected abstract Object selectRecentItem(String value);

    protected void clickRecentItem(String value){
        try {
            WebElement recentItem = driver.findElement(
                    By.xpath("//div[@class='hotListElement']/descendant::a[contains(.,'"+value+"')]"));
            recentItem.click();
            LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                    "Recent Item was selected");
        }
        catch(WebDriverException e){
            LoggerManager.getInstance().addFatalLog(this.getClass().getName(),
                    "The Recent Item button couldn't be found",
                    e.fillInStackTrace());
        }
    }

    protected void selectRecentView(String value){
        wait.until(ExpectedConditions.visibilityOf(viewCombobox));
        viewCombobox.sendKeys(value);

    }

    protected void editViewLnk(String value){
        selectRecentView(value);
        editViewLnk.click();
    }
}