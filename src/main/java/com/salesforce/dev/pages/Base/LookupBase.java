package com.salesforce.dev.pages.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Marcelo.Vargas on 6/17/2015.
 */
public abstract class LookupBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(id = "lksrch")
    @CacheLookup
    WebElement searchTxt;

    @FindBy(name = "go")
    @CacheLookup
    WebElement goBtn;

    abstract protected Object clickLookup(String text);

    protected void searchText(String text) {

        Set<String> windows = driver.getWindowHandles();

        LinkedList<String> windowsArray = new LinkedList(windows);
        try {
            System.out.println("before frame");
            driver.switchTo().window(windowsArray.getLast());
            driver.switchTo().frame(driver.findElement(By.name("searchFrame")));

            searchTxt.sendKeys(text);

            goBtn.click();
            driver.switchTo().window(windowsArray.getLast());
            driver.switchTo().frame(driver.findElement(By.name("resultsFrame")));

            driver.findElement(By.linkText(text)).click();
            driver.switchTo().window(windowsArray.getFirst());
        }
        catch (WebDriverException e){
            throw new WebDriverException(e);
        }
    }
}
