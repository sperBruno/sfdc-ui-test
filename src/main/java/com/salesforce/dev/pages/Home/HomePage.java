package com.salesforce.dev.pages.Home;
import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.By;
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
     wait.until(ExpectedConditions.visibilityOf(loginBtn));
     loginBtn.click();
     return new LoginPage(this.driver);
   }


}
