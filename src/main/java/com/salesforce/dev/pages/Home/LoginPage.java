package com.salesforce.dev.pages.Home;
import com.salesforce.dev.pages.Base.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.salesforce.dev.framework.DriverManager;

/**
 * Created by Monica Pardo on 6/4/2015.
 */
public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "username")
    WebElement userNameFld;

    @FindBy(id = "password")
    WebElement passwrodFld;

    @FindBy(id = "Login")
    WebElement loginBtn;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait=DriverManager.getInstance().getWait();
        PageFactory.initElements(driver,this);
    }

    public void SetUserName(String Name){
        wait.until(ExpectedConditions.visibilityOf(userNameFld));
        userNameFld.sendKeys(Name);
    }
    public void SetPassword(String Password){
        wait.until(ExpectedConditions.visibilityOf(passwrodFld));
        passwrodFld.sendKeys(Password);
    }
    public void ClickLoginButton(){
        loginBtn.click();
    }
    public NavigationBar LoginAs(String UserName,String Pass){
        NavigationBar navigationBar=new NavigationBar(driver);
        try {

            if (!navigationBar.IsUserLavelPresent()) {
                SetUserName(UserName);
               SetPassword(Pass);
                ClickLoginButton();
            }

        } catch (WebDriverException e) {

        }
        return navigationBar;
    }
}