package Tests;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends TestBase {
HomePage homeObject;
SearchPage searchObject;
    public String productname="apple-macbook-pro-13-inch";
ProductDetailsPage productdetialsObject;

@Test
    public void UserCanChangeCurrency(){
    homeObject=new HomePage(driver);
    homeObject.ChangeCurrecny();

}
@Test
    public void UserCanSearchAutoSuggest() {
        try {


            searchObject = new SearchPage(driver);
            searchObject.ProductSearchUsingAutoSuggest("Mac");
            productdetialsObject = new ProductDetailsPage(driver);
            Assert.assertEquals(productdetialsObject.productTitle.getText(), productname);
            Assert.assertTrue(productdetialsObject.productPrice.getText().contains("$"));

        } catch (Exception e) {
            System.out.println("Error occcured  " + e.getMessage());
        }

    }

}
