package Tests;

import Data.JsonDataReader;
import Pages.HomePage;
import Pages.UserLoginPage;
import Pages.UserRegistrationPage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserRegistrationTest extends TestBase{
    HomePage homeObject;
    UserRegistrationPage registrationObject ;
    UserLoginPage loginObject;


   @Test (priority = 1)
    public  void UserCanRegisterSuccessfully() throws IOException, ParseException {
       homeObject=new HomePage(driver);
       homeObject.openRegisterPage();
       registrationObject=new UserRegistrationPage(driver);
       String firstname= JsonDataReader.jsonData("Register","firstname") ;
       String lastname= JsonDataReader.jsonData("Register","lastname") ;
       String email= JsonDataReader.jsonData("Register","email") ;
       String password= JsonDataReader.jsonData("Register","password") ;

       registrationObject.UserRegistration(firstname,lastname,email,password);
       Assert.assertTrue(registrationObject.sucessMessage.getText().contains("Your registration completed"));


   }
@Test (dependsOnMethods = {"UserCanRegisterSuccessfully"}) //(priority=2)
public void ResgistedUserCanLogout(){

    registrationObject.UserLogout();
}
@Test (dependsOnMethods = {"ResgistedUserCanLogout"})
public void ResisteredUserCanLogin(){
    loginObject=new UserLoginPage(driver);
    homeObject.OpenLoginPage();
    loginObject.UserLogin("RFRR","TTTT)");
    Assert.assertTrue(registrationObject.logoutLink.getText().contains("log out"));

}

}
