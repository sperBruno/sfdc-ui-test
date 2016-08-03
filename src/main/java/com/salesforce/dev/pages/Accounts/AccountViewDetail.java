package com.salesforce.dev.pages.accounts;

import com.salesforce.dev.pages.base.ViewDetailBase;

/**
 * This class will be used to represent Account view details and its options.
 *
 * @author Carlos Orellana.
 */
public class AccountViewDetail extends ViewDetailBase {

    @Override
    protected AccountView clickEditLnk() {
        clickEditLink();
        return new AccountView();
    }

    @Override
    public ViewDetailBase clickDeleteLnk() {
        clickDeleteLink();
        return this;
    }
}
