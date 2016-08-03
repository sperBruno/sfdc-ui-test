package com.salesforce.dev.pages.dashboards;

import com.salesforce.dev.pages.base.AbstractBasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.selenium.CommonOperation.isWebElementVisible;

/**
 * This class will be used to represent Dashboard web page and its options.
 *
 * @author Monica Pardo
 * @since 6/24/2015.
 */
public class DashboardsHome extends AbstractBasePage{

    @FindBy(id = "ext-gen3")
    private WebElement dashboardSection;

    /**
     * {@inheritDoc CommonOperation.isWebElementVisible}
     */
    public boolean IsUserInDashboardsTab(){
       return isWebElementVisible(dashboardSection);
    }

}

