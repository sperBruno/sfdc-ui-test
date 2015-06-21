package com.salesforce.dev.pages.Leads;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.DetailsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Jimmy Vargas on 6/15/2015.
 */
public class LeadDetail extends DetailsBase {


    public LeadDetail(WebDriver driver){
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(super.driver, this);

    }

    public LeadForm clickEditBtn(){
        super.clickEditButton();
        return new LeadForm(this.driver);
    }


    public LeadsHome deleteLead(){
        return clickDeleteBtn(true);

    }

    @Override
    protected LeadsHome clickDeleteBtn(boolean confirmDeletion) {
        super.clickDeleteButton(true);
        return new LeadsHome(this.driver);
    }
}
