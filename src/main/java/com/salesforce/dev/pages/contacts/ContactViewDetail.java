package com.salesforce.dev.pages.contacts;

import com.salesforce.dev.framework.selenium.CommonOperation;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.base.ViewDetailBase;

/**
 * This class is used to represent Contact view details and its options.
 *
 * @author Veronica.
 */
public class ContactViewDetail extends ViewDetailBase {

    public ContactViewDetail() {
        CommonOperation.waitForWebElement(viewSelected);
    }

    @Override
    protected ContactView clickEditLnk() {
        clickEditLink();
        return new ContactView();
    }

    @Override
    public ContactViewDetail clickDeleteLnk() {
        clickDeleteLink();
        return this;
    }

    public MainPage gotoMainPage() {
        return new MainPage();
    }

}
