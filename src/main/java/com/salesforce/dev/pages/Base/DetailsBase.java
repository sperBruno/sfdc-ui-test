package com.salesforce.dev.pages.Base;

import com.salesforce.dev.pages.AbstractBasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.CommonOperation.clickWebElement;

/**
 * Created by Jimmy Vargas on 6/13/2015.
 * <p>
 * This class will contain the common objects for the Details pages
 *
 * @author: Jimmy Vargas
 * @since: 6/13/2015
 */
public abstract class DetailsBase extends AbstractBasePage {

    private static final Logger LOGGER = Logger.getLogger(DetailsBase.class.getName());

    @FindBy(name = "edit")
    private WebElement editBtn;

    @FindBy(name = "del")
    private WebElement deleteBtn;

    @FindBy(name = "delete")
    private WebElement deleteAccBtn;

    @FindBy(name = "clone")
    private WebElement cloneBtn;

    /**
     * Clicks the Edit button
     *
     * @author: Jimmy Vargas
     * @since: 6/13/2015
     */
    protected void clickEditButton() {
        try {
            clickWebElement(editBtn);
            LOGGER.info("Edit button was clicked");
        } catch (WebDriverException e) {
            LOGGER.fatal("The SaveNew button couldn't be found", e);
        }
    }

    /**
     * Clicks delete button
     *
     * @author: Jimmy Vargas
     * @since: 6/13/2015
     */
    protected void clickDeleteButton(boolean confirmDeletion) {
        clickWebElement(deleteBtn);
        deleteAlert(confirmDeletion);
    }

    /**
     * Clicks delete button
     *
     * @author: Walter
     */
    protected void clickDeletedAccButton(boolean confirmDeletion) {
        clickWebElement(deleteAccBtn);
        deleteAlert(confirmDeletion);
    }

    private void deleteAlert(boolean confirmDeletion) {
        Alert alert;
        try {
            alert = driver.switchTo().alert();

            if (confirmDeletion) {
                alert.accept();
            }
            alert.dismiss();
            LOGGER.info("Delete Button was clicked");
        } catch (WebDriverException e) {
            LOGGER.fatal("The Delete button couldn't be found", e);
        }
    }

    /**
     * Clicks clone button
     *
     * @author: Jimmy Vargas
     * @since: 6/13/2015
     */
    protected void clickCloneButton() {
        try {
            clickWebElement(cloneBtn);
            LOGGER.info("Clone Button was clicked");
        } catch (WebDriverException e) {
            LOGGER.fatal("The Clone button couldn't be found",
                    e);
        }
    }

    /**
     * Returns the corresponding form
     *
     * @author: Jimmy Vargas
     * @since: 6/13/2015
     */
    protected abstract Object clickEditBtn();

    /**
     * Returns to the Details when the confirmation is false and return to home when the confirmation is true
     *
     * @author: Jimmy Vargas
     * @since: 6/13/2015
     */
    protected abstract Object clickDeleteBtn(boolean confirmDeletion);
}
