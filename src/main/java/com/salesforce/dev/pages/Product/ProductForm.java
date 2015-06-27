package com.salesforce.dev.pages.Product;


import com.salesforce.dev.pages.Base.FormBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.salesforce.dev.framework.DriverManager;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Monica Pardo on 6/10/2015.
 */
public class ProductForm  extends FormBase {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "Name")
    WebElement productNameField;

    @FindBy(id = "ProductCode")
    WebElement productCodeField;

    @FindBy(id = "Description")
    WebElement descField;

    @FindBy (id = "IsActive")
    WebElement activeOption;

    @FindBy(xpath = "//input[@title='Save']")
    WebElement saveBtn;

    private String prodName,prodCode,prodDesc;
    private boolean activeProduct;

    public ProductForm(WebDriver driver){
        this.driver=driver;
        this.wait= DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
    public ProductForm(ProductBuilder builder){
        this.driver= DriverManager.getInstance().getDriver();
        this.wait= DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        this.prodName=builder.getProductName();
        this.prodCode=builder.getProductCode();
        this.prodDesc=builder.getProductDesc();
        this.activeProduct=builder.getProductActive();

    }

    public Object clickSaveNewBtn() {
        return null;
    }


    public Object clickCancelBtn() {
        return null;
    }


    public ProductDetails saveProduct() {
        if (prodName != null) {
            setProductName(prodName);
        }
        if (prodCode != null) {
            setProductCode(prodCode);
        }
        if (prodDesc != null) {
            setProductDesc(prodDesc);
        }
        if (activeProduct !=true) {
            setProductActive();
        }

        return clickSaveBtn();
    }

    public ProductDetails clickSaveBtn() {
        saveBtn.click();
        return new ProductDetails(driver);
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


    public void setProductName(String name){
        wait.until(ExpectedConditions.visibilityOf(productNameField));
        productNameField.clear();
        productNameField.sendKeys(name);

    }

    public void setProductCode(String code){
        wait.until(ExpectedConditions.visibilityOf(productCodeField));
        productCodeField.clear();
        productCodeField.sendKeys(code);

    }
    public void setProductDesc(String desc){
        wait.until(ExpectedConditions.visibilityOf(descField));
        descField.clear();
        descField.sendKeys(desc);

    }

    public void setProductActive(){
        activeOption.click();

    }

    public ProductDetails SetProduct(String name,String code,String desc){
        productNameField.sendKeys(name);
        productCodeField.sendKeys(code);
        descField.sendKeys(desc);
        saveBtn.click();
        return new ProductDetails(driver);

    }


}
