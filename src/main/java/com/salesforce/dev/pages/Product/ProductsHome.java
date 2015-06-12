package com.salesforce.dev.pages.Product;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by marcelo on 6/11/2015.
 */
public class ProductsHome {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(name = "new")
    WebElement newBtn;


    public ProductsHome(WebDriver driver){
        this.driver=driver;
        this.wait= DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
    public ProductForm clickNewProduct(){
        newBtn.click();
        return  new ProductForm(driver);
    }

    public void OpenProduct(String nameProduct){
        driver.findElement(By.xpath("//a[contains(.,'" + nameProduct + "')]")).click();

    }


}