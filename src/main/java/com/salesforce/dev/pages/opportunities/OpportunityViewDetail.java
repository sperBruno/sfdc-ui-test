package com.salesforce.dev.pages.opportunities;

import java.util.concurrent.TimeUnit;

import com.salesforce.dev.framework.selenium.CommonOperation;
import com.salesforce.dev.pages.base.ViewDetailBase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.salesforce.dev.framework.selenium.CommonOperation.waitForWebElement;
import static com.salesforce.dev.framework.utils.Constants.FIFTEEN_SECONDS;
import static com.salesforce.dev.framework.utils.Constants.TEN_SECONDS;

/**
 * This class will be used to represent Opportunities view details.
 *
 * @author Carlos Orellana
 * @since 9/2/2015.
 */
public class OpportunityViewDetail extends ViewDetailBase {

    public OpportunityViewDetail() {
        waitForWebElement(viewSelected);
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