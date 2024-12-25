package Tests;

import Data.JsonDataReader;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Tests.TestBase;
import com.beust.ah.A;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchProductTest extends TestBase {
    SearchPage searchObject;
    ProductDetailsPage productdetialsObject;

@Test
    public void UserCanSearchForProject() throws IOException, ParseException {
        searchObject=new SearchPage(driver);
    String productname= JsonDataReader.jsonData("search","productname") ;
        searchObject.ProductSearch(productname);
    productdetialsObject=new ProductDetailsPage(driver);
     // Assert.assertTrue(productdetialsObject.productTitle.getText().equalsIgnoreCase( productname));
    Assert.assertEquals(productdetialsObject.productTitle.getText(),productname);
    }


}
