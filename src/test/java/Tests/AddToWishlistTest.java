package Tests;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.WishlistPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToWishlistTest extends TestBase{
    HomePage homeObject;
    SearchPage searchObject;
    WishlistPage wishlistObject;
    public String productname="apple-macbook-pro-13-inch";
    ProductDetailsPage productdetialsObject;
    String searchTxt ="Mac";

    @Test
    public void UserCanSearchAutoSuggest() {
        try {


            searchObject = new SearchPage(driver);
            searchObject.ProductSearchUsingAutoSuggest(searchTxt);
            productdetialsObject = new ProductDetailsPage(driver);
            Assert.assertEquals(productdetialsObject.productTitle.getText(), productname);

        } catch (Exception e) {
            System.out.println("Error occcured  " + e.getMessage());
        }

    }
    @Test
    public void UserCanAddToWishlist(){
        homeObject=new HomePage(driver);
        homeObject.addToWishlist();
        Assert.assertTrue(wishlistObject.productName.getText().contains("Apple MacBook Pro 13-inch"));
    }
    public void UserCanRemoveProductFromWishList(){
        wishlistObject=new WishlistPage(driver);
        wishlistObject.RemoveProductFromWishList();
        Assert.assertTrue(wishlistObject.sucessMesage.getText().contains("The wishlist is empty"));

    }
}

