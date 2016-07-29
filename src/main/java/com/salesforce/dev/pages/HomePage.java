package com.salesforce.dev.pages;

import com.salesforce.dev.framework.selenium.DriverManager;
import com.salesforce.dev.pages.base.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.selenium.CommonOperation.clickWebElement;
import static com.salesforce.dev.framework.selenium.CommonOperation.isWebElementVisible;

/**
 * Created by Monica Pardo on 6/12/2015.
 */

public class HomePage extends AbstractBasePage {

    private static final WebDriver DRIVER = DriverManager.getInstance().getDriver();
    @FindBy(id = "button-login")
    @CacheLookup
    private WebElement loginBtn;

    public LoginPage clickLoginBtn() {
        clickWebElement(loginBtn);
        return new LoginPage();
    }

    public void getBasePage(){
        DRIVER.get("https://www.salesforce.com/");
    }

    public boolean isLoginButtonPresent() {
        return isWebElementVisible(loginBtn);
    }
}
