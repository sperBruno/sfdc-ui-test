package com.salesforce.dev.pages.Product;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.salesforce.dev.pages.Base.*;
/**
 * Created by monica on 6/11/2015.
 */
public class ProductsHome extends HomeBase {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//h1[contains(.,'Products:')]")
    WebElement productsSection;

    public ProductsHome(WebDriver driver){
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(super.driver,this);
    }

     public ProductForm clickNewBtn() {
      super.wait.until(ExpectedConditions.visibilityOf(newBtn));
         newBtn.click();
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
        return new ProductDetails(this.driver);
    }

    @Override
    protected Object selectRecentViewItem(String value) {
        return null;
    }

    public ProductDetails OpenProduct(String nameProduct){
        super.driver.findElement(By.xpath("//a[contains(.,'" + nameProduct + "')]")).click();
        return new ProductDetails(this.driver);
    }
    public boolean IsUserInProductsTab(){
        try{

            wait.until(ExpectedConditions.visibilityOf(productsSection));
            return true;
        }
        catch (WebDriverException e){
            return false;
        }
    }

}