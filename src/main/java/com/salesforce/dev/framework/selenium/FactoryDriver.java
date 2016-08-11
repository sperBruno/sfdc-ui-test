package com.salesforce.dev.framework.selenium;

import org.openqa.selenium.WebDriverException;

/**
 * This class handle the logic related to what kind of browser will be used in the test
 *
 * @author Henrry Salinas
 */
public final class FactoryDriver {

    private FactoryDriver() {
    }

    public static IDriver getDriver(String browser) {
        switch (Browser.valueOf(browser.toUpperCase())) {
            case CHROME:
                return new Chrome();
            case FIREFOX:
                return new Firefox();
            case SAFARI:
                return new Safari();
            case IE:
                return new InternetExplorer();
            case SAUCELABS:
                return new SauceLab();
            case BROWSERSTACK:
                return new BrowserStack();
            default:
                throw new WebDriverException("Browser not found : " + browser);
        }
    }
}
