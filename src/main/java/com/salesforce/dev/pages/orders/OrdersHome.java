package com.salesforce.dev.pages.orders;

import com.salesforce.dev.framework.selenium.CommonOperation;
import com.salesforce.dev.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class will be used to represent Order page and its options.
 *
 * @author marcelo
 * @since 6/22/2015.
 */
public class OrdersHome extends AbstractBasePage {

    @FindBy(xpath = "//h1[contains(.,'Orders:')]")
    private WebElement ordersSection;

    public boolean isUserInOrdersTab() {
        return CommonOperation.isWebElementVisible(ordersSection);
    }

}
