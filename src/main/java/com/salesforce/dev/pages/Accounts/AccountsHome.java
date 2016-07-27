package com.salesforce.dev.pages.Accounts;

import com.salesforce.dev.pages.Base.HomeBase;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Created by Walter on 10/06/2015.
 */
public class AccountsHome extends HomeBase {

    @FindBy(xpath = "//h1[contains(.,'Accounts:')]")
    private WebElement accountSection;

    @Override
    public AccountForm clickNewBtn() {
        clickNewButton();
        return new AccountForm();
    }

    @Override
    public AccountView clickNewViewLnk() {
        clickNewViewLink();
        return new AccountView(this.driver);
    }

    @Override
    public AccountView clickEditViewLnk(String value) {
        editViewLnk(value);
        return new AccountView(this.driver);
    }

    @Override
    public AccountDetail selectRecentItem(String value) {
        clickRecentItem(value);
        return new AccountDetail();
    }

    @Override
    public AccountsHome selectRecentViewItem(String value) {
        selectRecentView(value);
        return this;
    }

    public boolean IsUserInAccountsTab() {
        try {
            WAIT.until(ExpectedConditions.visibilityOf(accountSection));
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }
}
