package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends HomePage{
    public SearchPage (WebDriver driver){
        super(driver);
    }
    @FindBy(id = "small-searchterms")
    WebElement searchTxtBox;
   @FindBy(id = "ui-id-1")
    List <WebElement> productList;   // عملت دي كده دا عباره عن ليست فيها حاجات كتيى وفي ان اسبكت مكتوب عليها ul
    @FindBy(xpath = "button[@type='submit' andtext()='Search']")
    WebElement searchBtn;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement productPage;





    public void ProductSearch( String productName){

       setTextElemnetText(searchTxtBox ,productName);
        //clickButton(productList);
        clickButton(searchBtn);

    }

    public void OpenProductDetailsPage(){
        clickButton(productPage);

    }
    public void ProductSearchUsingAutoSuggest(String searchTxt)
    {
       setTextElemnetText(searchTxtBox ,searchTxt);
       productList.get(0).click();
    }


}
