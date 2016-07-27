package com.salesforce.dev.pages.Contacts;

import com.salesforce.dev.pages.Base.HomeBase;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Created by Marcelo Vargas on 11/06/2015.
 */
public class ContactsHome extends HomeBase {
    @FindBy(xpath = "//h1[contains(.,'Contacts:')]")
    WebElement contactSection;

    public ContactForm clickNewBtn(){
        clickNewButton();
        return new ContactForm();
    }

    @Override
    public ContactView clickNewViewLnk() {
        clickNewViewLink();
        return new ContactView(this.driver);

    }

    @Override
    public ContactView clickEditViewLnk(String value) {
        editViewLnk(value);
        return new ContactView(this.driver);
    }

    public ContactDetail selectRecentItem(String opportunity){
        super.clickRecentItem(opportunity);
        return new ContactDetail();
    }
    public boolean IsUserInContactsTab(){
        try{
            WAIT.until(ExpectedConditions.visibilityOf(contactSection));
            return true;
        }
        catch (WebDriverException e){
            return false;
        }
    }

    @Override
    protected Object selectRecentViewItem(String value) {
        return null;
    }
}