package com.salesforce.dev.pages.chatter;

import com.salesforce.dev.framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class will be used to
 *
 * @author marcelo
 * @since 6/22/2015.
 */
public class ProfileHome {

    private WebDriver driver;

    public void VerifyUserEmail(String email){
        driver.findElement(By.xpath("//a[contains(.,'" + email + "')]")).click();
    }


}
