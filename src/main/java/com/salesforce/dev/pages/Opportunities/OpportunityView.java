package com.salesforce.dev.pages.Opportunities;

import java.util.concurrent.TimeUnit;

import com.salesforce.dev.pages.Base.ViewBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Carlos Orellana on 9/2/2015.
 */
public class OpportunityView extends ViewBase {

    public OpportunityView(WebDriver driver) {
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
        if (filter.compareToIgnoreCase("All Opportunities") == 0)
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
        return new OpportunityViewDetail(driver);
    }
}
