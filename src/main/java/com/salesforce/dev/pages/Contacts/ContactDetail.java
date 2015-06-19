package com.salesforce.dev.pages.Contacts;

import com.salesforce.dev.pages.Base.DetailsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.salesforce.dev.framework.DriverManager;
/**
 * Created by Marcelo.Vargas on 6/12/2015.
 */
public class ContactDetail extends DetailsBase {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "con2_ileinner")
    WebElement contactNameReg;

    public ContactDetail(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, this);
    }

    public Object clickEditBtn(){
        super.clickEditButton();
        return new ContactForm(driver);
    }

    public Object clickDeleteBtn(boolean confirmDeletion){
        super.clickDeleteButton(confirmDeletion);
        return new ContactsHome(driver);
    }

    public boolean VerifyContact(String nameValue) {
        String NameContactForm = contactNameReg.getText();

        if(NameContactForm.equals(nameValue)){
            return true;
        }
        return false;
    }
}
