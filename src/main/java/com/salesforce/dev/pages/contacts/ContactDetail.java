package com.salesforce.dev.pages.contacts;

import java.util.Map;

import com.salesforce.dev.pages.base.DetailsBase;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.base.HomeBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Created by Marcelo.Vargas on 6/12/2015.
 */
public class ContactDetail extends DetailsBase {

    private static final Logger LOGGER = Logger.getLogger(ContactDetail.class.getName());

    @FindBy(id = "con2_ileinner")
    private WebElement contactName;

    public ContactForm clickEditBtn(){
        clickEditButton();
        return new ContactForm();
    }

    @Override
    public HomeBase clickDeleteButton() {
        clickDeletedButton();
        return new ContactsHome();
    }

    @Override
    public Map<Enum, Object> getAssertionMap() {
        return null;
    }

    public MainPage gotoMainPage(){
        return new MainPage();
    }

    public Boolean validateContactName(String value) {
        return contactName.getText().equals(value);
    }
}
