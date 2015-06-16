package com.salesforce.dev.pages.Contacts;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.salesforce.dev.pages.Base.*;


/**
 * Created by Marcelo Vargas on 11/06/2015.
 */
public class ContactsHome extends TabPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ContactsHome(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public ContactForm clickNewBtn(){
        super.wait.until(ExpectedConditions.visibilityOf(newBtn));
        newBtn.click();
        return new ContactForm(this.driver);
    }
}