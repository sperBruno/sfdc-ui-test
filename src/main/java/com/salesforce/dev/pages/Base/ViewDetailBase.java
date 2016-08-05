package com.salesforce.dev.pages.base;

import com.salesforce.dev.framework.selenium.CommonOperation;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.salesforce.dev.framework.selenium.CommonOperation.clickConfirmAlert;
import static com.salesforce.dev.framework.selenium.CommonOperation.clickWebElement;
import static com.salesforce.dev.framework.selenium.CommonOperation.getFirstSelectOption;
import static com.salesforce.dev.framework.selenium.CommonOperation.moveHorizontalWebElementScroll;

/**
 * This class will be used to represent the BaseView of all detail views
 *
 * @author Administrator
 * @since 8/20/2015.
 */

public abstract class ViewDetailBase extends AbstractBasePage {

    private static final Logger LOGGER = Logger.getLogger(ViewDetailBase.class.getName());

    @FindBy(linkText = "Edit")
    protected WebElement editLnk;

    @FindBy(linkText = "Delete")
    protected WebElement deleteLnk;

    @FindBy(linkText = "Create New View")
    protected WebElement newViewBtn;

    @FindBy(name = "fcf")
    protected WebElement viewSelected;

    protected void clickEditLink() {
        try {
            wait.until(ExpectedConditions.visibilityOf(editLnk));
            editLnk.click();
            LOGGER.info("Edit link was clicked");
        } catch (WebDriverException e) {
            LOGGER.fatal("The Edit link couldn't be found", e);
        }
    }

    /**
     * {@inheritDoc CommonOperation.clickWebElement,CommonOperation.clickConfirmAlert}
     */
    protected void clickDeleteLink() {
        clickWebElement(deleteLnk);
        clickConfirmAlert();
    }

    protected abstract Object clickEditLnk();

    /**
     * Returns next view
     */
    public abstract ViewDetailBase clickDeleteLnk();

    /**
     * {@inheritDoc CommonOperation.getFirstSelectOption}
     */
    public String getViewSelected() {
        wait.until(ExpectedConditions.visibilityOf(viewSelected));
        return getFirstSelectOption(viewSelected);
    }

    /**
     * {@inheritDoc CommonOperation.getFirstSelectOption}
     */
    public boolean validateNameView(String nameView) {
        return getFirstSelectOption(viewSelected).equals(nameView);
    }

    public boolean validateFieldDisplayed(String field) {
        final int horizontalScrollPosition = 200;
        By fieldDisplayed = By.xpath("//div[@title='" + field + "']");
        WebElement webElement = driver.findElement(By.id("ext-gen10"));
        moveHorizontalWebElementScroll(driver, webElement, horizontalScrollPosition);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldDisplayed));
        return driver.findElement(fieldDisplayed).isDisplayed();
    }
}
