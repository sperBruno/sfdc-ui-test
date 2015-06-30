package com.salesforce.dev;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by carlos_gonzales on 29-05-15.
 */
public class TestNGSuite {

    @BeforeSuite(groups = {"BVT","Acceptance"})
    public void beforeSuite() {
        System.out.println("Starting suite");
    }

    @AfterSuite(groups = {"BVT","Acceptance"})
    public void afterSuite() {
        try {
            DriverManager.getInstance().quit();
        }
        catch(WebDriverException e){e.printStackTrace();}
        catch(RuntimeException e){e.printStackTrace();}

    }
}
