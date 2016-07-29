package com.salesforce.dev.pages.base;

import com.salesforce.dev.pages.accounts.AccountsHome;
import com.salesforce.dev.pages.campaigns.CampaignsHome;
import com.salesforce.dev.pages.cases.CasesHome;
import com.salesforce.dev.pages.chatter.ChatterHome;
import com.salesforce.dev.pages.contacts.ContactsHome;
import com.salesforce.dev.pages.contracts.ContractsHome;
import com.salesforce.dev.pages.dashboards.DashboardsHome;
import com.salesforce.dev.pages.forecasts.ForecastsHome;
import com.salesforce.dev.pages.leads.LeadsHome;
import com.salesforce.dev.pages.opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.orders.OrdersHome;
import com.salesforce.dev.pages.product.ProductsHome;
import com.salesforce.dev.pages.reports.ReportsHome;
import com.salesforce.dev.pages.solutions.SolutionsHome;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.selenium.CommonOperation.clickWebElement;
import static com.salesforce.dev.framework.selenium.CommonOperation.isElementPresent;

/**
 * Created by Monica Pardo on 6/5/2015.
 */
public class NavigationBar extends AbstractBasePage {

    @FindBy(linkText = "Orders")
    private WebElement ordersTab;

    @FindBy(id = "Campaign_Tab")
    private WebElement campaignsTab;

    @FindBy(id = "Lead_Tab")
    private WebElement leadsTab;

    @FindBy(linkText = "Accounts")
    private WebElement accountsTab;

    @FindBy(id = "Contact_Tab")
    private WebElement contactsTab;

    @FindBy(id = "Opportunity_Tab")
    private WebElement opportunitiesTab;

    @FindBy(linkText = "Products")
    //Product2_Tab
    private WebElement productsTab;

    @FindBy(id = "Chatter_Tab")
    private WebElement chatterTab;

    @FindBy(linkText = "Forecasts")
    private WebElement forecastsTab;

    @FindBy(linkText = "Contracts")
    private WebElement contractsTab;

    @FindBy(linkText = "Cases")
    private WebElement casesTab;

    @FindBy(linkText = "Solutions")
    private WebElement solutionsTab;

    @FindBy(linkText = "Reports")
    private WebElement reportsTab;

    @FindBy(linkText = "Dashboards")
    private WebElement dashboardTab;

    @FindBy(id = "MoreTabs_Tab")
    private WebElement moreTabsComboBox;

    public CampaignsHome goToCampaignsHome() {
        clickElementOfHomeTab(campaignsTab);
        return new CampaignsHome();
    }

    public LeadsHome gotToLeadsHome() {
        clickWebElement(leadsTab);
        return new LeadsHome();
    }

    public AccountsHome goToAccountsHome() {
        clickElementOfHomeTab(accountsTab);
        return new AccountsHome();
    }

    public ContactsHome goToContactsHome() {
        clickElementOfHomeTab(contactsTab);
        return new ContactsHome();
    }

    /**
     * This method returns an instance from OpportunitiesTab
     *
     * @author: Jimmy Vargas
     * @version: 1.0
     * @since: 6/10/2015
     */
    public OpportunitiesHome goToOpportunitiesHome() {
        clickElementOfHomeTab(opportunitiesTab);
        return new OpportunitiesHome();
    }

    public ProductsHome goToProductsHome() {
        clickElementOfHomeTab(productsTab);
        return new ProductsHome();
    }

    public boolean IsElementPresent(WebElement webElement) {
        try {
            webElement.getTagName();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }


    public ChatterHome goToChatterHome() {
        clickElementOfHomeTab(chatterTab);
        return new ChatterHome();
    }


    public ForecastsHome goToForesCastsHome() {
        clickElementOfHomeTab(forecastsTab);
        return new ForecastsHome();
    }

    public ContractsHome goToContractsHome() {
        clickElementOfHomeTab(contractsTab);
        return new ContractsHome();
    }

    public OrdersHome goToOrdersHome() {
        clickElementOfHomeTab(ordersTab);
        return new OrdersHome();
    }

    public CasesHome goToCasesHome() {
        clickElementOfHomeTab(casesTab);
        return new CasesHome();
    }

    public SolutionsHome goToSolutionsHome() {
        clickElementOfHomeTab(solutionsTab);
        return new SolutionsHome();
    }

    public ReportsHome goToReportsHome() {
        clickElementOfHomeTab(reportsTab);
        return new ReportsHome();
    }

    public DashboardsHome goToDashboardsHome() {
        clickElementOfHomeTab(dashboardTab);
        return new DashboardsHome();
    }

    private void clickElementOfHomeTab(WebElement webElement) {
        if ((!isElementPresent(webElement)) && (isElementPresent(moreTabsComboBox))) {
            clickWebElement(moreTabsComboBox);
            clickWebElement(webElement);
        } else {
            clickWebElement(webElement);
        }
    }

    private void clickElementOfHomeTab(WebElement webElement) {
        if ((isElementPresent(webElement) == false) && (isElementPresent(moreTabsComboBox) == true)) {
            clickWebElement(moreTabsComboBox);
            clickWebElement(webElement);
        } else {
            clickWebElement(webElement);
        }
    }
}
