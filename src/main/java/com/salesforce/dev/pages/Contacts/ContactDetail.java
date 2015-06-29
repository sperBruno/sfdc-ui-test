package com.salesforce.dev.pages.Contacts;

import com.salesforce.dev.pages.Base.DetailsBase;
import com.salesforce.dev.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.salesforce.dev.framework.DriverManager;
/**
 * Created by Marcelo.Vargas on 6/12/2015.
 */
public class ContactDetail extends DetailsBase {

    @FindBy(id = "con2_ileinner")
    WebElement contactName;

    public ContactDetail(WebDriver driver) {
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public ContactForm clickEditBtn(){
        clickEditButton();
        return new ContactForm(driver);
    }

    public ContactsHome clickDeleteBtn(boolean confirmDeletion){
        clickDeleteButton(confirmDeletion);
        return new ContactsHome(driver);
    }

    public MainPage gotoMainPage(){
        return new MainPage(driver);
    }

    public Boolean validateContactName(String value) {
        return contactName.getText().equals(value);
    }
}
