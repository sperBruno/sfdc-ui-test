package com.salesforce.dev.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * This class initialize a Safari Web Driver
 *
 * @author Henrry Salinas.
 */
public class Safari implements IDriver {

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver initDriver() {
        return new SafariDriver();
    }
}
