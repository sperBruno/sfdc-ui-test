package com.salesforce.dev.pages;

import com.salesforce.dev.pages.base.AbstractBasePage;
import com.salesforce.dev.pages.base.NavigationBar;

/**
 * Created by Jimmy Vargas on 6/4/2015.
 */
public class MainPage extends AbstractBasePage {

    private NavigationBar navBar;

    private TopHeader topHeader;

    public MainPage() {
        topHeader = new TopHeader();
        navBar = new NavigationBar();
    }

    public TopHeader gotoTopHeader() {
        return this.topHeader;
    }

    /**
     * Returns the navigation bar where all the HOMEs are located
     *
     * @author: Jimmy Vargas
     */
    public NavigationBar gotoNavBar() {
        return this.navBar;
    }
}
