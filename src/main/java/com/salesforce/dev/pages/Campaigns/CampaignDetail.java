package com.salesforce.dev.pages.Campaigns;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.DetailsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Marcelo.Vargas on 13-06-15.
 */
public class CampaignDetail extends DetailsBase{
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "con2_ileinner")
    WebElement contactNameReg;

    public CampaignDetail(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, this);
    }

    public Object clickEditBtn(){
        super.clickEditButton();
        return new CampaignForm(driver);
    }

    public Object clickDeleteBtn(boolean confirmDeletion){
        super.clickDeleteButton(confirmDeletion);
        return new CampaignsHome(driver);
    }
}
