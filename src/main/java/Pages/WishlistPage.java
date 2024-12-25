package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase{
    public WishlistPage(WebDriver driver){
        super(driver);
    }
    @FindBy(className = "product-name")
    public WebElement productName;
    @FindBy(className = "remove-btn")
    WebElement removeBtn;
    @FindBy(className = "updatecart")
   public WebElement sucessMesage;

    public void RemoveProductFromWishList(){
        clickButton( removeBtn);
    }


}
