package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {


    public UserRegistrationPage(WebDriver driver) {
        super(driver);

    }
    //@FindBy  (className="cb-i")
   // WebElement humann ;
    @FindBy  (id="gender-male")
        WebElement genderRdBton ;
    @FindBy (id="FirstName")
    WebElement firstNameTxtBox;
    @FindBy (id="LastName")
    WebElement lastNameTxtBox;
    @FindBy (id="Email")
    WebElement emailTxtBox;
    @FindBy (id="Password")
    WebElement passTxtBox;
    @FindBy (id="ConfirmPassword")
    WebElement ConPassTxtBox;
    @FindBy (id="register-button")
    WebElement registerBtn;
    @FindBy (css="result")
    public WebElement sucessMessage;     // هخليه بابلك عشان هستخدمه في بابلك مش ف نفس البيدج دي
@FindBy(className = "ico-logout")
public WebElement logoutLink;
    @FindBy(linkText ="MyAccount")
    WebElement myAccountLink;

    public  void UserRegistration(String firstName ,String lastName ,String email ,String password)
    {
        // اليوز مفروض ياخدها من تيست عشان كده هعمل حركه الاسترنج ف بابلك عشان اقوله ياخدها من تيست

        //genderRdBton .click();
        clickButton(genderRdBton);
        //firstNameTxtBox.sendKeys("firstName");
        setTextElemnetText(firstNameTxtBox, firstName);
        setTextElemnetText(lastNameTxtBox,lastName);
        setTextElemnetText(emailTxtBox,email);
        setTextElemnetText(passTxtBox,password);
        setTextElemnetText(ConPassTxtBox,password);
        clickButton(registerBtn);

    }

public void UserLogout(){
        clickButton(logoutLink);
}
public void OpenMyAccountPage(){
        clickButton(myAccountLink);

}




}
