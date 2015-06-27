package com.salesforce.dev.pages.Home;
import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.framework.LoggerManager;
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

/**
 * Created by Monica Pardo on 6/12/2015.
 */

 public class HomePage {

   private WebDriver driver;
   private WebDriverWait wait;

   @FindBy(id = "button-login")
   @CacheLookup
   WebElement loginBtn;

   public HomePage(){
     driver = DriverManager.getInstance().getDriver();
     PageFactory.initElements(this.driver,this);
     this.wait = DriverManager.getInstance().getWait();
   }

   public LoginPage clickLoginBtn(){
     try {
       wait.until(ExpectedConditions.visibilityOf(loginBtn));
       LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
               "Login button was clicked");

     }catch(WebDriverException e){
       LoggerManager.getInstance().addFatalLog(this.getClass().getName(),
               "The Login button couldn't be found",
               e.fillInStackTrace());
     }

     loginBtn.click();
     return new LoginPage(this.driver);
   }

  /**
   * Method that make sure to log with the correct user
   *
   * @author: Jimmy Vargas
   * */

  public MainPage loginAsPrimaryUser(){
    String userNameValue= Environment.getInstance().getPrimaryUser();
    String displayName= Environment.getInstance().getDisplayName();
    String passwordValue=Environment.getInstance().getPrimaryPassword();
    MainPage mainPage;

    try{
      mainPage = new MainPage(this.driver);
      TopHeader topHeader =  mainPage.gotoTopHeader();
      if(topHeader.isUserMenuPresent()){
        if(!topHeader.isLoggedUser(displayName)){
          LoginPage loginPage = topHeader.logout();
          LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                  "Logout action was performed");
          mainPage = loginPage.loginAs(userNameValue, passwordValue);
          LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                  "Login action with the User: "+userNameValue+ " was performed");
        }
      }

    }
    catch(WebDriverException e){
      LoginPage loginPage = this.clickLoginBtn();
      mainPage = loginPage.loginAs(userNameValue, passwordValue);
      LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
              "Login action with the User: "+userNameValue+ " was performed");
    }
    return mainPage;
  }

}
