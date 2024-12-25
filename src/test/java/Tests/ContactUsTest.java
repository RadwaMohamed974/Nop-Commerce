package Tests;

import Data.JsonDataReader;
import Pages.ContactUsPage;
import Pages.HomePage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContactUsTest extends TestBase{
    HomePage homeObject;
    ContactUsPage contactUsObject;

            String sucessMessage ="Your enquiry has been successfully sent to the store owner";


    String enquriy="ffkjkkjg";

@Test
    public void UserCanContactUsSuccessfully() throws IOException, ParseException {
        homeObject=new HomePage(driver);
        homeObject.OpenContactUsPage();
        contactUsObject=new ContactUsPage(driver);
    String fullname= JsonDataReader.jsonData("contactus","fullname");
    String email= JsonDataReader.jsonData("contactus","email");
        contactUsObject.ContactUs(fullname,email,enquriy);
        Assert.assertTrue(contactUsObject.sucessMessage.getText().contains(sucessMessage));
    }
}





