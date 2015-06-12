package com.salesforce.dev.pages.Base;
import com.salesforce.dev.pages.Leads.LeadsHome;
import com.salesforce.dev.pages.Product.ProductsHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.salesforce.dev.framework.DriverManager;

/**
 * Created by Monica Pardo on 6/5/2015.
 */
public class NavigationBar {

    WebDriver driver;
    WebDriverWait wait;
    @FindBy(linkText ="Leads")
    WebElement leadsTab;
    @FindBy(id = "userNavLabel")
    WebElement userLavel;

    @FindBy(linkText = "Campaigns")
    WebElement campaingsTab;

    @FindBy(linkText = "Products")
    WebElement productTab;

    public NavigationBar(WebDriver driver){
        this.driver=driver;
        this.wait= DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);

    }
    public LeadsHome clickleadTab(){
        wait.until(ExpectedConditions.visibilityOf(leadsTab));
        leadsTab.click();
        return new LeadsHome(driver);
    }

 /*   public CampaignsPage clickCamTab(){
        wait.until(ExpectedConditions.visibilityOf(campaingsTab));
        campaingsTab.click();
        return new CampaignsPage(driver);
    }*/
    public boolean IsElementPresent(WebElement webElement){
        try {
            webElement.getTagName();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }
    public boolean IsUserLavelPresent(){
        if(IsElementPresent(userLavel)){
            return true;
        }
        return false;
    }
    public ProductsHome clickProductTab(){
        wait.until(ExpectedConditions.visibilityOf(productTab));
        productTab.click();
        return new ProductsHome(driver);
    }
}

