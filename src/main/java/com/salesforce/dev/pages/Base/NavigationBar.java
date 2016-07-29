package com.salesforce.dev.pages.base;

import com.salesforce.dev.pages.Campaigns.CampaignsHome;
import com.salesforce.dev.pages.Cases.CasesHome;
import com.salesforce.dev.pages.Chatter.ChatterHome;
import com.salesforce.dev.pages.Contacts.ContactsHome;
import com.salesforce.dev.pages.Contracts.ContractsHome;
import com.salesforce.dev.pages.Dashboards.DashboardsHome;
import com.salesforce.dev.pages.Forecasts.ForecastsHome;
import com.salesforce.dev.pages.Leads.LeadsHome;
import com.salesforce.dev.pages.Opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.Orders.OrdersHome;
import com.salesforce.dev.pages.Product.ProductsHome;
import com.salesforce.dev.pages.Reports.ReportsHome;
import com.salesforce.dev.pages.Solutions.SolutionsHome;
import com.salesforce.dev.pages.accounts.AccountsHome;
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

    @FindBy(linkText = "Campaigns")
    private WebElement campaignsTab;

    @FindBy(linkText = "Leads")
    private WebElement leadsTab;

    @FindBy(linkText = "Accounts")
    private WebElement accountsTab;

    @FindBy(linkText = "Contacts")
    private WebElement contactsTab;

    @FindBy(linkText = "Opportunities")
    private WebElement opportunitiesTab;

    @FindBy(linkText = "Products")
    private WebElement productsTab;

    @FindBy(linkText = "Chatter")
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
        if ((isElementPresent(webElement) == false) && (isElementPresent(moreTabsComboBox) == true)) {
            clickWebElement(moreTabsComboBox);
            clickWebElement(webElement);
        } else {
            clickWebElement(webElement);
        }
    }
}
