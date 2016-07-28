package com.salesforce.dev.pages.Forecasts;

import com.salesforce.dev.pages.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.CommonOperation.isWebElementVisible;

/**
 * Created by marcelo on 6/22/2015.
 */
public class ForecastsHome extends AbstractBasePage {
    @FindBy(xpath = "//h1[contains(.,'Introducing Forecasts')]")
    WebElement forecastSection;


    public boolean IsUserInForecastsTab() {
        return isWebElementVisible(forecastSection);
    }

}
