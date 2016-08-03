package com.salesforce.dev.pages;

import com.salesforce.dev.pages.base.AbstractBasePage;
import com.salesforce.dev.pages.base.NavigationBar;

/**
 * This class represents the main page of Salesforce.
 *
 * @author Jimmy Vargas.
 * @since 6/4/2015.
 */
public class MainPage extends AbstractBasePage {

    private NavigationBar navBar;

    private TopHeader topHeader;

    public MainPage() {
        topHeader = new TopHeader();
        navBar = new NavigationBar();
    }

    /**
     * This method sends to the top header.
     *
     * @return TopHeader.
     */
    public TopHeader gotoTopHeader() {
        return this.topHeader;
    }

    /**
     * Returns the navigation bar where all the HOMEs are located
     */
    public NavigationBar gotoNavBar() {
        return this.navBar;
    }
}
