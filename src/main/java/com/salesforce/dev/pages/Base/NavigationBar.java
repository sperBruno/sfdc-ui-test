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
 * @author Monica Pardo on 6/5/2015.
 * @author Jimmy Vargas
 * @author Bruno Barrios
 */
public class NavigationBar extends AbstractBasePage {

    @FindBy(id = "Order_Tab")
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

    @FindBy(id = "Product2_Tab")
    private WebElement productsTab;

    @FindBy(id = "Chatter_Tab")
    private WebElement chatterTab;

    @FindBy(id = "Forecasting3_Tab")
    private WebElement forecastsTab;

    @FindBy(id = "Contract_Tab")
    private WebElement contractsTab;

    @FindBy(id = "Case_Tab")
    private WebElement casesTab;

    @FindBy(id = "Solution_Tab")
    private WebElement solutionsTab;

    @FindBy(id = "report_Tab")
    private WebElement reportsTab;

    @FindBy(id = "Dashboard_Tab")
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
        if ((!isElementPresent(webElement)) && (isElementPresent(moreTabsComboBox))) {
            clickWebElement(moreTabsComboBox);
            clickWebElement(webElement);
        } else {
            clickWebElement(webElement);
        }
    }
}
