package com.salesforce.dev.pages.opportunities;

import com.salesforce.dev.pages.base.ViewDetailBase;

import static com.salesforce.dev.framework.selenium.CommonOperation.waitForWebElement;

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