package com.salesforce.dev.pages.contacts;

import com.salesforce.dev.framework.selenium.CommonOperation;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.base.ViewDetailBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static com.salesforce.dev.framework.utils.Constants.FIFTEEN_SECONDS;
import static com.salesforce.dev.framework.utils.Constants.TEN_SECONDS;

/**
 * This class is used to represent Contact view details and its options.
 *
 * @author Veronica.
 * @since 8/21/2015.
 */
public class ContactViewDetail extends ViewDetailBase {

    @FindBy(id = "con2_ileinner")
    private WebElement contactViewName;

    public ContactViewDetail() {
        CommonOperation.waitForWebElement(viewSelected);
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
