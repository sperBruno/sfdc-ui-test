package com.salesforce.dev.framework;


import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.Login.Transporter;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.TopHeader;
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
import java.util.Date;


/**
 * Created by Marcelo.Vargas on 6/22/2015.
 */
public class TestListener implements ITestListener {
    WebDriver driver;
    String filePath =  "build\\reports\\tests\\html\\screenshots";

    @Override
    public void onTestStart(ITestResult result) {
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "On Execution Test Star");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "On Test success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("***** Error " + result.getName() + " test has failed *****");
        LoggerManager.getInstance().addErrorLog(this.getClass().getName(),
                "On Execution Test failure", null);
        String methodName = result.getName().toString().trim();
        takeScreenShot(methodName);
    }

    public void takeScreenShot(String methodName) {
        driver = DriverManager.getInstance().getDriver();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            File myFile = new File(filePath + "/" + methodName + ".png");
            FileUtils.copyFile(scrFile, myFile);
            System.out.println("***Placed screen shot in "+filePath+" ***");
            reportLogScreenshot(myFile);
        } catch (IOException e) {
            System.out.println("___ catch exception");
            e.printStackTrace();
        }
    }

    protected void reportLogScreenshot(File file) {
        System.setProperty("org.uncommons.reportng.escape-output", "false");

        Reporter.log("<p align=\"left\">Error screenshot at " + new Date()+ "</p>");
        Reporter.log("<p>&nbsp;</p>");
        Reporter.log("<a href='logs/log4j-application.log'>Open Logs</a>");
        Reporter.log("<p>&nbsp;</p>");
        Reporter.log("<p><img width=\"1024\" src=\"" + file.getAbsoluteFile()  + "\" alt=\"screenshot at " + new Date()+ "\"/></p><br />");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        LoggerManager.getInstance().addErrorLog(this.getClass().getName(),
                "Test suite Start", null);
        Transporter.login();
    }

    @Override
    public void onFinish(ITestContext context) {
        MainPage mainPage = Transporter.driverMainPage();
        TopHeader topHeader = mainPage.gotoTopHeader();
        topHeader.clickUserNameMenu();
        LoginPage loginPage = topHeader.clickLogoutOption();
        DriverManager.getInstance().close();
        DriverManager.getInstance().quit();
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "On Finish");
    }
}
