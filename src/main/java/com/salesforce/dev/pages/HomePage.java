package com.salesforce.dev.pages;

import com.salesforce.dev.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.selenium.CommonOperation.clickWebElement;
import static com.salesforce.dev.framework.selenium.CommonOperation.isElementPresent;

/**
 * Created by Monica Pardo on 6/12/2015.
 */

public class HomePage extends AbstractBasePage {

    @FindBy(id = "button-login")
    private WebElement loginBtn;

    @FindBy(id = "nav-open-btn")
    private WebElement homePageOptions;

    @FindBy(xpath = "//span[contains(.,'Login')]")
    private WebElement loginOption;

    public LoginPage clickLoginBtn() {
        if (!isElementPresent(loginBtn)) {
            driver.navigate().to("https://www.salesforce.com");
            clickWebElement(homePageOptions);
            clickWebElement(loginOption);
        } else {
            clickWebElement(loginBtn);
        }
        return new LoginPage();
    }
}
