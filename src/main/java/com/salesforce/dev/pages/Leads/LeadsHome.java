package com.salesforce.dev.pages.Leads;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.HomeBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Jimmy Vargas on 6/5/2015.
 */
public class LeadsHome extends HomeBase {
    @FindBy(xpath = "//h1[contains(.,'Leads:')]")
    @CacheLookup
    WebElement leadSection;

    public LeadsHome(WebDriver driver){
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(this.driver, this);

    }

    public LeadForm clickNewBtn(){
        super.clickNewButton();
        return new LeadForm(super.driver);

    }

    @Override
    protected Object clickNewViewLnk() {
        return null;
    }

    @Override
    protected Object clickEditViewLnk(String value) {
        return null;
    }

    public Object selectRecentItem(String item){
        super.clickRecentItem(item);
        return new LeadsHome(super.driver);

    }

    @Override
    protected Object selectRecentViewItem(String value) {
        return null;
    }

    public LeadDetail openLead(String lead){
        WebElement linkLead = driver.findElement(By.linkText(lead));
        wait.until(ExpectedConditions.elementToBeClickable(linkLead));

        linkLead.click();
        return new LeadDetail(this.driver);
    }
    public boolean IsUserInLeadsTab(){
        try{

            wait.until(ExpectedConditions.visibilityOf(leadSection));
            return true;
        }
        catch (WebDriverException e){
            return false;
        }
    }

}
