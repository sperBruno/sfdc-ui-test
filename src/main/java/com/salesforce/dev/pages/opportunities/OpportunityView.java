package com.salesforce.dev.pages.opportunities;

import com.salesforce.dev.framework.selenium.CommonOperation;
import com.salesforce.dev.pages.base.ViewBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static com.salesforce.dev.framework.selenium.CommonOperation.waitForWebElement;
import static com.salesforce.dev.framework.utils.Constants.FIFTEEN_SECONDS;
import static com.salesforce.dev.framework.utils.Constants.TEN_SECONDS;

/**
 * This class represents opportunity view.
 *
 * @author Carlos Orellana.
 * @since 9/2/2015.
 */
public class OpportunityView extends ViewBase {

    private static final Logger LOGGER = Logger.getLogger(OpportunityView.class.getName());

    public OpportunityView() {
        waitForWebElement(saveBtn);
    }

    @Override
    public Object clickCancelBtn() {
        return null;
    }

    @Override
    public OpportunityView setViewName(String viewName) {
        setViewNameFld(viewName);
        return this;
    }

    @Override
    public OpportunityView setUniqueViewName(String uniqueViewName) {
        setUniqueViewNameFld(uniqueViewName);
        return this;
    }

    @Override
    public OpportunityView checkFilterByOwnerAll() {
        checkFilterOwnerAll();
        return this;
    }

    @Override
    public OpportunityView checkFilterByOwnerMy() {
        checkFilterOwnerMy();
        return this;
    }

    @Override
    public OpportunityView checkFilterByOwner(String filter) {
        if (filter.compareToIgnoreCase("All opportunities") == 0)
            checkFilterOwnerAll();
        else
            checkFilterOwnerMy();
        return this;
    }

    @Override
    public OpportunityView addAdditionalFiltersByField(int numberField, String field, String operator, String value) {
        addAdditionalFilterByField(numberField, field, operator, value);
        return this;
    }

    @Override
    public OpportunityView addNewFieldToDisplay(String newField) {
        addNewFldToDisplay(newField);
        return this;
    }

    @Override
    public OpportunityView selectRestrictVisibility(String optionVisibility) {
        selectRestrictVisibilityRadio(optionVisibility);
        return this;
    }

    @Override
    public OpportunityViewDetail clickSaveBtn() {
        clickSaveButton();
        LOGGER.info("Opportunity was created");
        return new OpportunityViewDetail();
    }
}
