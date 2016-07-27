package com.salesforce.dev.pages.Opportunities;

import java.util.concurrent.TimeUnit;

import com.salesforce.dev.pages.Base.ViewDetailBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Carlos Orellana on 9/2/2015.
 */
public class OpportunityViewDetail extends ViewDetailBase {
    public OpportunityViewDetail(WebDriver driver) {

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
    protected OpportunityView clickEditLnk() {
        clickEditLink();
        return new OpportunityView(driver);
    }

    @Override
    public OpportunityViewDetail clickDeleteLnk(boolean confirmDeletion) {
        clickDeleteLink(confirmDeletion);
        return this;
    }
}