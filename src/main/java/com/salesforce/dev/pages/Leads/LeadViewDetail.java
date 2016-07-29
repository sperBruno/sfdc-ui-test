package com.salesforce.dev.pages.leads;

import java.util.concurrent.TimeUnit;

import com.salesforce.dev.framework.selenium.DriverManager;
import com.salesforce.dev.pages.base.ViewDetailBase;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Ariel Mattos on 06/09/2015.
 */
public class LeadViewDetail extends ViewDetailBase {
    public LeadViewDetail() {

        try {
            wait.withTimeout(DriverManager.getInstance().getTimeoutNormal(), TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(viewSelected));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(DriverManager.getInstance().getTimeoutNormal(), TimeUnit.SECONDS);
        }
    }

    @Override
    protected LeadView clickEditLnk() {
        clickEditLink();
        return new LeadView();
    }

    @Override
    public LeadViewDetail clickDeleteLnk(boolean confirmDeletion) {
        clickDeleteLink(confirmDeletion);
        return this;
    }
}
