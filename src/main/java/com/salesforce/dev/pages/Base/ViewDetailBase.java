package com.salesforce.dev.pages.Base;

import com.salesforce.dev.framework.LoggerManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 8/20/2015.
 */
public abstract class ViewDetailBase extends AbstractWebDriverEventListener {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(linkText = "Edit")
    protected WebElement editLnk;

    @FindBy(linkText = "Delete")
    protected WebElement deleteLnk;

    @FindBy(linkText = "Create New View")
    protected WebElement newViewBtn;

    @FindBy(name = "fcf")
    protected WebElement viewSelected;

    protected void clickEditLink() {
        try {
            wait.until(ExpectedConditions.visibilityOf(editLnk));
            editLnk.click();
            LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                    "Edit link was clicked");
        }
        catch(WebDriverException e){
            LoggerManager.getInstance().addFatalLog(this.getClass().getName(),
                    "The Edit link couldn't be found",
                    e.fillInStackTrace());
        }
    }

    protected void clickDeleteLink(boolean confirmDeletion) {
        wait.until(ExpectedConditions.visibilityOf(deleteLnk));
        deleteLnk.click();
        Alert alert;

        try{
            alert = driver.switchTo().alert();

            if (confirmDeletion){
                alert.accept();
            }
            alert.dismiss();
            LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                    "Delete link was clicked");
        }
        catch(WebDriverException e){
            LoggerManager.getInstance().addFatalLog(this.getClass().getName(),
                    "The Delete link couldn't be found",
                    e.fillInStackTrace());
        }
    }

    protected abstract Object clickEditLnk();

    /**
     * Returns next view
    *
     */
    protected abstract Object clickDeleteLnk(boolean confirmDeletion);



    public String getViewSelected(){
        wait.until(ExpectedConditions.visibilityOf(viewSelected));
        Select select = new Select(viewSelected);
        return select.getFirstSelectedOption().getText();
    }
    public boolean validateNameView(String nameView){
        wait.until(ExpectedConditions.visibilityOf(viewSelected));
        Select select = new Select(viewSelected);

        String nameV = select.getFirstSelectedOption().getText();
        return nameV.equals(nameView);

    }

    public boolean validateFieldDisplayed(String field){
        By fieldDisplayed = By.xpath("//div[@title='" + field+"']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldDisplayed));
        return driver.findElement(fieldDisplayed).isDisplayed();

    }
}
