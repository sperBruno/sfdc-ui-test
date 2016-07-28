package com.salesforce.dev.pages.Base;

import com.salesforce.dev.pages.AbstractBasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.CommonOperation.clickWebElement;
import static com.salesforce.dev.framework.CommonOperation.setWebElement;

/**
 * Created by Jimmy Vargas on 6/11/2015.
 */
public abstract class HomeBase extends AbstractBasePage {
    private static final Logger LOGGER = Logger.getLogger(HomeBase.class.getName());

    @FindBy(id = "fcf")
    protected WebElement viewCombobox;

    @FindBy(name = "new")
    protected WebElement newBtn;

    @FindBy(name = "go")
    protected WebElement goBtn;

    @FindBy(linkText = "Create New View")
    protected WebElement newViewLnk;

    @FindBy(linkText = "Edit")
    protected WebElement editViewLnk;


    /**
     * Method clicks the New button in the home page for each different category
     *
     * @author: Jimmy
     */
    protected abstract Object clickNewBtn();

    /**
     * Method clicks the New Link in the home page for each different category
     *
     * @author: veronica
     */
    protected abstract Object clickNewViewLnk();

    /**
     * Method clicks the NEdit view in the home page for each different category
     *
     * @author: veronica
     */
    protected abstract Object clickEditViewLnk(String value);

    /**
     * Method that encapsulates the the operations waiting for the elemeent and the action
     *
     * @author: Jimmy
     */
    protected void clickNewButton() {
        try {
            clickWebElement(newBtn);
            LOGGER.info("New button was clicked");
        } catch (WebDriverException e) {
            LOGGER.fatal("The New button couldn't be found", e);
        }
    }

    /**
     * Method that encapsulates the the operations waiting for the elemeent and the action
     *
     * @author: veronica
     */
    protected void clickNewViewLink() {
        try {
            clickWebElement(newViewLnk);
            LOGGER.info("New View Link was clicked");
        } catch (WebDriverException e) {
            LOGGER.fatal("The New View Link couldn't be found", e);
        }
    }

    protected abstract Object selectRecentItem(String value);

    protected void clickRecentItem(String value) {
        try {
            WebElement recentItem = driver.findElement(
                    By.xpath("//div[@class='hotListElement']/descendant::a[contains(.,'" + value + "')]"));
            recentItem.click();
            LOGGER.info("Recent Item was selected");
        } catch (WebDriverException e) {
            LOGGER.info("The Recent Item button couldn't be found", e);
        }
    }

    protected abstract Object selectRecentViewItem(String value);

    protected void selectRecentView(String value) {
        setWebElement(viewCombobox, value);
    }

    protected void editViewLnk(String value) {
        selectRecentView(value);
        editViewLnk.click();
    }
}