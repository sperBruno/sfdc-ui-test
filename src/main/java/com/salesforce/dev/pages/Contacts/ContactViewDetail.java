package com.salesforce.dev.pages.Contacts;

import java.util.concurrent.TimeUnit;

import com.salesforce.dev.pages.Base.ViewDetailBase;
import com.salesforce.dev.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by veronica on 8/21/2015.
 */
public class ContactViewDetail extends ViewDetailBase {
    @FindBy(id = "con2_ileinner")
    WebElement contactViewName;
    public ContactViewDetail(WebDriver driver) {
        try {
            wait.withTimeout(10, TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(viewSelected));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(15, TimeUnit.SECONDS);
        }
    }
    @Override
    protected ContactView clickEditLnk() {
        clickEditLink();
        return new ContactView(driver);
    }

    @Override
    public ContactViewDetail clickDeleteLnk(boolean confirmDeletion) {
        clickDeleteLink(confirmDeletion);
        return this;
    }
    public MainPage gotoMainPage(){
        return new MainPage();
    }
    public Boolean validateContactName(String value) {
        return contactViewName.getText().equals(value);
    }

}
