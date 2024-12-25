package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddToCompareListTest extends TestBase{
    HomePage homeObject;
    SearchPage searchObject;
    AddToComparePage compareObject;
    public String productname="apple-macbook-pro-13-inch";
    ProductDetailsPage productdetialsObject;
    String firstProduct ="Mac";
    String secondProduct="lenova";


    @Test(priority = 1)
    public void UserCanAddProductToCompareListSuccessfully() {
        searchObject = new SearchPage(driver);
        compareObject = new AddToComparePage(driver);
        productdetialsObject = new ProductDetailsPage(driver);

        searchObject.ProductSearchUsingAutoSuggest(firstProduct);
        Assert.assertEquals(productdetialsObject.productTitle.getText(), firstProduct);
        productdetialsObject.AddProductToComparePage();

        searchObject.ProductSearchUsingAutoSuggest(secondProduct);
        Assert.assertEquals(productdetialsObject.productTitle.getText(), secondProduct);
        productdetialsObject.AddProductToComparePage();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        driver.navigate().to("https://demo.nopcommerce.com/" + "/compareproducts");
        Assert.assertTrue(compareObject.firstProductName.getText().equals("Digital Storm VANQUISH 3 Custom Performance PC"));
        Assert.assertTrue(compareObject.secondProductName.getText().equals("Apple MacBook Pro 13-inch"));
        compareObject.UserCanAddProductToCompareList();


    }

    public void UserCanClearCompareList(){
            compareObject.ClearCompareList();
            Assert.assertTrue(compareObject.messageOfClear.getText().contains("You have no items to compare"));





    }
}
