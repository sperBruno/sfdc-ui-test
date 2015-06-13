package com.salesforce.dev.pages.Accounts;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.TabPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Walter on 10/06/2015.
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

    @Override
    public AccountForm clickNewBtn() {
        clickNewButton();
        return new AccountForm(driver);
    }

    @Override
    public AccountDetail selectRecentItem(String value) {
        clickRecentItem(value);
        return new AccountDetail(driver);
    }
}
