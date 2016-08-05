package com.salesforce.dev.pages.reports;

import com.salesforce.dev.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.selenium.CommonOperation.isWebElementVisible;

/**
 * This class will be used to represent Reports page and its options.
 *
 * @author Monica Pardo
 * @since 6/24/2015.
 */
public class ReportsHome extends AbstractBasePage {

    @FindBy(id = "ext-gen3")
    private WebElement reportSection;

    public boolean isUserInReportsTab() {
        return isWebElementVisible(reportSection);
    }

}
