package com.salesforce.dev.pages.forecasts;

import com.salesforce.dev.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.selenium.CommonOperation.isWebElementVisible;

/**
 * This class will be used to represent Forecast page and its options.
 *
 * @author Marcelo
 * @since 6/22/2015.
 */
public class ForecastsHome extends AbstractBasePage {
    @FindBy(xpath = "//h1[contains(.,'Introducing Forecasts')]")
    private WebElement forecastSection;

    /**
     * {@inheritDoc}
     *
     * @return
     */
    public boolean isUserInForecastsTab() {
        return isWebElementVisible(forecastSection);
    }

}
