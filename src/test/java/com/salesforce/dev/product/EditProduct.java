package com.salesforce.dev.product;

import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.base.NavigationBar;
import com.salesforce.dev.pages.product.ProductBuilder;
import com.salesforce.dev.pages.product.ProductDetails;
import com.salesforce.dev.pages.product.ProductForm;
import com.salesforce.dev.pages.product.ProductsHome;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Monica Pardo on 6/10/2015.
 * @author Bruno Barrios
 */


public class EditProduct {

    private ProductsHome productsHome;
    private ProductDetails productDetails;
    private ProductForm productForm;
    private MainPage mainPage;
    private NavigationBar navigationBar;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        final String productName = "New product";
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        productsHome = navigationBar.goToProductsHome();
        productForm = productsHome.clickNewBtn();
        ProductForm productForm = new ProductBuilder(productName)
                .setProductName(productName).build();
        productDetails = productForm.saveProduct();

    }

    @Test(groups = {"Acceptance"}, dataProvider = "getProductValues")
    public void testEditProduct(String productNewName, String prodNewCode, String prodNewDesc) {
        productDetails.clickEditBtn();
        ProductForm productForm = new ProductBuilder(productNewName)
                .setProductName(productNewName)
                .setProductCode(prodNewCode)
                .setProductDesc(prodNewDesc).build();
        productForm.setProductActive();
        productDetails = productForm.saveProduct();
        Assert.assertTrue(productDetails.VerifyProduct(productNewName), "product Name was not updated");

    }

    @AfterMethod
    public void tearDown() {
        productDetails.clickDeleteButton();

    }

    @DataProvider
    public Object[][] getProductValues() {
        return new Object[][]{{"New product update", "Codigo2", "this is an update product"}};
    }
}


