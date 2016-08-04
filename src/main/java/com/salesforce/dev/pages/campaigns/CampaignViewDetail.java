package com.salesforce.dev.pages.campaigns;

import com.salesforce.dev.framework.selenium.CommonOperation;
import com.salesforce.dev.pages.base.ViewDetailBase;

import static com.salesforce.dev.framework.selenium.CommonOperation.waitForWebElement;

/**
 * This class will be used to represent Campaing view details and its options.
 *
 * @author Veronica
 * @since 8/21/2015.
 */
public class CampaignViewDetail extends ViewDetailBase {

    public CampaignViewDetail() {
        waitForWebElement(viewSelected);
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
