package com.salesforce.dev.pages.Campaigns;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.HomeBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Marcelo.Vargas on 13-06-15.
 */
public class CampaignsHome extends HomeBase {

    public CampaignsHome(WebDriver driver) {
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public CampaignForm clickNewBtn(){
        clickNewButton();
        return new CampaignForm(this.driver);
    }

    public CampaignDetail selectRecentItem(String campaign){
        super.clickRecentItem(campaign);
        return new CampaignDetail(this.driver);
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