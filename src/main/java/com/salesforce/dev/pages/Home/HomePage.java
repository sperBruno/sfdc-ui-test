package com.salesforce.dev.pages.Home;

import com.salesforce.dev.framework.CommonOperation;
import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.TopHeader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.salesforce.dev.framework.CommonOperation.clickWebElement;

/**
 * Created by Monica Pardo on 6/12/2015.
 */

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private static MainPage loginInstance;

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

    public MainPage getLogin() {
        if (loginInstance == null) {
            loginInstance = new MainPage();
        }
        return loginInstance;
    }

    public MainPage loginAsPrimaryUser(){
        LoginPage loginPage = this.clickLoginBtn();
        return loginPage.loginAs(Environment.getInstance().getPrimaryUser(), Environment.getInstance().getPrimaryPassword());
    }
}
