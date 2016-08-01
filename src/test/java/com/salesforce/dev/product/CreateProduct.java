package com.salesforce.dev.product;

import com.salesforce.dev.pages.HomePage;
import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.base.NavigationBar;
import com.salesforce.dev.pages.product.ProductBuilder;
import com.salesforce.dev.pages.product.ProductDetails;
import com.salesforce.dev.pages.product.ProductForm;
import com.salesforce.dev.pages.product.ProductsHome;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by Monica Pardo on 6/13/2015.
 */
public class CreateProduct {

    HomePage homePage;
    MainPage mainPage;
    NavigationBar navigationBar;
    private ProductsHome productsHome;
    private ProductForm productForm;
    private ProductDetails productDetails;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();

    }

    @Test(groups = {"Acceptance"}, dataProvider = "getProductValues")
    public void testCreateProduct(String productName, String prodCode, String prodDesc) {
        productsHome = navigationBar.goToProductsHome();
        productForm = productsHome.clickNewBtn();
        productForm = new ProductBuilder(productName)
                .setProductName(productName)
                .setProductCode(prodCode)
                .setProductDesc(prodDesc)
                .setProductActive(true).build();
        productDetails = productForm.saveProduct();
        assertTrue(productDetails.VerifyProduct(productName), "product Was not Created");

    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        productDetails.clickDeleteButton();
    }

    @DataProvider
    public Object[][] getProductValues() {
        return new Object[][]{{"New product", "Code", "this is an new product"}};
    }
}
