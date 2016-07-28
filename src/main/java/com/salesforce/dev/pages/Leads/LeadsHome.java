package com.salesforce.dev.pages.Leads;

import com.salesforce.dev.framework.CommonOperation;
import com.salesforce.dev.pages.Base.HomeBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Jimmy Vargas on 6/5/2015.
 */
public class LeadsHome extends HomeBase {
    @FindBy(xpath = "//h1[contains(.,'Leads:')]")
    @CacheLookup
    WebElement leadSection;

    public LeadForm clickNewBtn() {
        super.clickNewButton();
        return new LeadForm();
    }

    @Override
    public LeadView clickNewViewLnk() {
        clickNewViewLink();
        return new LeadView();
    }

    @Override
    public LeadView clickEditViewLnk(String value) {
        editViewLnk(value);
        return new LeadView();
    }

    public Object selectRecentItem(String item) {
        super.clickRecentItem(item);
        return new LeadsHome();

    }

    @Override
    public Object selectRecentViewItem(String value) {
        return null;
    }

    public LeadDetail openLead(String lead) {
        WebElement linkLead = driver.findElement(By.linkText(lead));
        wait.until(ExpectedConditions.elementToBeClickable(linkLead));

        linkLead.click();
        return new LeadDetail();
    }

    public boolean IsUserInLeadsTab() {
        return CommonOperation.isWebElementVisible(leadSection);
    }

}
