package com.salesforce.dev.pages.Opportunities;

import com.salesforce.dev.pages.Base.HomeBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.CommonOperation.clickWebElement;
import static com.salesforce.dev.framework.CommonOperation.isElementPresent;

/**
 * Created by Jimmy Vargas on 6/10/2015.
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
        return new OpportunityView(this.driver);
    }

    @Override
    public OpportunityView clickEditViewLnk(String value) {
        editViewLnk(value);
        return new OpportunityView(this.driver);
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
