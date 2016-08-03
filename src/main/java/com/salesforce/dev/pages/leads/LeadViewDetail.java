package com.salesforce.dev.pages.leads;

import java.util.concurrent.TimeUnit;

import com.salesforce.dev.pages.base.ViewDetailBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.salesforce.dev.framework.selenium.CommonOperation.waitForWebElement;
import static com.salesforce.dev.framework.selenium.DriverManager.TIMEOUT_NORMAL;

/**
 * @author Ariel Mattos on 06/09/2015.
 */
public class LeadViewDetail extends ViewDetailBase {

    private static final Logger LOGGER = Logger.getLogger(LeadViewDetail.class.getName());

    public LeadViewDetail() {
        waitForWebElement(viewSelected);
    }


    @Override
    protected LeadView clickEditLnk() {
        clickEditLink();
        return new LeadView();
    }

    @Override
    public LeadViewDetail clickDeleteLnk() {
        clickDeleteLink();
        LOGGER.info("Lead View was deleted");
        return this;
    }
}
