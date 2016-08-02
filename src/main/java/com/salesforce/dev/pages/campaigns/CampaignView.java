package com.salesforce.dev.pages.campaigns;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.salesforce.dev.pages.base.ViewBase;
import com.salesforce.dev.pages.base.ViewDetailBase;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.salesforce.dev.framework.selenium.DriverManager.TIMEOUT_NORMAL;

/**
 * Created by veronica on 8/20/2015.
 *
 */
public class CampaignView extends ViewBase {

    private static final Logger LOGGER = Logger.getLogger(CampaignView.class.getName());
    public CampaignView() {

        try {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(saveBtn));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }
    @Override
    public Object clickCancelBtn() {
        return null;
    }

    @Override
    public CampaignView setViewName(String viewName) {
        setViewNameFld(viewName);
        return this;
    }

    @Override
    public CampaignView setUniqueViewName(String uniqueViewName) {
        setUniqueViewNameFld(uniqueViewName);
        return this;
    }

    @Override
   public CampaignView checkFilterByOwnerAll() {
        checkFilterOwnerAll();
        return this;
    }

    @Override
    public CampaignView checkFilterByOwnerMy() {
        checkFilterOwnerMy();
        return this;
    }

    @Override
    public CampaignView checkFilterByOwner(String filter) {
        if(filter.compareToIgnoreCase("All campaigns") == 0)
            checkFilterOwnerAll();
        else
            checkFilterOwnerMy();
        return this;
    }

    @Override
    public CampaignView addAdditionalFiltersByField(int numberField, String field, String operator, String value) {
        addAdditionalFilterByField(numberField, field, operator, value);
        return this;
    }

    @Override
    public CampaignView addNewFieldToDisplay(String newField) {
        addNewFldToDisplay(newField);
        return this;
    }

    @Override
    public CampaignView selectRestrictVisibility(String optionVisibility) {
        selectRestrictVisibilityRadio(optionVisibility);
        return this;
    }

    @Override
    public ViewDetailBase clickSaveBtn() {
        clickSaveButton();
        return new CampaignViewDetail();
    }
}
