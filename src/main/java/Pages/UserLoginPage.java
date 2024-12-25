package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLoginPage extends PageBase {

    public UserLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    WebElement emailTxtBox;
    @FindBy(id = "Password")
    WebElement passwordTxtBox;
    @FindBy(css = "input.button-1.login-button")
    WebElement logingtn;
public void UserLogin( String email , String password)
{
    setTextElemnetText(emailTxtBox,email);
    setTextElemnetText(passwordTxtBox,password);
   clickButton(logingtn);
}
}
