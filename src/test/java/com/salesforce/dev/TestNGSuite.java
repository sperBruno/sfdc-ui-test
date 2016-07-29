package com.salesforce.dev;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.salesforce.dev.framework.selenium.DriverManager.getInstance;

/**
 * Created by carlos_gonzales on 29-05-15.
 */
public class TestNGSuite {

    private static final Logger LOGGER = Logger.getLogger(TestNGSuite.class.getName());

    @BeforeSuite(groups = {"BVT", "Acceptance"})
    public void beforeSuite() {
        final String startingSuite = "Starting suite";
        LOGGER.info(startingSuite);
    }

    @AfterSuite(groups = {"BVT", "Acceptance"})
    public void afterSuite() {
        final String driverNotFound = "Driver not found";
        final String executionError = "Execution error";
        try {
            getInstance().quit();
        } catch (WebDriverException e) {
            LOGGER.error(driverNotFound, e);
        } catch (RuntimeException e) {
            LOGGER.error(executionError, e);
        }
    }
}
