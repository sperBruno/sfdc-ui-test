package com.salesforce.dev.pages.Contacts;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.salesforce.dev.pages.Base.HomeBase;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Created by Marcelo Vargas on 11/06/2015.
 */
public class ContactsHome extends HomeBase {
    @FindBy(xpath = "//h1[contains(.,'Contacts:')]")
    WebElement contactSection;

    public ContactsHome(WebDriver driver) {
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public ContactForm clickNewBtn(){
        clickNewButton();
        return new ContactForm(driver);
    }

    @Override
    protected Object clickNewViewLnk() {
        return null;
    }

    @Override
    protected Object clickEditViewLnk(String value) {
        return null;
    }

    public ContactDetail selectRecentItem(String opportunity){
        super.clickRecentItem(opportunity);
        return new ContactDetail(this.driver);
    }

    @Override
    protected Object selectRecentViewItem(String value) {
        return null;
    }

    public boolean IsUserInContactsTab(){
        try{

            wait.until(ExpectedConditions.visibilityOf(contactSection));
            return true;
        }
        catch (WebDriverException e){
            return false;
        }
    }
}