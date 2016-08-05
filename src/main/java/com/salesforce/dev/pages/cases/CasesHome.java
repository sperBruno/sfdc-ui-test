package com.salesforce.dev.pages.cases;

import com.salesforce.dev.framework.selenium.CommonOperation;
import com.salesforce.dev.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.selenium.CommonOperation.isWebElementVisible;

/**
 * This class will be used to represent Cases page and its options.
 *
 * @author Monica Pardo.
 * @since 6/24/2015.
 */
public class CasesHome extends AbstractBasePage {

    @FindBy(xpath = "//h1[contains(.,'Cases:')]")
    private WebElement casesSection;

    /**
     * {@inheritDoc CommonOperation.isWebElementVisible}
     */
    public boolean IsUserInCasesTab() {
        return isWebElementVisible(casesSection);
    }
}

