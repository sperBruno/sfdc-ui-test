package com.salesforce.dev.pages.Home;

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.AbstractBasePage;
import com.salesforce.dev.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.salesforce.dev.framework.DriverManager;

import static com.salesforce.dev.framework.CommonOperation.clickWebElement;
import static com.salesforce.dev.framework.CommonOperation.setWebElement;

/**
 * Created by Monica Pardo on 6/4/2015.
 */
public class LoginPage extends AbstractBasePage {

    @FindBy(id = "username")
    WebElement userNameFld;

    @FindBy(id = "password")
    WebElement passwrodFld;

    @FindBy(id = "Login")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public MainPage clickLoginBtn() {
        clickWebElement(loginBtn);
        return new MainPage(this.driver);
    }

    /**
     * Returns the Main Page which contains the TopHeader and Navigation Bar
     * And the Main Page is the one who initializes those objects
     *
     * @author: Jimmy Vargas
     */
    public MainPage loginAs(String userName, String password) {
        this.setUserName(userName);
        this.setPassword(password);
        return this.clickLoginBtn();
    }

    public MainPage loginAsPrimaryUser() {
        this.setUserName(Environment.getInstance().getPrimaryUser());
        this.setPassword(Environment.getInstance().getPrimaryPassword());
        return this.clickLoginBtn();
    }

    public boolean isLoginButtonPresent() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginBtn));
            return loginBtn.isDisplayed();
        } catch (WebDriverException e) {
            return false;
        }
    }

    public void setUserName(String Name) {
        setWebElement(userNameFld, Name);
    }

    public void setPassword(String Password) {
        setWebElement(passwrodFld, Password);
    }


}