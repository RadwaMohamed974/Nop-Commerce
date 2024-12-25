package Tests;

import Pages.HomePage;
import Pages.MyAccountPage;
import Pages.UserLoginPage;
import Pages.UserRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registrationObject ;
    MyAccountPage MyAccoutObject ;
    UserLoginPage loginObject;
    String oldPassword;
    String newPassword ;



    @Test(priority = 1)
    public  void UserCanRegisterSuccessfully()
    {
        homeObject=new HomePage(driver);
        homeObject.openRegisterPage();
        registrationObject=new UserRegistrationPage(driver);
        registrationObject.UserRegistration("Radwa","Mohamed","Radwa@gmail.com","76854849");
        Assert.assertTrue(registrationObject.sucessMessage.getText().contains("Your registration completed"));

    }
    @Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
    public void UserCanChangePasswordSuccessfully (){
        registrationObject.OpenMyAccountPage();
        MyAccoutObject.OpenChangePasswordLink();
        MyAccoutObject=new MyAccountPage(driver);
        MyAccoutObject.ChangePassword("oldPassword","newPassword");
        Assert.assertTrue(MyAccoutObject. resultLb1.getText().contains("password was changed successfully"));
    }
    @Test (dependsOnMethods = {"UserCanChangePasswordSuccessfully"})
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
