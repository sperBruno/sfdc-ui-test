package com.salesforce.dev.pages.Campaigns;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.DetailsBase;
import com.salesforce.dev.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Marcelo.Vargas on 13-06-15.
 */
public class CampaignDetail extends DetailsBase{

    @FindBy(id = "con2_ileinner")
    WebElement contactNameReg;

    public CampaignDetail(WebDriver driver) {
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, this);
    }

    @Override
    public CampaignForm clickEditBtn(){
        clickEditButton();
        return new CampaignForm(driver);
    }

    @Override
    public Object clickDeleteBtn(boolean confirmDeletion){
        clickDeleteButton(confirmDeletion);
        return new CampaignsHome(driver);
    }

    public MainPage gotoMainPage(){
        return new MainPage(driver);
    }
}
