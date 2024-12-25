package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver)
    {
        super(driver);
        jsa = (JavascriptExecutor) driver;
        action=new Actions(driver);
    }
        @FindBy(linkText = "Register")
    WebElement registerLink;
        @FindBy(linkText = "Log in")
                WebElement loginLink;
        @FindBy (linkText= "Contact us")
        WebElement contactUsLink;
        @FindBy(id = "customerCurrency")
        WebElement currencyDrl;
        @FindBy(linkText="Computers")
        WebElement computerMenue;
    //ul[@class='top-menu notmobile']//a[normalize-space()='Notebooks']

        @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Notebooks']")
                WebElement notebookMenue;
        @FindBy(id ="add-to-wishlist-button-4")
        WebElement addToWishlistBtn;

        @FindBy(className = "wishlist-label")
        WebElement wishlistLink;



    public void openRegisterPage(){
            clickButton(registerLink);


        }
        public void OpenLoginPage(){
            clickButton(loginLink);
        }
        public void OpenContactUsPage(){
            ScrollToButton();
            clickButton(contactUsLink);

        }
    public void ChangeCurrecny(){
select=new Select(currencyDrl);
//select.selectByIndex(0);
        select.selectByVisibleText("Euro");

    }
    public void SelectNoteBookMenue(){

        action.moveToElement(computerMenue).moveToElement(notebookMenue).click().build().perform();
    }
    public void addToWishlist(){
        clickButton(addToWishlistBtn);
    }
    public void openWishlistPage(){
        clickButton(wishlistLink);
    }




}
