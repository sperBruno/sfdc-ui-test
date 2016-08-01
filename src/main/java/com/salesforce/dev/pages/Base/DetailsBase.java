package com.salesforce.dev.pages.base;

import java.util.Map;

import com.salesforce.dev.framework.selenium.CommonOperation;
import com.salesforce.dev.pages.MainPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.selenium.CommonOperation.clickConfirmAlert;
import static com.salesforce.dev.framework.selenium.CommonOperation.clickWebElement;

/**
 * Created by Jimmy Vargas on 6/13/2015.
 * <p>
 * This class will contain the common objects for the Details pages
 *
 * @author: Jimmy Vargas
 * @since: 6/13/2015
 */
public abstract class DetailsBase extends com.salesforce.dev.pages.base.AbstractBasePage {

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
     * @author: Walter
     * @author: Mijhail
     */
    protected void clickDeletedButton() {
        clickWebElement(deleteAccBtn);
        clickConfirmAlert();
    }

    public MainPage gotoMainPage() {
        return new MainPage();
    }

    /**
     * Returns the corresponding form
     *
     * @author: Jimmy Vargas
     * @since: 6/13/2015
     */
    protected abstract FormBase clickEditBtn();


    /**
     * Return Home page when do click delete button
     *
     * @author: Mijhail Villarroel
     */
    public abstract HomeBase clickDeleteButton();

    /**
     * Return Map the assertions
     *
     * @author: Mijhail Villarroel
     */
    public abstract Map<Enum, Object> getAssertionMap();
}
