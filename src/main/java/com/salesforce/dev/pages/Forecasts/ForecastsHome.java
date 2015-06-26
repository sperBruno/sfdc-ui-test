package com.salesforce.dev.pages.Forecasts;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by marcelo on 6/22/2015.
 */
public class ForecastsHome {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h1[contains(.,'Introducing Forecasts')]")
    WebElement forecastSection;

    public ForecastsHome(WebDriver driver) {
       this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
    public boolean IsUserInForecastsTab(){
        try{

            wait.until(ExpectedConditions.visibilityOf(forecastSection));
            return true;
        }
        catch (WebDriverException e){
            return false;
        }
    }

}
