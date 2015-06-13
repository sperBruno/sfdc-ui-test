package com.salesforce.dev.pages.Contacts;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Marcelo Vargas on 11/06/2015.
 */
public class ContactsHome {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "new")
    @CacheLookup
    private WebElement newContactBtn;

    public ContactsHome(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, this);
    }

    public ContactForm clickNewContactBtn(){
        newContactBtn.click();
        return new ContactForm(driver);
    }
}
