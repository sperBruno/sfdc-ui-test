package com.salesforce.dev.pages.campaigns;

import java.util.concurrent.TimeUnit;

import com.salesforce.dev.framework.selenium.DriverManager;
import com.salesforce.dev.pages.base.ViewDetailBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by veronica on 8/21/2015.
 */
public class CampaignViewDetail extends ViewDetailBase {

    private static final Logger LOGGER = Logger.getLogger(CampaignViewDetail.class.getName());

    public CampaignViewDetail() {
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
    protected CampaignView clickEditLnk() {
        clickEditLink();
        return new CampaignView();
    }

    @Override
    public CampaignViewDetail clickDeleteLnk(boolean confirmDeletion) {
        clickDeleteLink(confirmDeletion);
        LOGGER.info("Campaign View was deleted");
        return this;
    }


}
