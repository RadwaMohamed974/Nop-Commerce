package Tests;

import Data.JsonDataReader;
import Pages.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CheckoutTest extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registrationObject;
    ShoppingCartPage shoppingCartObject;
    SearchPage searchObject;
    String searchTxt ="Mac";
    ProductDetailsPage productdetialsObject;
    public String productname="apple-macbook-pro-13-inch";
    CheckoutPage checkoutObject;
    OrderDetailsPage orderObject;


    @Test(priority = 1)
    public void UserCanRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.openRegisterPage();
        registrationObject = new UserRegistrationPage(driver);
        registrationObject.UserRegistration("Radwa", "Mohamed", "oadwa@gmail.com", "767654849");
        Assert.assertTrue(registrationObject.sucessMessage.getText().contains("Your registration completed"));
    }


    @Test(priority = 2)
    public void UserCanSearchAutoSuggest() {
            searchObject = new SearchPage(driver);
            searchObject.ProductSearchUsingAutoSuggest(searchTxt);
            searchObject.ProductSearch( productname);
            productdetialsObject = new ProductDetailsPage(driver);
            Assert.assertEquals(productdetialsObject.productTitle.getText(), productname);


    }
    @Test (priority = 3)
    public void AddProductToCartSuccessfully(){
        shoppingCartObject=new ShoppingCartPage(driver);
        productdetialsObject = new ProductDetailsPage(driver);
        productdetialsObject.AddProductToChart();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/"+"/cart");
        Assert.assertTrue(shoppingCartObject.productTotal.getText().contains("3,600.00"));

    }
    @Test(priority = 4)
    public void UserCanCheckout() throws IOException, ParseException {
        shoppingCartObject.OpenCheckoutPage();
        checkoutObject=new CheckoutPage(driver);
        String city= JsonDataReader.jsonData("checkout","city") ;
        String address= JsonDataReader.jsonData("checkout","address") ;
        String zip= JsonDataReader.jsonData("checkout","zip") ;
        String phone= JsonDataReader.jsonData("checkout","phone") ;

        checkoutObject.Checkout(city,address,zip,phone);
        Assert.assertTrue(checkoutObject.sucessMessgae.getText().contains("Thank You"));
        checkoutObject.OpenOrderDetailsPage();
        Assert.assertTrue(checkoutObject.sucessMessgae.getText().contains("ggg"));
       orderObject=new OrderDetailsPage(driver);
       orderObject.PrintOrderDetails();
       orderObject.DownloadPdfInvoice();



    }
}
