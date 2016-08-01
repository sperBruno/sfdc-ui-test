package com.salesforce.dev.pages.product;

import java.util.Map;

import com.salesforce.dev.pages.base.DetailsBase;
import com.salesforce.dev.pages.base.FormBase;
import com.salesforce.dev.pages.base.HomeBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Monica on 6/11/2015.
 */
public class ProductDetails extends DetailsBase {


    @FindBy(id = "Name_ileinner")
    WebElement productNameReg;

    public FormBase clickEditBtn() {
        super.clickEditButton();
        return new ProductForm();
    }


    @Override
    public HomeBase clickDeleteButton() {
        clickDeletedButton();
        return new ProductsHome();
    }

    @Override
    public Map<Enum, Object> getAssertionMap() {
        return null;
    }


    public boolean VerifyProduct(String nameValue) {
        String NameProductForm = productNameReg.getText();

        if (NameProductForm.equals(nameValue)) {
            return true;
        }
        return false;
    }

}
