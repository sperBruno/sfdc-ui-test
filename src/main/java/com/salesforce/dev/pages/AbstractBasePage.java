package com.salesforce.dev.pages;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Dante Villarroel on 6/18/2016.
 */
public abstract class AbstractBasePage {

    protected static WebDriverWait WAIT;
    protected WebDriver driver;

    public AbstractBasePage() {
        driver = DriverManager.getInstance().getDriver();
        WAIT = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

}
