package com.salesforce.dev.pages.chatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class will be used to
 *
 * @author marcelo
 * @since 6/22/2015.
 */
public class ProfileHome {

    private WebDriver driver;

    public void verifyUserEmail(String email){
        driver.findElement(By.xpath("//a[contains(.,'" + email + "')]")).click();
    }


}
