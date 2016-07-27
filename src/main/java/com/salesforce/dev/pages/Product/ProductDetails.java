package com.salesforce.dev.pages.Product;

import com.salesforce.dev.pages.Base.DetailsBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Monica on 6/11/2015.
 */
public class ProductDetails extends DetailsBase{


    @FindBy(id = "Name_ileinner")
    WebElement productNameReg;

    public Object clickEditBtn(){
        super.clickEditButton();
        return new ProductDetails();
    }

   public ProductsHome clickDeleteBtn(boolean confirmDeletion){
       super.clickDeleteButton(confirmDeletion);
       return new ProductsHome();
   }


    public boolean VerifyProduct(String nameValue){
        String NameProductForm=productNameReg.getText();

        if(NameProductForm.equals(nameValue)){
            return true;
        }
        return false;
    }

}
