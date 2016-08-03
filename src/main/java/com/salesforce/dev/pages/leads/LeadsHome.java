package com.salesforce.dev.pages.leads;

import com.salesforce.dev.pages.base.AbstractBasePage;
import com.salesforce.dev.pages.base.HomeBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.salesforce.dev.framework.selenium.CommonOperation.isWebElementVisible;

/**
 * This class will be used to represent Lead home and its options.
 *
 * @author Jimmy Vargas
 * @since 6/5/2015.
 */
public class LeadsHome extends HomeBase {
    @FindBy(xpath = "//h1[contains(.,'Leads:')]")
    @CacheLookup
    private WebElement leadSection;

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
    public AbstractBasePage selectRecentViewItem(String value) {
        return null;
    }

    public LeadDetail openLead(String lead) {
        WebElement linkLead = driver.findElement(By.linkText(lead));
        wait.until(ExpectedConditions.elementToBeClickable(linkLead));

        linkLead.click();
        return new LeadDetail();
    }

    public boolean IsUserInLeadsTab() {
        return isWebElementVisible(leadSection);
    }

}
