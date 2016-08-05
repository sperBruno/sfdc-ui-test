package com.salesforce.dev.pages;

import com.salesforce.dev.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.selenium.CommonOperation.clickWebElement;
import static com.salesforce.dev.framework.selenium.CommonOperation.isElementPresent;
import static com.salesforce.dev.framework.utils.Constants.SALESFORCE_URL;

/**
 * This class represents HomePage of Salesforce web application.
 *
 * @author Monica Pardo.
 * @author Bruno Barrios.
 * @author 6/12/2015.
 */

public class HomePage extends AbstractBasePage {

    @FindBy(id = "button-login")
    private WebElement loginBtn;

    @FindBy(id = "nav-open-btn")
    private WebElement homePageOptions;

    @FindBy(xpath = "//span[contains(.,'Login')]")
    private WebElement loginOption;

    /**
     * This method clicks on login btn from homepage.
     * @return LoginPage.
     */
    public LoginPage clickLoginBtn() {
        if (!isElementPresent(loginBtn)) {
            driver.navigate().to(SALESFORCE_URL);
            clickWebElement(homePageOptions);
            clickWebElement(loginOption);
        } else {
            clickWebElement(loginBtn);
        }
        return new LoginPage();
    }
}
