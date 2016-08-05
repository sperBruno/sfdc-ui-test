package com.salesforce.dev.pages.product;

import com.salesforce.dev.framework.selenium.CommonOperation;
import com.salesforce.dev.pages.base.AbstractBasePage;
import com.salesforce.dev.pages.base.HomeBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.selenium.CommonOperation.clickWebElement;
import static com.salesforce.dev.framework.selenium.CommonOperation.isElementPresent;

/**
 * This class will be used to represents product home page.
 *
 * @author monica
 * @since 6/11/2015.
 */
public class ProductsHome extends HomeBase {
    @FindBy(xpath = "//h1[contains(.,'Products:')]")
    private WebElement productsSection;

    @Override
    protected AbstractBasePage clickNewViewLnk() {
        return null;
    }

    @Override
    protected AbstractBasePage clickEditViewLnk(String value) {
        return null;
    }

    @Override
    protected AbstractBasePage selectRecentViewItem(String value) {
        return null;
    }

    public ProductForm clickNewBtn() {
        clickWebElement(newBtn);
        return new ProductForm();
    }

    public ProductDetails selectRecentItem(String value) {
        clickRecentItem(value);
        return new ProductDetails();
    }

    public ProductDetails OpenProduct(String nameProduct) {
        super.driver.findElement(By.xpath("//a[contains(.,'" + nameProduct + "')]")).click();
        return new ProductDetails();
    }

    public boolean IsUserInProductsTab() {
        return isElementPresent(productsSection);
    }

}