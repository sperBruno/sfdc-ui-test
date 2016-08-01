package com.salesforce.dev.framework.selenium;

import org.openqa.selenium.WebDriver;

/**
 * This interface define the methods related to initialize the Selenium driver
 *
 * @author Henrry Salinas.
 */
public interface IDriver {

    /**
     * This method initialize the Selenium web driver through the classes that implements this method
     *
     * @return Selenium Web Driver
     */
    WebDriver initDriver();
}
