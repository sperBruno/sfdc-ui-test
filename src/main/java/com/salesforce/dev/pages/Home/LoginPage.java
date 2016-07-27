package com.salesforce.dev.pages.Home;

import com.salesforce.dev.pages.AbstractBasePage;
import com.salesforce.dev.pages.MainPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.salesforce.dev.framework.CommonOperation.clickWebElement;
import static com.salesforce.dev.framework.CommonOperation.setWebElement;
import static com.salesforce.dev.framework.utils.Constants.ENVIRONMENT;

/**
 * Created by Monica Pardo on 6/4/2015.
 */
public class LoginPage extends AbstractBasePage {

    @FindBy(id = "username")
    private WebElement userNameFld;

    @FindBy(id = "password")
    private WebElement passwordFld;

    @FindBy(id = "Login")
    private WebElement loginBtn;

    public MainPage clickLoginBtn() {
        clickWebElement(loginBtn);
        return new MainPage();
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
        return this.loginAs(ENVIRONMENT.getPrimaryUser(), ENVIRONMENT.getPrimaryPassword());
    }

    public boolean isLoginButtonPresent() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        return loginBtn.isDisplayed();
    }

    public void setUserName(String Name) {
        setWebElement(userNameFld, Name);
    }

    public void setPassword(String Password) {
        setWebElement(passwordFld, Password);
    }


}