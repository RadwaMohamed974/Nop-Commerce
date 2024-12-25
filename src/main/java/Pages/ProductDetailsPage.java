package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver){
        super(driver);}

        @FindBy(css = "strong.current-item")
        public WebElement productTitle;
    @FindBy(className = "button-2 email-a-friend-button")
    WebElement emalifreindLink;
    @FindBy(id = "price-value-4")
    public WebElement productPrice;
    @FindBy(linkText ="Add your review")
    WebElement addReviewLink;
    @FindBy(className = "button-2 add-to-compare-list-button")
    WebElement addToCompareBtn;
    @FindBy(linkText = "product comparison")
    WebElement successMessageOfAddingToCompare;
    @FindBy(id = "add-to-cart-button-4")
    WebElement addToChartBtn;
    @FindBy(css="cart-label")
    WebElement shoppingCartLink;




    public void OpenEmailFriendPage(){
        clickButton(emalifreindLink);
    }
    public void OpenAddReviewLink(){
        clickButton(addReviewLink);
    }
    public void AddProductToComparePage(){
        clickButton(addToCompareBtn);
    }
    public void AddProductToChart(){
        clickButton( addToChartBtn);

    }
    public void OpenShoppingcartPage(){
        clickButton(shoppingCartLink);

    }





}
