package com.salesforce.dev.pages.Solutions;

import com.salesforce.dev.framework.CommonOperation;
import com.salesforce.dev.pages.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Monica Pardo on 6/24/2015.
 */
public class SolutionsHome extends AbstractBasePage {

    @FindBy(xpath = "//h1[contains(.,'Solutions:')]")
    WebElement solutionSection;

    public boolean IsUserInSolutionsTab() {
        return CommonOperation.isWebElementVisible(solutionSection);
    }

}
