package com.salesforce.dev.pages.campaigns;

import java.util.concurrent.TimeUnit;

import com.salesforce.dev.pages.base.ViewDetailBase;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.salesforce.dev.framework.selenium.DriverManager.TIMEOUT_NORMAL;

/**
 * Created by veronica on 8/21/2015.
 */
public class CampaignViewDetail extends ViewDetailBase {
    public CampaignViewDetail() {
        try {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(viewSelected));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }
    @Override
    protected CampaignView clickEditLnk() {
        clickEditLink();
        return new CampaignView();
    }

    @Override
    public CampaignViewDetail clickDeleteLnk() {
        clickDeleteLink();
        return this;
    }


}
