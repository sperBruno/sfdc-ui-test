package com.salesforce.dev.pages;

import com.salesforce.dev.framework.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Dante Villarroel on 6/18/2016.
 */
public abstract class AbstractBasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected Actions action;
    public AbstractBasePage() {
        driver = DriverManager.getInstance().getDriver();
        wait = DriverManager.getInstance().getWait();
        action=new Actions(driver);
        PageFactory.initElements(driver, this);
    }

}
