package com.salesforce.dev.pages.Dashboards;

import com.salesforce.dev.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.selenium.CommonOperation.isWebElementVisible;

/**
 * Created by Monica Pardo on 6/24/2015.
 */
public class DashboardsHome extends AbstractBasePage{

    @FindBy(id = "ext-gen3")
    WebElement dashboardSection;


    public boolean IsUserInDashboardsTab(){
       return isWebElementVisible(dashboardSection);
    }

}

