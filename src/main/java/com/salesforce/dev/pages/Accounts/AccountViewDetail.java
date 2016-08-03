package com.salesforce.dev.pages.accounts;

import com.salesforce.dev.pages.base.ViewDetailBase;
import org.openqa.selenium.WebDriver;

import static com.salesforce.dev.framework.selenium.CommonOperation.waitForWebElement;

/**
 * This class will be used to represent Account view details and its options.
 *
 * @author Carlos Orellana.
 * @since 9/2/2015.
 */
public class AccountViewDetail extends ViewDetailBase {
    public AccountViewDetail(WebDriver driver) {
        waitForWebElement(viewSelected);
    }

    @Override
    protected AccountView clickEditLnk() {
        clickEditLink();
        return new AccountView(driver);
    }

    @Override
    public ViewDetailBase clickDeleteLnk() {
        clickDeleteLink();
        return this;
    }
}