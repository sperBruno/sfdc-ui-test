package com.salesforce.dev.framework.selenium;


import java.util.concurrent.TimeUnit;

import com.salesforce.dev.framework.utils.Environment;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.salesforce.dev.framework.utils.Constants.SALESFORCE_URL;

/**
 * @author Jimmy Vargas
 * @author Henrry Salinas
 * @since 8/1/2016
 */
public class DriverManager {

    private static final Logger LOGGER = Logger.getLogger(DriverManager.class.getSimpleName());

    private static final String SRC_MAIN_RESOURCES_LOG4J_PROPERTIES = "src/main/resources/log4j.properties";

    private WebDriver driver;

    private WebDriverWait wait;

    private static DriverManager instance;

    private static final int TIMEOUT_NORMAL = 30;

    private int timeoutNormal = TIMEOUT_NORMAL;

    private DriverManager() {
        PropertyConfigurator.configure(SRC_MAIN_RESOURCES_LOG4J_PROPERTIES);
        this.initializer();
    }

    private void initializer() {
        driver = FactoryDriver.getDriver(Environment.getInstance().getBrowser()).initDriver();
        driver.manage().timeouts().implicitlyWait(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        driver.get(SALESFORCE_URL);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, TIMEOUT_NORMAL);
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriverWait getWait() {
        return this.wait;
    }

    public int getTimeoutNormal() {
        return timeoutNormal;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void quit() {
        try {
            driver.quit();
        } catch (WebDriverException e) {
            LOGGER.error("Quit request can't be performed", e);
        }
    }

    public void close() {
        try {
            driver.close();
        } catch (WebDriverException e) {
            LOGGER.error("Close request can't be performed", e);
        }
    }
}
