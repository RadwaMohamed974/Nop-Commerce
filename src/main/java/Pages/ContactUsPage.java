package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{
    public ContactUsPage (WebDriver driver){
        super(driver);


    }
    @FindBy(id = "FullName")
    WebElement fullNameTxt;
    @FindBy(id = "Email")
    WebElement EmailTxt;
    @FindBy(id = "Enquiry")
    WebElement EnquriyTxt;
    @FindBy(className = "buttons")
    WebElement submitBtn;
    @FindBy(css = "div.result")
   public WebElement sucessMessage;

    public void ContactUs (String fullName,String yourEmail,String enquriy){
        setTextElemnetText(fullNameTxt,fullName);
        setTextElemnetText(EmailTxt,yourEmail);
        setTextElemnetText(EnquriyTxt,enquriy);
        clickButton(submitBtn);


    }

}
