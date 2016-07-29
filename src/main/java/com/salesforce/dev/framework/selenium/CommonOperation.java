package com.salesforce.dev.framework.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dante on 6/14/2016.
 */
public class CommonOperation {
    
    private static final WebDriverWait WAIT = DriverManager.getInstance().getWait();

    private static final WebDriver DRIVER =DriverManager.getInstance().getDriver();

    private CommonOperation() {
    }

    public static boolean isElementPresent(WebElement webElement) {
        try {
            webElement.getTagName();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    public static void setWebElement(WebElement webElement, String text) {
        WAIT.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(text);
    }

    public static void clickWebElement(WebElement webElement) {
        WAIT.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public static void setComboBox(WebElement element, String value) {
        WAIT.until(ExpectedConditions.visibilityOf(element));
        Select comboBox = new Select(element);
        comboBox.selectByValue(value);
    }

    public static void setCheckBox(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }

    public static void setComboBoxByItem(WebElement webElement, String value) {
        WAIT.until(ExpectedConditions.visibilityOf(webElement));
        Select comboBox = new Select(webElement);
        comboBox.selectByVisibleText(value);
    }


    public static boolean isWebElementVisible(WebElement webElement) {
        try {

            WAIT.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    public static String getTextWebElement(WebElement webElement) {
        WAIT.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();

    }

    public static void moveHorizontalWebElementScroll(WebDriver driver, WebElement webElement, int horizontal) {
        WAIT.until(ExpectedConditions.visibilityOf(webElement));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollLeft+=arguments[1];", webElement, horizontal);
    }

    public static String getFirstSelectOption(WebElement webElement) {
        WAIT.until(ExpectedConditions.visibilityOf(webElement));
        Select select = new Select(webElement);
        return  select.getFirstSelectedOption().getText();
    }

}
