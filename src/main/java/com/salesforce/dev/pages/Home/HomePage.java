package com.salesforce.dev.pages.Home;

import com.salesforce.dev.pages.AbstractBasePage;
import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.salesforce.dev.framework.CommonOperation.clickWebElement;

/**
 * Created by Monica Pardo on 6/12/2015.
 */

public class HomePage extends AbstractBasePage {

    @FindBy(id = "button-login")
    @CacheLookup
    WebElement loginBtn;

    public HomePage() {
        driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(this.driver, this);
        this.wait = DriverManager.getInstance().getWait();
    }

    public LoginPage clickLoginBtn() {
        clickWebElement(loginBtn);
        return new LoginPage(this.driver);
    }

}
