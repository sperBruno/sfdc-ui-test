package com.salesforce.dev.pages.accounts;


import java.util.List;
import java.util.concurrent.TimeUnit;


import com.salesforce.dev.framework.dto.FieldToDisplayView;
import com.salesforce.dev.framework.dto.FilterView;
import com.salesforce.dev.pages.base.ViewBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Carlos Orellana on 9/2/2015.
 */
public class AccountView extends ViewBase {
    public AccountView(WebDriver driver) {

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
    public AccountView setViewName(String viewName) {
        setViewNameFld(viewName);
        return this;
    }

    @Override
    public AccountView setUniqueViewName(String uniqueViewName) {
        setUniqueViewNameFld(uniqueViewName);
        return this;
    }

    @Override
    protected AccountView checkFilterByOwnerAll() {
        checkFilterOwnerAll();
        return this;
    }

    @Override
    protected AccountView checkFilterByOwnerMy() {
        checkFilterOwnerMy();
        return this;
    }

    @Override
    public AccountView checkFilterByOwner(String filter) {
        if (filter.compareToIgnoreCase("All Accounts") == 0){
            checkFilterOwnerAll();
        }else{
            checkFilterOwnerMy();
        }
        return this;
    }

    @Override
    public AccountView addAdditionalFiltersByField(int numberField, String field, String operator, String value) {
        addAdditionalFilterByField(numberField, field, operator, value);
        return this;
    }

    @Override
    public AccountView addNewFieldToDisplay(String newField) {
        addNewFldToDisplay(newField);
        return this;
    }

    @Override
    public AccountView selectRestrictVisibility(String optionVisibility) {
        selectRestrictVisibilityRadio(optionVisibility);
        return this;
    }

    @Override
    public AccountViewDetail clickSaveBtn() {
        clickSaveButton();
        return new AccountViewDetail(driver);

    }

    public void addFilter(List<FilterView> additionalField) {
        int count = 1;
        for (FilterView addFilter : additionalField) {
            addAdditionalFiltersByField(count, addFilter.getFieldFilter(),
                    addFilter.getOperatorFilter(), addFilter.getValueFilter());
            count++;
        }
    }

    public void addAccountView(List<FieldToDisplayView> fieldToDisplayViews) {
        for (FieldToDisplayView fields : fieldToDisplayViews) {
            addNewFieldToDisplay(fields.getFieldToDisplay());
        }
    }
}
