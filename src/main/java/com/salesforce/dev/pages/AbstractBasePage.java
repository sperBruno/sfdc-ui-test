package com.salesforce.dev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.salesforce.dev.framework.DriverManager;

/**
 * Created by Dante Villarroel on 6/18/2016.
 */
public abstract class AbstractBasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    public AbstractBasePage() {
        driver = DriverManager.getInstance().getDriver();
        wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

}
