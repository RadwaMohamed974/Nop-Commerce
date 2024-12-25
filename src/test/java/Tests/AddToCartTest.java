package Tests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddToCartTest extends TestBase{
    SearchPage searchObject;
    ShoppingCartPage shoppingCartObject;
    String searchTxt ="Mac";
    ProductDetailsPage productdetialsObject;
    public String productname="apple-macbook-pro-13-inch";

    @Test
    public void UserCanSearchAutoSuggest() {
        try {


            searchObject = new SearchPage(driver);
            searchObject.ProductSearchUsingAutoSuggest(searchTxt);
            searchObject.ProductSearch( productname);


            Assert.assertEquals(productdetialsObject.productTitle.getText(), productname);

        } catch (Exception e) {
            System.out.println("Error occcured  " + e.getMessage());
        }

    }
    @Test (priority = 1)
    public void AddProductToCartSuccessfully(){
        shoppingCartObject=new ShoppingCartPage(driver);
        productdetialsObject = new ProductDetailsPage(driver);
       productdetialsObject.AddProductToChart();
       driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
       driver.navigate().to("https://demo.nopcommerce.com/"+"/cart");
       Assert.assertTrue(shoppingCartObject.productTotal.getText().contains("3,600.00"));

    }
    @Test(priority = 2)
    public void UserCanRemoveProductFromCart(){
        shoppingCartObject.RemoveProductFromCart();
        Assert.assertTrue(shoppingCartObject.removeProduct.getText().contains("Your Shopping Cart is empty!"));

    }



}
