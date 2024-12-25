package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{
    public MyAccountPage(WebDriver driver){
        super(driver);
    }


    @FindBy(linkText ="Change password")
    WebElement changePasswordLink;

    @FindBy(id="OldPassword")
    WebElement oldPasswordTxtButn;
    @FindBy(id="NewPassword")
    WebElement newPasswordTxtButn;
    @FindBy(id="ConfirmNewPassword")
    WebElement confirmPasswordTxtButn;
    @FindBy(css="input.button-1.change-password-button")
    WebElement changePasswordButn;
    @FindBy(css="div.result")
    public WebElement resultLb1;

    public void OpenChangePasswordLink(){
        clickButton(changePasswordLink);
    }

    public void ChangePassword(String oldPassword, String newPassword){

        setTextElemnetText(oldPasswordTxtButn, oldPassword);
        setTextElemnetText(newPasswordTxtButn,newPassword);
        setTextElemnetText(confirmPasswordTxtButn,newPassword);
        clickButton(changePasswordButn);


    }


}
