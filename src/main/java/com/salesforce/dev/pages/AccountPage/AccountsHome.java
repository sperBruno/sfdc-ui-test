package com.salesforce.dev.pages.AccountPage;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.TabPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Walter Mercado on 10/06/2015.
 */
public class AccountsHome extends TabPage{

    @FindBy(name = "new")
    @CacheLookup
    private WebElement newCampaignBtn;

    public AccountsHome(WebDriver driver) {
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public AccountForm clickNewBtn() {
        clickNewButton();
        return new AccountForm(driver);
    }
}
