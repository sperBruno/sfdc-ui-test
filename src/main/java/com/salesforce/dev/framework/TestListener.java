package com.salesforce.dev.framework;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import javax.xml.bind.SchemaOutputResolver;
import java.io.File;
import java.io.IOException;



/**
 * Created by Marcelo.Vargas on 6/22/2015.
 */
public class TestListener implements ITestListener {
    WebDriver driver;
    String filePath = "src\\test\\results";

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("On Execution Start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("On Test Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("***** Error " + result.getName() + " test has failed *****");
        String methodName = result.getName().toString().trim();
        takeScreenShot(methodName);
    }

    public void takeScreenShot(String methodName) {
        driver = DriverManager.getInstance().getDriver();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(filePath + "\\" + methodName + ".png"));
            System.out.println("***Placed screen shot in "+filePath+" ***");
        } catch (IOException e) {
            System.out.println("___ catch exception");
            e.printStackTrace();
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
