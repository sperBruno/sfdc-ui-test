package com.salesforce.dev.pages.solutions;

import com.salesforce.dev.framework.selenium.CommonOperation;
import com.salesforce.dev.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Monica Pardo on 6/24/2015.
 */
public class SolutionsHome extends AbstractBasePage {

    @FindBy(xpath = "//h1[contains(.,'solutions:')]")
    WebElement solutionSection;

    public boolean IsUserInSolutionsTab() {
        return CommonOperation.isWebElementVisible(solutionSection);
    }

}
