package Tests;

import Data.JsonDataReader;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductUsingAutoSuggest extends TestBase {
    SearchPage searchObject;
    String searchTxt ="Mac";
    ProductDetailsPage productdetialsObject;


    @Test
    public void UserCanSearchAutoSuggest() {
        try {


            searchObject = new SearchPage(driver);
            searchObject.ProductSearchUsingAutoSuggest(searchTxt);
            String productname= JsonDataReader.jsonData("search","productname") ;
            searchObject.ProductSearch( productname);
            productdetialsObject = new ProductDetailsPage(driver);

            Assert.assertEquals(productdetialsObject.productTitle.getText(), productname);

        } catch (Exception e) {
            System.out.println("Error occcured  " + e.getMessage());
        }

    }

}
