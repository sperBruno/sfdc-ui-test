package com.salesforce.dev.pages.Accounts;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.HomeBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Created by Walter on 10/06/2015.
 */
public class AccountsHome extends HomeBase {

    @FindBy(xpath = "//h1[contains(.,'Accounts:')]")
    WebElement accountSection;

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
    protected Object clickNewViewLnk() {
        return null;
    }

    @Override
    protected Object clickEditViewLnk(String value) {
        return null;
    }

    @Override
    public AccountDetail selectRecentItem(String value) {
        clickRecentItem(value);
        return new AccountDetail(driver);
    }

    @Override
    protected Object selectRecentViewItem(String value) {
        return null;
    }

    public boolean IsUserInAccountsTab(){
        try{

            wait.until(ExpectedConditions.visibilityOf(accountSection));
            return true;
        }
        catch (WebDriverException e){
            return false;
        }
    }
}
