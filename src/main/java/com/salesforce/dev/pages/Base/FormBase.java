package com.salesforce.dev.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static com.salesforce.dev.framework.selenium.CommonOperation.clickWebElement;

/**
 * Created by Walter on 13/06/2015.
 */
public abstract class FormBase extends AbstractBasePage {


    @FindBy(name = "save")
    protected WebElement saveBtn;

    @FindBy(name = "save_new")
    protected WebElement saveNewBtn;

    @FindBy(name = "cancel")
    protected WebElement cancelBtn;

    //Calendar
    @FindBy(id = "calMonthPicker")
    protected WebElement monthPicker;

    @FindBy(id = "calYearPicker")
    protected WebElement yearPicker;

    protected String[] months;

    /**
     * Method clicks the New button in the home page for each different category
     *
     * @author: Walter
     */
    protected abstract DetailsBase clickSaveBtn();

    protected abstract AbstractBasePage clickSaveNewBtn();

    protected abstract Object clickCancelBtn();

    /**
     * Methods that encapsulates the the operations waiting for the element and the action
     *
     * @author: Walter
     */
    protected void clickSaveButton() {
        clickWebElement(saveBtn);
    }

    protected void clickSaveNewButton() {
        clickWebElement(saveNewBtn);
    }

    protected void clickCancelButton() {
        clickWebElement(cancelBtn);
    }

    protected void selectDatePicker(Integer month, Integer day, Integer year) {
        months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.selectItemComboBox(monthPicker, months[month - 1]);
        this.selectItemComboBox(yearPicker, year.toString());
        WebElement selectDate = driver.findElement(
                By.xpath("//div[@class='calBody']/descendant::td[contains(.,'" + day + "')]"));
        selectDate.click();
    }

    protected void selectItemComboBox(WebElement webElement, String value) {
        if (value.equals(null)) {
            throw new IllegalArgumentException("The value cannot be null");
        }
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            Select comboBox = new Select(webElement);
            comboBox.selectByVisibleText(value);
        } catch (WebDriverException e) {
            throw new WebDriverException("The value " + value + "couldn't be selected");
        }
    }

    protected void fillTextBox(WebElement webElement, String value) {
        if (value.equals(null)) {
            throw new IllegalArgumentException("The value cannot be null.");
        }
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        try {
            Thread.sleep(200);
        } catch (Exception e) {
        }

        webElement.sendKeys(value);
    }
}
