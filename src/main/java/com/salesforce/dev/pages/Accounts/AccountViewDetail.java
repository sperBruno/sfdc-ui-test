package com.salesforce.dev.pages.Accounts;

import java.util.concurrent.TimeUnit;

import com.salesforce.dev.pages.Base.ViewDetailBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Carlos Orellana on 9/2/2015.
 */
public class AccountViewDetail extends ViewDetailBase {
    public AccountViewDetail(WebDriver driver) {
        try {
            WAIT.withTimeout(10, TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(viewSelected));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            WAIT.withTimeout(15, TimeUnit.SECONDS);
        }
    }

    @Override
    protected AccountView clickEditLnk() {
        clickEditLink();
        return new AccountView(driver);
    }

    @Override
    public AccountViewDetail clickDeleteLnk(boolean confirmDeletion) {
        clickDeleteLink(confirmDeletion);
        return this;
    }
}