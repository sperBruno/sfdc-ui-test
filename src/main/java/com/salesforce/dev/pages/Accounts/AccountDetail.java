package com.salesforce.dev.pages.Accounts;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Walter on 10/06/2015.
 */
public class AccountDetail {
    private WebDriver driver;
    private WebDriverWait wait;

    public AccountDetail(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }



}
