package com.salesforce.dev.pages.base;

import java.util.LinkedList;
import java.util.Set;


import com.salesforce.dev.pages.accounts.AccountForm;
import com.salesforce.dev.pages.Campaigns.CampaignForm;
import com.salesforce.dev.pages.Contacts.ContactForm;
import com.salesforce.dev.pages.Leads.LeadForm;
import com.salesforce.dev.pages.Opportunities.OpportunityForm;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Marcelo.Vargas on 17-06-15.
 */
@SuppressWarnings("unchecked")
public class SearchLookupBase extends AbstractBasePage{
    private  static final Logger LOGGER = Logger.getLogger(SearchLookupBase.class.getName());


    @FindBy(id = "lksrch")
    @CacheLookup
    private WebElement searchTxt;

    @FindBy(name = "go")
    @CacheLookup
    private WebElement goBtn;

    @SuppressWarnings({"unchecked","unsafe"})
    public void searchText(String text) {

        Set<String> windows = driver.getWindowHandles();

        LinkedList<String> windowsArray = new LinkedList(windows);
        try {
            driver.switchTo().window(windowsArray.getLast());
            driver.switchTo().frame(driver.findElement(By.name("searchFrame")));

            searchTxt.sendKeys(text);

            goBtn.click();
            driver.switchTo().window(windowsArray.getLast());
            driver.switchTo().frame(driver.findElement(By.name("resultsFrame")));

            driver.findElement(By.linkText(text)).click();
            driver.switchTo().window(windowsArray.getFirst());

            LOGGER.info("Object was serach and selected in SearchLookup");
        }
        catch (WebDriverException e){
          LOGGER.fatal("The Frames couldn't be found",e);

        }
    }

    public ContactForm goToContactForm() {
        return new ContactForm();
    }
    public CampaignForm goToCampaignForm() {
        return new CampaignForm();
    }
    public LeadForm goToLeadForm() {
        return new LeadForm();
    }
    public AccountForm goToAccountForm() {
        return new AccountForm();
    }
    public OpportunityForm goToOpportunityForm() {
        return new OpportunityForm();
    }
}
