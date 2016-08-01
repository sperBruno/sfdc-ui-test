package com.salesforce.dev.pages.opportunities;

import java.util.concurrent.TimeUnit;

import com.salesforce.dev.pages.base.ViewDetailBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Carlos Orellana on 9/2/2015.
 */
public class OpportunityViewDetail extends ViewDetailBase {
    public OpportunityViewDetail(WebDriver driver) {

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
    protected OpportunityView clickEditLnk() {
        clickEditLink();
        return new OpportunityView(driver);
    }

    @Override
    public OpportunityViewDetail clickDeleteLnk() {
        clickDeleteLink();
        return this;
    }
}