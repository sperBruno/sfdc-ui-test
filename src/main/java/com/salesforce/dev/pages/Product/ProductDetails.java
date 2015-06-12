package com.salesforce.dev.pages.Product;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by marcelo on 6/11/2015.
 */
public class ProductDetails {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "del")
    WebElement deletedBtn;
    @FindBy(name = "edit")
    WebElement editBtn;
    @FindBy(id = "Name_ileinner")
    WebElement productNameReg;

    public ProductDetails(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);

    }
    public ProductForm EditProduct(){
        editBtn.click();
        return new ProductForm(driver);
    }
    public boolean VerifyProduct(String nameValue){
        String Nameproductform=productNameReg.getText();

        if(Nameproductform.equals(nameValue)){
            return true;
        }
        return false;
    }
    public void DeleteProduct(){
        deletedBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }
}
