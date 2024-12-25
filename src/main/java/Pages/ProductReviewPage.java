package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{
    public ProductReviewPage (WebDriver driver){
        super(driver);
    }
    @FindBy(id="AddProductReview_Title")
    WebElement reviewTitleTxt;

    @FindBy(id="AddProductReview_ReviewText")
            WebElement reviewTxtTxt;
    @FindBy(id="addproductrating_4")
    WebElement ratingRdoBtn;
    @FindBy(id="add-review")
            WebElement submitBtn;
    @FindBy(className = "content")
     public WebElement sucessMessage;
    public void AddReview(String reviewTitle,String reviewMessage ){
         setTextElemnetText(reviewTitleTxt ,reviewTitle);
         setTextElemnetText(reviewTxtTxt,reviewMessage);
         clickButton(ratingRdoBtn);
         clickButton(submitBtn);


    }
}
