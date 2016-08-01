package com.salesforce.dev.pages.contacts;

import com.salesforce.dev.pages.base.DetailsBase;
import com.salesforce.dev.pages.MainPage;
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

    public ContactsHome clickDeleteBtn(boolean confirmDeletion){
        clickDeleteButton(confirmDeletion);
        LOGGER.info("Contact was deleted");
        return new ContactsHome();
    }

    public MainPage gotoMainPage(){
        return new MainPage();
    }

    public Boolean validateContactName(String value) {
        return contactName.getText().equals(value);
    }
}
