package com.salesforce.dev.pages.Leads;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.FormBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Jimmy Vargas on 6/15/2015.
 */
public class LeadForm extends FormBase {

    public LeadForm(WebDriver driver){
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(super.driver,this);
    }

    public Object clickSaveBtn(){
        super.clickSaveButton();
        return new LeadDetail(super.driver);
    }

    public Object clickSaveNewBtn(){
        super.clickSaveNewButton();
        return new LeadForm(super.driver);
    }

    public Object clickCancelBtn(){
        super.clickCancelButton();
        return new LeadsHome(super.driver);
    }

}
