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
        PageFactory.initElements(super.driver,this);

    }

    public Object clickEditBtn(){
        super.clickEditButton();
        return new LeadForm(this.driver);
    }

    public Object clickDeleteBtn(boolean confirmDeletion){
        super.clickDeleteButton(confirmDeletion);
        return new LeadsHome(this.driver);
    }
}
