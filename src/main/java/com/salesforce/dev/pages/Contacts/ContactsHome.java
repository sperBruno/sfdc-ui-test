package com.salesforce.dev.pages.contacts;

import com.salesforce.dev.framework.selenium.CommonOperation;
import com.salesforce.dev.pages.base.HomeBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by Marcelo Vargas on 11/06/2015.
 */
public class ContactsHome extends HomeBase {
    @FindBy(xpath = "//h1[contains(.,'contacts:')]")
    WebElement contactSection;

    public ContactForm clickNewBtn() {
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

    public ContactDetail selectRecentItem(String opportunity) {
        super.clickRecentItem(opportunity);
        return new ContactDetail();
    }

    public boolean IsUserInContactsTab() {
        return CommonOperation.isWebElementVisible(contactSection);
    }

    @Override
    protected Object selectRecentViewItem(String value) {
        return null;
    }
}