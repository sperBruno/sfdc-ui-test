package com.salesforce.dev.pages;

import com.salesforce.dev.framework.selenium.DriverManager;
import com.salesforce.dev.pages.base.AbstractBasePage;
import com.salesforce.dev.pages.objects.UserInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.salesforce.dev.framework.selenium.CommonOperation.clickWebElement;
import static com.salesforce.dev.framework.selenium.CommonOperation.setWebElement;
import static com.salesforce.dev.framework.utils.Constants.ENVIRONMENT;

/**
 * Created by Monica Pardo on 6/4/2015.
 */
public class LoginPage extends AbstractBasePage {

    private static final WebDriver DRIVER = DriverManager.getInstance().getDriver();

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

    public static MainPage loginAsPrimaryUser() {
        return loginAs(ENVIRONMENT.getPrimaryUser(), ENVIRONMENT.getPrimaryPassword());
    }

    public MainPage clickLoginBtn() {
        clickWebElement(loginBtn);
        return new MainPage();
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