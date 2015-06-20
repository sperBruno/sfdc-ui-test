package com.salesforce.dev.pages.Product;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.DetailsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Monica on 6/11/2015.
 */
public class ProductDetails extends DetailsBase{


    @FindBy(id = "Name_ileinner")
    WebElement productNameReg;

    public ProductDetails(WebDriver driver){
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(super.driver,this);

    }
    public Object clickEditBtn(){
        super.clickEditButton();
        return new ProductDetails(driver);
    }

   public ProductsHome clickDeleteBtn(boolean confirmDeletion){
       super.clickDeleteButton(confirmDeletion);
       return new ProductsHome(driver);
   }


    public boolean VerifyProduct(String nameValue){
        String NameProductForm=productNameReg.getText();

        if(NameProductForm.equals(nameValue)){
            return true;
        }
        return false;
    }

}
