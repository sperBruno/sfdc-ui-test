package com.salesforce.dev.pages.Home;

import com.salesforce.dev.pages.AbstractBasePage;
import com.salesforce.dev.pages.Login.Transporter;
import com.salesforce.dev.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
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

    private static WebDriver driverBackUp;

    @FindBy(id = "username")
    WebElement userNameFld;

    @FindBy(id = "password")
    WebElement passwordFld;

    @FindBy(id = "Login")
    WebElement loginBtn;

    MainPage mainPage;

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
        return this.loginAs(ENVIRONMENT.getPrimaryUser(), ENVIRONMENT.getPrimaryPassword());
    }

    public boolean isLoginButtonPresent() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginBtn));
            return loginBtn.isDisplayed();
        } catch (WebDriverException e) {
            return false;
        }
    }

    public static MainPage getLogin() {
        if (Transporter.driverMainPage() == null) {
            HomePage homePage = new HomePage();
            return homePage.clickLoginBtn().loginAsPrimaryUser();
        }
        return Transporter.driverMainPage();
    }

    public void setUserName(String Name) {
        setWebElement(userNameFld, Name);
    }

    public void setPassword(String Password) {
        setWebElement(passwordFld, Password);
    }

//Daniel

    public static MainPage loginAs2(String userName, String password) {
            MainPage mainPage = new MainPage();
        if (!(driverBackUp == mainPage.getDriverMainPage())) {
            driverBackUp = mainPage.getDriverMainPage();
            HomePage homePage = new HomePage();
            LoginPage loginPage = homePage.clickLoginBtn();
            loginPage.setUserName(userName);
            loginPage.setPassword(password);
            return loginPage.clickLoginBtn();
        }
        return mainPage;
    }

    public static MainPage loginAsPrimaryUser2() {
        return loginAs2(ENVIRONMENT.getPrimaryUser(), ENVIRONMENT.getPrimaryPassword());
    }

}