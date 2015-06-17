package com.salesforce.dev.pages.SearchLookup;

import com.salesforce.dev.pages.Base.LookupBase;
import com.salesforce.dev.pages.Contacts.ContactForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.dev.framework.DriverManager;

/**
 * Created by Marcelo.Vargas on 17-06-15.
 */
public class SearchLookupBase extends LookupBase {

   public SearchLookupBase(WebDriver driver) {
        super.driver = driver;
       super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public ContactForm clickLookup(String text) {
        searchText(text);
        return new ContactForm(driver);
    }

}