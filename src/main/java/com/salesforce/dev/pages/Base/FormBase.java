package com.salesforce.dev.pages.Base;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

/**
 * Created by Walter on 13/06/2015.
 */
public abstract class FormBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name = "save")
    protected WebElement saveBtn;

    @FindBy(name = "save_new")
    protected WebElement saveNewBtn;

    @FindBy(name = "cancel")
    protected WebElement cancelBtn;

    /**
     * This method initialize the driver and wait when creating the
     * page with a builder specifically
     *
     * @author: Jimmy Vargas
     * */
    protected void initializer(){
        if(this.driver == null){
            this.driver = DriverManager.getInstance().getDriver();
        }
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(this.driver,this);
    }
    /**
     * Method clicks the New button in the home page for each different category
     *
     * @author: Walter
     */
    abstract protected Object clickSaveBtn();
    abstract protected Object clickSaveNewBtn();
    abstract protected Object clickCancelBtn();

    /**
     * Methods that encapsulates the the operations waiting for the element and the action
     *
     * @author: Walter
     */
    protected void clickSaveButton() {
        this.wait.until(ExpectedConditions.visibilityOf(saveBtn));
        saveBtn.click();

    }

    protected void clickSaveNewButton() {
        this.wait.until(ExpectedConditions.visibilityOf(saveNewBtn));
        saveNewBtn.click();

    }

    protected void clickCancelButton() {
        this.wait.until(ExpectedConditions.visibilityOf(cancelBtn));
        cancelBtn.click();

    }
}
