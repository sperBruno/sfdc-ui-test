package com.salesforce.dev.pages.Accounts;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.DetailsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Walter on 10/06/2015.
 */
public class AccountDetail extends DetailsBase {


    public AccountDetail(WebDriver driver) {
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(super.driver, this);
    }

    @Override
    public AccountForm clickEditBtn() {
        clickEditButton();
        return new AccountForm(driver);
    }

    @Override
    public AccountsHome clickDeleteBtn(boolean confirmDeletion) {
        clickDeletedButton(true);
        return new AccountsHome(driver);

    }
}
