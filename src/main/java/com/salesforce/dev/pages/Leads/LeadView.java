package com.salesforce.dev.pages.leads;

import java.util.concurrent.TimeUnit;

import com.salesforce.dev.pages.base.ViewBase;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Ariel Mattos on 06/09/2015.
 */
public class LeadView extends ViewBase {
    public LeadView() {

        try {
            wait.withTimeout(10, TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(saveBtn));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(15, TimeUnit.SECONDS);
        }
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
        return new LeadViewDetail();
    }
}
