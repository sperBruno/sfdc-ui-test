package com.salesforce.dev.framework;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by dante on 6/14/2016.
 */
public class CommonOperation {

    private CommonOperation(){

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
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    public static void clickWebElement(WebElement webElement) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public static void setComboBox(WebElement element, String value){
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(element));
        Select comboBox = new Select(element);
        comboBox.selectByValue(value);
    }

    public static void setCheckBox(WebElement element){
        if(!element.isSelected()) {
            element.click();
        }
    }

    public static void setComboBoxByItem(WebElement webElement, String value){
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        Select comboBox = new Select(webElement);
        comboBox.selectByVisibleText(value);
    }
}
