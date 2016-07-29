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
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.selenium.CommonOperation.clickWebElement;
import static com.salesforce.dev.framework.selenium.CommonOperation.isElementPresent;

/**
 * Created by Monica Pardo on 6/5/2015.
 */
public class NavigationBar extends AbstractBasePage {

    @FindBy(linkText = "orders")
    private WebElement ordersTab;

    @FindBy(linkText = "campaigns")
    private WebElement campaignsTab;

    @FindBy(linkText = "leads")
    private WebElement leadsTab;

    @FindBy(id = "Account_Tab")
    private WebElement accountsTab;

    @FindBy(linkText = "contacts")
    private WebElement contactsTab;

    @FindBy(linkText = "opportunities")
    private WebElement opportunitiesTab;

    @FindBy(linkText = "Products")
    private WebElement productsTab;

    @FindBy(linkText = "chatter")
    private WebElement chatterTab;

    @FindBy(linkText = "forecasts")
    private WebElement forecastsTab;

    @FindBy(linkText = "contracts")
    private WebElement contractsTab;

    @FindBy(linkText = "cases")
    private WebElement casesTab;

    @FindBy(linkText = "solutions")
    private WebElement solutionsTab;

    @FindBy(linkText = "reports")
    private WebElement reportsTab;

    @FindBy(linkText = "dashboards")
    private WebElement dashboardTab;

    @FindBy(id = "MoreTabs_Tab")
    private WebElement moreTabsComboBox;

    public CampaignsHome goToCampaignsHome() {
        clickWebElement(campaignsTab);
        return new CampaignsHome();
    }

    public LeadsHome gotToLeadsHome() {
        clickWebElement(leadsTab);
        return new LeadsHome();
    }

    public AccountsHome goToAccountsHome() {
        clickWebElement(accountsTab);
        return new AccountsHome();
    }

    public ContactsHome goToContactsHome() {
        clickWebElement(contactsTab);
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
        clickWebElement(opportunitiesTab);
        return new OpportunitiesHome();
    }

    public ProductsHome goToProductsHome() {
        clickWebElement(productsTab);
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
        clickWebElement(chatterTab);
        return new ChatterHome();
    }


    public ForecastsHome goToForescastsHome() {
        clickWebElement(forecastsTab);
        return new ForecastsHome();
    }

    public ContractsHome goToContractsHome() {
        clickWebElement(contractsTab);
        return new ContractsHome();
    }

    public OrdersHome goToOrdersHome() {
        clickWebElement(ordersTab);
        return new OrdersHome();
    }

    public CasesHome goToCasesHome() {
        clickWebElement(casesTab);
        return new CasesHome();
    }

    public SolutionsHome goToSolutionsHome() {
        clickWebElement(solutionsTab);
        return new SolutionsHome();
    }

    public ReportsHome goToReportsHome() {
        clickWebElement(reportsTab);
        return new ReportsHome();
    }

    public DashboardsHome goToDashboardsHome() {
        if((isElementPresent(dashboardTab) == false) && (isElementPresent(moreTabsComboBox)== true)) {
            clickWebElement(moreTabsComboBox);
            clickWebElement(dashboardTab);
        }else{
            clickWebElement(dashboardTab);
        }
        return new DashboardsHome();
    }
}
