package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductReviewTest extends TestBase{
    HomePage homeObject;
    UserRegistrationPage registrationObject ;
    SearchPage searchObject;
    String searchTxt ="Mac";
    ProductDetailsPage productdetialsObject;

    ProductReviewPage productReviewObject;
    public String productname="apple-macbook-pro-13-inch";
    @Test (priority = 1)
    public  void UserCanRegisterSuccessfully()
    {
        homeObject=new HomePage(driver);
        homeObject.openRegisterPage();
        registrationObject=new UserRegistrationPage(driver);
        registrationObject.UserRegistration("Radwa","Mohamed","oadwa@gmail.com","767654849");
        Assert.assertTrue(registrationObject.sucessMessage.getText().contains("Your registration completed"));


    }
    @Test (priority = 2)
    public void UserCanSearchAutoSuggest() {
        try {


            searchObject = new SearchPage(driver);
            searchObject.ProductSearchUsingAutoSuggest(searchTxt);
            searchObject.ProductSearch(productname);
            productdetialsObject = new ProductDetailsPage(driver);

            Assert.assertEquals(productdetialsObject.productTitle.getText(), productname);

        } catch (Exception e) {
            System.out.println("Error occcured  " + e.getMessage());
        }
    }
    @Test (priority = 3)
        public void UserCanAddProductReview(){
        productReviewObject=new ProductReviewPage(driver);
        productReviewObject.AddReview("hhhh","hher");
        Assert.assertTrue(productReviewObject.sucessMessage.getText().contains("Product review ia successfully add"));

    }

}
