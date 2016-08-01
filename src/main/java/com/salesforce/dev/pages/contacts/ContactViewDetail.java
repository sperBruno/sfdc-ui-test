package com.salesforce.dev.pages.contacts;

import java.util.concurrent.TimeUnit;

import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.base.ViewDetailBase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.salesforce.dev.framework.utils.Constants.FIFTEEN_SECONDS;
import static com.salesforce.dev.framework.utils.Constants.TEN_SECONDS;

/**
 * @author veronica on 8/21/2015.
 */
public class ContactViewDetail extends ViewDetailBase {

    private static final Logger LOGGER = Logger.getLogger(ContactViewDetail.class.getName());

    @FindBy(id = "con2_ileinner")
    WebElement contactViewName;

    public ContactViewDetail() {
        try {
            wait.withTimeout(TEN_SECONDS, TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(viewSelected));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(FIFTEEN_SECONDS, TimeUnit.SECONDS);
        }
    }

    @Override
    protected ContactView clickEditLnk() {
        clickEditLink();
        return new ContactView();
    }

    @Override
    public ContactViewDetail clickDeleteLnk() {
        clickDeleteLink();
       return this;
    }

    public MainPage gotoMainPage() {
        return new MainPage();
    }

    public Boolean validateContactName(String value) {
        return contactViewName.getText().equals(value);
    }

}
