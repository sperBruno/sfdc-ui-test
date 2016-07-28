package com.salesforce.dev.pages.Reports;

import com.salesforce.dev.pages.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.CommonOperation.isWebElementVisible;

/**
 * Created by Monica Pardo on 6/24/2015.
 */
public class ReportsHome extends AbstractBasePage {

    @FindBy(id = "ext-gen3")
    WebElement reportSection;

    public boolean IsUserInReportsTab() {
        return isWebElementVisible(reportSection);
    }

}
