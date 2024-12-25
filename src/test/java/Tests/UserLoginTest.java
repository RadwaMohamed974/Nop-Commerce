package Tests;

import Data.JsonDataReader;
import Pages.HomePage;
import Pages.UserLoginPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserLoginTest extends TestBase{
HomePage homeObject;
    UserLoginPage UserLoginObject;
    @Test
    public void CanLoginSuccessfully () throws IOException, ParseException {
        homeObject=new HomePage(driver);
        homeObject.OpenLoginPage();
        String email= JsonDataReader.jsonData("login","email") ;
        String password= JsonDataReader.jsonData("login","password") ;
        UserLoginObject=new UserLoginPage(driver);
        UserLoginObject.UserLogin (email, password) ;

    }

}
