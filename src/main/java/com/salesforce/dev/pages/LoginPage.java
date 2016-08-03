package com.salesforce.dev.pages;

import com.salesforce.dev.framework.soap.UserInformation;
import com.salesforce.dev.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.selenium.CommonOperation.*;
import static com.salesforce.dev.framework.utils.Constants.ENVIRONMENT;

;

/**
 * This class represents the login page of salesforce.
 *
 * @author Monica Pardo.
 * @author Bruno Barrios.
 * @since 6/4/2015.
 */
public class LoginPage extends AbstractBasePage {

    @FindBy(id = "username")
    private WebElement userNameFld;

    @FindBy(id = "password")
    private WebElement passwordFld;

    @FindBy(id = "Login")
    private WebElement loginBtn;

    /**
     * Returns the Main Page which contains the TopHeader and Navigation Bar
     * And the Main Page is the one who initializes those objects
     */
    private static MainPage loginAs(String userName, String password) {
        MainPage mainPage = new MainPage();
        if (!mainPage.gotoTopHeader().getUserName().equalsIgnoreCase(UserInformation.getUserFullName())) {
            HomePage homePage = new HomePage();
            LoginPage loginPage = homePage.clickLoginBtn();
            loginPage.setUserName(userName);
            loginPage.setPassword(password);
            return loginPage.clickLoginBtn();
        }
        return mainPage;
    }

    /**
     * This method is used to login into Salesforce.
     *
     * @return the username that is already logged in.
     */
    public static MainPage loginAsPrimaryUser() {
        return loginAs(ENVIRONMENT.getPrimaryUser(), ENVIRONMENT.getPrimaryPassword());
    }

    /**
     * This method click the login btn.
     * @return MainPage
     */
    public MainPage clickLoginBtn() {
        clickWebElement(loginBtn);
        return new MainPage();
    }

    public boolean isLoginButtonPresent() {
        isWebElementVisible(loginBtn);
        return loginBtn.isDisplayed();
    }

    public void setUserName(String Name) {
        setWebElement(userNameFld, Name);
    }

    public void setPassword(String Password) {
        setWebElement(passwordFld, Password);
    }


}