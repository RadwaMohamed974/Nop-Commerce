package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{
    public  ShoppingCartPage (WebDriver driver){
        super(driver);
    }
    @FindBy(css = "remove-btn")
    WebElement removeLabel;
    @FindBy(id = "quantity-up-11231")
    WebElement qtyLabel;
    @FindBy(name ="continueshopping")
    WebElement continueShoppingBtn;
    @FindBy(css = "product-name")
    public WebElement productName;
    @FindBy(css = "product-subtotal")
    public WebElement productTotal;
    @FindBy(css = "no-data")
    public  WebElement removeProduct;
    @FindBy(id = "checkout")
    WebElement checkoutBtn;
    @FindBy(id = "termsofservice")
    WebElement termServiceCheckB;

    public void RemoveProductFromCart(){
        clickButton(removeLabel);
    }
    public void UpdateQuantityAndPrice(){
        clickButton(qtyLabel);
    }
    public void OpenCheckoutPage(){
        clickButton(termServiceCheckB);
        clickButton(checkoutBtn);
    }


}
