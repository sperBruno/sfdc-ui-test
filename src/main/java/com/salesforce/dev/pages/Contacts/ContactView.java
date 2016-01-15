package com.salesforce.dev.pages.Contacts;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.framework.RamdonGenerator;
import com.salesforce.dev.pages.Base.ViewBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;

/**
 * Created by veronica on 8/20/2015.
 */
public class ContactView extends ViewBase {

    @FindBy(id = "fentityvalue2")
    protected WebElement filterByCampaign;

    public ContactView(WebDriver driver) {
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
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
    protected Object clickCancelBtn() {
        return null;
    }

    @Override
    public ContactView setViewName(String viewName) {
        setViewNameFld(viewName+ RamdonGenerator.getInstance().getRamdonString());
        return this;
    }

    @Override
    public ContactView setUniqueViewName(String uniqueViewName) {
        setUniqueViewNameFld(uniqueViewName+ RamdonGenerator.getInstance().getRamdonString());
        return this;
    }

    @Override
    public ContactView checkFilterByOwnerAll() {
        checkFilterOwnerAll();
        return this;
    }

    @Override
    public ContactView checkFilterByOwnerMy() {
        checkFilterOwnerMy();
        return this;
    }

    public ContactView setFilterByCampaign(String filterByCompaingName) {
        filterByCampaign.sendKeys(filterByCompaingName);
        return this;
    }

    @Override
    public ContactView checkFilterByOwner(String filter) {
        return this;
    }

    @Override
    public ContactView addAdditionalFiltersByField(int numberField, String field, String operator, String value) {
        addAdditionalFilterByField(numberField, field, operator, value);
        return this;
    }

    @Override
    public ContactView addNewFieldToDisplay(String newField) {
        addNewFldToDisplay(newField);
        return this;
    }

    @Override
    public ContactView selectRestrictVisibility(String optionVisibility) {
        selectRestrictVisibilityRadio(optionVisibility);
        return this;
    }

    @Override
    public ContactViewDetail clickSaveBtn() {
        clickSaveButton();
        return new ContactViewDetail(driver);
    }
}
