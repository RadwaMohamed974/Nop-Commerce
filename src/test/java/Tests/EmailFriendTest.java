package Tests;

import Data.JsonDataReader;
import Pages.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class EmailFriendTest extends TestBase{

    EmailFriendPage emailFriendObject;
    HomePage homeObject;
    UserRegistrationPage registrationObject ;
    SearchPage searchObject;
    ProductDetailsPage productdetialsObject;
    String searchTxt="Mac";

    public String productname="apple-macbook-pro-13-inch";

@Test (priority = 1)
    public void RegisteredUserCanSendEmailSuccessfully() {
    homeObject = new HomePage(driver);
    homeObject.openRegisterPage();
    registrationObject = new UserRegistrationPage(driver);
    registrationObject.UserRegistration("Radwa", "Mohamed", "oadwa@gmail.com", "767654849");

}
    @Test (priority = 2)
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
    @Test (priority = 3)
    public void RegistedUserCanSendEmail() throws IOException, ParseException {
        productdetialsObject.OpenEmailFriendPage();
        emailFriendObject=new EmailFriendPage(driver);
        String emailfriend= JsonDataReader.jsonData("sendemail","emailfriend") ;
        String emailaddress= JsonDataReader.jsonData("Register","emailaddress") ;
        String personalmessage= JsonDataReader.jsonData("Register","personalmessage") ;
        emailFriendObject.OnlyRegisteredUserSendEmail(emailfriend,emailaddress, personalmessage);
        Assert.assertTrue(emailFriendObject.successMessage.getText().contains("Your message has been sent."));
    }
//Logout to test send email without login
    @Test (priority = 4)
    public void UserCanLogout(){

        registrationObject.UserLogout();
    }
    @Test (priority = 5)
    public void NotRegistedUserCanSendEmail() throws IOException, ParseException {

        searchObject.ProductSearchUsingAutoSuggest(searchTxt);
        emailFriendObject=new EmailFriendPage(driver);
        String emailfriend= JsonDataReader.jsonData("sendemail","emailfriend") ;
        String emailaddress= JsonDataReader.jsonData("Register","emailaddress") ;
        String personalmessage= JsonDataReader.jsonData("Register","personalmessage") ;
        emailFriendObject.OnlyRegisteredUserSendEmail(emailfriend,emailaddress, personalmessage);
        Assert.assertTrue(emailFriendObject.successMessage.getText().contains("Your message has been sent."));
    }
}
