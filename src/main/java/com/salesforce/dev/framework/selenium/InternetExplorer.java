package com.salesforce.dev.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by HENRRY on 01/08/2016.
 */
public class InternetExplorer implements IDriver {

    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.ie.driver";

    private static final String DRIVER_PATH = "drivers/IEDriverServer.exe";

    @Override
    public WebDriver initDriver() {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, DRIVER_PATH);
        return new InternetExplorerDriver();
    }
}
