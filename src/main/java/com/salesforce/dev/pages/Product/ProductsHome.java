package com.salesforce.dev.pages.Product;

import com.salesforce.dev.framework.CommonOperation;
import com.salesforce.dev.pages.Base.HomeBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by monica on 6/11/2015.
 */
public class ProductsHome extends HomeBase {
    @FindBy(xpath = "//h1[contains(.,'Products:')]")
    private WebElement productsSection;

    public ProductForm clickNewBtn() {
        CommonOperation.clickWebElement(newBtn);
        return new ProductForm(this.driver);
    }

    @Override
    protected Object clickNewViewLnk() {
        return null;
    }

    @Override
    protected Object clickEditViewLnk(String value) {
        return null;
    }

    public ProductDetails selectRecentItem(String value) {
        clickRecentItem(value);
        return new ProductDetails();
    }

    @Override
    protected Object selectRecentViewItem(String value) {
        return null;
    }

    public ProductDetails OpenProduct(String nameProduct) {
        super.driver.findElement(By.xpath("//a[contains(.,'" + nameProduct + "')]")).click();
        return new ProductDetails();
    }

    public boolean IsUserInProductsTab() {
        return CommonOperation.isElementPresent(productsSection);
    }

}