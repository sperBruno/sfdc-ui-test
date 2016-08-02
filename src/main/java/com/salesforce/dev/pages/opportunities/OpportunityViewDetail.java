package com.salesforce.dev.pages.opportunities;

import java.util.concurrent.TimeUnit;

import com.salesforce.dev.pages.base.ViewDetailBase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.salesforce.dev.framework.utils.Constants.FIFTEEN_SECONDS;
import static com.salesforce.dev.framework.utils.Constants.TEN_SECONDS;

/**
 * Created by Carlos Orellana on 9/2/2015.
 */
public class OpportunityViewDetail extends ViewDetailBase {

    private static final Logger LOGGER = Logger.getLogger(OpportunityViewDetail.class.getName());

    public OpportunityViewDetail() {
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
    protected OpportunityView clickEditLnk() {
        clickEditLink();
        return new OpportunityView();
    }

    @Override
    public OpportunityViewDetail clickDeleteLnk() {
        clickDeleteLink();
        return this;
    }
}