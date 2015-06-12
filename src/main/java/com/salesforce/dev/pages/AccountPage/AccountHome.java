package com.salesforce.dev.pages.AccountPage;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Walter Mercado on 10/06/2015.
 */
public class AccountHome {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "new")
    @CacheLookup
    private WebElement newCampaignBtn;

    public AccountHome(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, this);
    }

    public AccountPage clickNewAccountBtn(){
        newCampaignBtn.click();
        return new AccountPage(driver);
    }
}
