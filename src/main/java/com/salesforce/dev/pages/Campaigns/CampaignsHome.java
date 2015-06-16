package com.salesforce.dev.pages.Campaigns;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.TabPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Marcelo.Vargas on 13-06-15.
 */
public class CampaignsHome extends TabPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CampaignsHome(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public CampaignForm clickNewBtn(){
        super.wait.until(ExpectedConditions.visibilityOf(newBtn));
        newBtn.click();
        return new CampaignForm(this.driver);
    }
    /*
    public CampaignNewView clickCreateNewCampaignView() {
        createNewCampaignViewLink.click();
        return new CampaignNewView(driver);
    }
    public boolean verifyTextInList(String text) {
        dropdown = new Select(viewList);
        for (WebElement element : dropdown.getOptions()) {
            if (element.getText().equals(text)) {
                System.out.println("Element: " + element.getText() + " **EQUAL** " + text);
                return true;
            }
            System.out.println("Element: " + element.getText() + " != " + text);
        }
        return false;
    }

    public void SelectCreatedView(String text) {
        dropdown = new Select(viewList);
        dropdown.selectByVisibleText(text);;
    }
    public void deleteView() {
        deleteViewLink.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }*/
}