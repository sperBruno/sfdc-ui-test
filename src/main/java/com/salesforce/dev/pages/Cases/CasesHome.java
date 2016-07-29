package com.salesforce.dev.pages.cases;

import com.salesforce.dev.framework.selenium.CommonOperation;
import com.salesforce.dev.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Monica Pardo on 6/24/2015.
 */
public class CasesHome extends AbstractBasePage {

    @FindBy(xpath = "//h1[contains(.,'Cases:')]")
    WebElement casesSection;

    public boolean IsUserInCasesTab() {
        return CommonOperation.isWebElementVisible(casesSection);
    }
}

