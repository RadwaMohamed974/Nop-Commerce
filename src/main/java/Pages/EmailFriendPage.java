package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{
    public EmailFriendPage (WebDriver driver){
        super(driver);

    }
    @FindBy(id = "FriendEmail")
    WebElement friendEmailTxt;
    @FindBy(id="YourEmailAddress")
    WebElement emailAddressTxt;
    @FindBy(id="PersonalMessage")
    WebElement personalMessageTxt;
    @FindBy(css = "input.button-1 send-email-a-friend-button")
    WebElement sendEmailBtn;
    @FindBy(className = "result")
   public WebElement successMessage;
    public void OnlyRegisteredUserSendEmail(String friendEmail , String emailAddress,String personalMessage){
      setTextElemnetText(friendEmailTxt, friendEmail);
      setTextElemnetText(emailAddressTxt,emailAddress);
      setTextElemnetText(personalMessageTxt,personalMessage);
      clickButton(sendEmailBtn);
    }

}
