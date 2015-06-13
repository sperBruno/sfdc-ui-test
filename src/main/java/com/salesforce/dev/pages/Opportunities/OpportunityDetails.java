package com.salesforce.dev.pages.Opportunities;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.DetailsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jimmy Vargas on 6/10/2015.
 */
public class OpportunityDetails extends DetailsBase {

    @FindBy(id = "opp1_ileinner")
    public WebElement  opOwner;

    WebElement opName;

    WebElement opDescription;

    WebElement closeDate;

    WebElement stage;

     public OpportunityDetails(WebDriver driver){
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(super.driver,this);
    }

    /**
     * Returns the Opportunity Form
     *
     * @author: Jimmy Vargas
     * @since: 06/13/2015
     * */
    public Object clickEditBtn(){
        super.clickEditButton();
        return new OpportunityForm(driver);
    }

    /**
     * Deletes the Opportunity returning to the Opportunities Home
     *
     * @author: Jimmy Vargas
     * @since: 06/13/2015
     * */
    public Object clickDeleteBtn(boolean confirmDeletion){
        super.clickDeletedButton(confirmDeletion);
        return new OpportunitiesHome(driver);
    }


}

