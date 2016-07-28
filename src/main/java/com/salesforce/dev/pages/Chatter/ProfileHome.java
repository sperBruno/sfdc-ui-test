package com.salesforce.dev.pages.Chatter;

import com.salesforce.dev.framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by marcelo on 6/22/2015.
 */
public class ProfileHome {
    private WebDriver driver;
    private WebDriverWait wait;



    public ProfileHome(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public void VerifyUserEmail(String email){
        driver.findElement(By.xpath("//a[contains(.,'" + email + "')]")).click();
    }


}
