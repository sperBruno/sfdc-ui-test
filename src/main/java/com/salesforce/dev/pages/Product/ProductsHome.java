package com.salesforce.dev.pages.Product;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.salesforce.dev.pages.Base.*;
/**
 * Created by marcelo on 6/11/2015.
 */
public class ProductsHome extends TabPage  {
    WebDriver driver;
    WebDriverWait wait;


    public ProductsHome(WebDriver driver){
        this.driver=driver;
        this.wait= DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

     public ProductForm clickNewBtn() {
      clickNewButton();
      return new ProductForm(driver);
    }

    public ProductDetails selectRecentItem(String value) {
        clickRecentItem(value);
        return new ProductDetails(driver);
    }

    public void OpenProduct(String nameProduct){
        driver.findElement(By.xpath("//a[contains(.,'" + nameProduct + "')]")).click();

    }

}