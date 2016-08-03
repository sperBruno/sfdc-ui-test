package com.salesforce.dev.pages.opportunities;

import com.salesforce.dev.pages.base.HomeBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.selenium.CommonOperation.clickWebElement;
import static com.salesforce.dev.framework.selenium.CommonOperation.isElementPresent;

/**
 * This class will be used to represent Opportunities home page.
 *
 * @author Jimmy Vargas
 * @since 6/10/2015.
 */
public class OpportunitiesHome extends HomeBase {
    @FindBy(xpath = "//h1[contains(.,'Opportunities:')]")
    @CacheLookup
    private WebElement opportunitiesSection;

    public OpportunityForm clickNewBtn() {
        clickWebElement(newBtn);
        return new OpportunityForm();
    }

    @Override
    public OpportunityView clickNewViewLnk() {
        clickNewViewLink();
        return new OpportunityView();
    }

    @Override
    public OpportunityView clickEditViewLnk(String value) {
        editViewLnk(value);
        return new OpportunityView();
    }

    public OpportunityDetail selectRecentItem(String opportunity) {
        super.clickRecentItem(opportunity);
        return new OpportunityDetail();
    }

    @Override
    protected OpportunitiesHome selectRecentViewItem(String value) {
        selectRecentView(value);
        return this;
    }

    public OpportunityDetail openOpportunity(String opportunity) {
        WebElement linkOpportunity = driver.findElement(By.linkText(opportunity));
        clickWebElement(linkOpportunity);
        return new OpportunityDetail();
    }


    public boolean IsUserInOpportunitiesTab() {
        return isElementPresent(opportunitiesSection);
    }
}
