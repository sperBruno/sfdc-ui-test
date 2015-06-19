package com.salesforce.dev.pages.Contacts;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.salesforce.dev.pages.Base.TabPage;


/**
 * Created by Marcelo Vargas on 11/06/2015.
 */
public class ContactsHome extends TabPage {

    public ContactsHome(WebDriver driver) {
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public ContactForm clickNewBtn(){
        clickNewButton();
        return new ContactForm(driver);
    }

    public ContactDetail selectRecentItem(String opportunity){
        super.clickRecentItem(opportunity);
        return new ContactDetail(this.driver);
    }
}