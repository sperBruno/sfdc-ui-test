package com.salesforce.dev.pages.Solutions;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Monica Pardo on 6/24/2015.
 */
public class SolutionsHome {

        private WebDriver driver;
        private WebDriverWait wait;
    @FindBy(xpath = "//h1[contains(.,'Solutions:')]")
    WebElement solutionSection;

        public SolutionsHome(WebDriver driver) {
            this.driver = driver;
            this.wait = DriverManager.getInstance().getWait();
            PageFactory.initElements(driver, this);
        }
    public boolean IsUserInSolutionsTab(){
        try{

            wait.until(ExpectedConditions.visibilityOf(solutionSection));
            return true;
        }
        catch (WebDriverException e){
            return false;
        }
    }
}
