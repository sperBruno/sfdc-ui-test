package com.salesforce.dev.pages.leads;

import com.salesforce.dev.framework.selenium.CommonOperation;
import com.salesforce.dev.framework.utils.Constants;
import com.salesforce.dev.pages.base.ViewBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static com.salesforce.dev.framework.selenium.CommonOperation.waitForWebElement;
import static com.salesforce.dev.framework.utils.Constants.FIFTEEN_SECONDS;
import static com.salesforce.dev.framework.utils.Constants.TEN_SECONDS;

/**
 * This class will be used to represent Lead view and its options.
 *
 * @author Ariel Mattos
 * @since 06/09/2015.
 */
public class LeadView extends ViewBase {

    private static final Logger LOGGER = Logger.getLogger(LeadView.class.getName());

    public LeadView() {
        waitForWebElement(saveBtn);
    }

    @Override
    public Object clickCancelBtn() {
        return null;
    }

    @Override
    public LeadView setViewName(String viewName) {
        setViewNameFld(viewName);
        return this;
    }

    @Override
    public LeadView setUniqueViewName(String uniqueViewName) {
        setUniqueViewNameFld(uniqueViewName);
        return this;
    }

    @Override
    public LeadView checkFilterByOwnerAll() {
        checkFilterOwnerAll();
        return this;
    }

    @Override
    public LeadView checkFilterByOwnerMy() {
        checkFilterOwnerMy();
        return this;
    }

    @Override
    public LeadView checkFilterByOwner(String filter) {
        if (filter.compareToIgnoreCase("All Unconverted leads") == 0)
            checkFilterOwnerAll();
        else
            checkFilterOwnerMy();
        return this;
    }

    @Override
    public LeadView addAdditionalFiltersByField(int numberField, String field, String operator, String value) {
        addAdditionalFilterByField(numberField, field, operator, value);
        return this;
    }

    @Override
    public LeadView addNewFieldToDisplay(String newField) {
        addNewFldToDisplay(newField);
        return this;
    }

    @Override
    public LeadView selectRestrictVisibility(String optionVisibility) {
        selectRestrictVisibilityRadio(optionVisibility);
        return this;
    }

    @Override
    public LeadViewDetail clickSaveBtn() {
        clickSaveButton();
        LOGGER.info("Basic leads View was created");
        return new LeadViewDetail();
    }
}
