package com.salesforce.dev.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.salesforce.dev.pages.base.AbstractBasePage;

import static com.salesforce.dev.framework.selenium.CommonOperation.clickWebElement;

/**
 * Created by Monica Pardo on 6/12/2015.
 */

public class HomePage extends AbstractBasePage {


    @FindBy(id = "button-login")
    @CacheLookup
    private WebElement loginBtn;

    public LoginPage clickLoginBtn() {
        clickWebElement(loginBtn);
        return new LoginPage();
    }


}
