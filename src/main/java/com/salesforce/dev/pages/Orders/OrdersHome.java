package com.salesforce.dev.pages.orders;

import com.salesforce.dev.framework.selenium.CommonOperation;
import com.salesforce.dev.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by marcelo on 6/22/2015.
 */
public class OrdersHome extends AbstractBasePage {

    @FindBy(xpath = "//h1[contains(.,'Orders:')]")
    WebElement ordersSection;

    public boolean IsUserInOrdersTab() {
        return CommonOperation.isWebElementVisible(ordersSection);
    }

}
