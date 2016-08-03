package com.salesforce.dev.pages.contracts;

import com.salesforce.dev.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.selenium.CommonOperation.isWebElementVisible;

/**
 * This class will be used to represent Contract page and its options.
 *
 * @author marcelo
 * @since 6/22/2015.
 */
public class ContractsHome extends AbstractBasePage {

    @FindBy(xpath = "//h1[contains(.,'Contracts:')]")
    private WebElement contractsSection;

    /**
     * {@inheritDoc CommonOperation.isWebElementVisible}
     */
    public boolean IsUserInContractsTab() {
        return isWebElementVisible(contractsSection);
    }

}

