package com.salesforce.dev.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * This class initialize a Safary  Web Driver
 *
 * @author Henrry Salinas.
 */
public class Safary implements IDriver{

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver initDriver() {
        return new SafariDriver();
    }
}
