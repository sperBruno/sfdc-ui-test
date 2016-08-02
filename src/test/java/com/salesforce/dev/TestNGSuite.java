package com.salesforce.dev;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.salesforce.dev.framework.selenium.DriverManager.getInstance;

/**
 * This will be used to do any validation before the suit starts or after the suit ends.
 *
 * @author Carlos Gonzales on 29-05-15.
 * @author Bruno Barrios
 */
public class TestNGSuite {

    @BeforeSuite(groups = {"Acceptance"})
    public void beforeSuite() {
    }

    @AfterSuite(groups = {"Acceptance"})
    public void afterSuite() {
             getInstance().quit();
    }
}
