package com.salesforce.dev.pages.forecasts;

import com.salesforce.dev.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.selenium.CommonOperation.isWebElementVisible;

/**
 * Created by marcelo on 6/22/2015.
 */
public class ForecastsHome extends AbstractBasePage {
    @FindBy(xpath = "//h1[contains(.,'Introducing forecasts')]")
    WebElement forecastSection;


    public boolean IsUserInForecastsTab() {
        return isWebElementVisible(forecastSection);
    }

}
